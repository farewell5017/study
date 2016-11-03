package com.cjt.study.basic.server.servlet;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.cjt.study.basic.domain.RequestVo;
import com.cjt.study.basic.domain.ResponseVo;
import com.cjt.study.utils.FastJsonUtil;
import com.cjt.study.utils.SecurityUtil;

/**
 * Servlet implementation class TestInfoPushServlet
 */
public class TestInfoPushServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getStreamParam(request);
		RequestVo requestVo = getTotalRequestParams(request);
		ResponseVo responseVo = new ResponseVo();
		responseVo = doValidate(requestVo);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(FastJsonUtil.toJSONString(responseVo));
		out.flush();
		out.close();
	}

	/**
	 * @author 308655
	 * @date 2016-8-3 下午12:56:41
	 * @param requestVo
	 * @return
	 * @see
	 */
	private ResponseVo doValidate(RequestVo requestVo) {
		ResponseVo responseVo = new ResponseVo();
		responseVo.setResulCode("2006");
		responseVo.setResult("false");
		String companyCode = requestVo.getCompanyCode();
		String digest = requestVo.getDigest();
		String params = requestVo.getParams();
		String timestamp = requestVo.getTimestamp();
		if (StringUtils.isBlank(companyCode)) {
			System.out.println("公司编码校验失败!");
			responseVo.setReason("公司编码校验失败!");
			return responseVo;
		}
		if (StringUtils.isBlank(params)) {
			System.out.println("参数校验失败!");
			responseVo.setReason("参数校验失败!");
			return responseVo;
		}
		if (StringUtils.isBlank(timestamp) || !NumberUtils.isNumber(timestamp)) {
			System.out.println("时间戳校验失败!");
			responseVo.setReason("时间戳校验失败!");
			return responseVo;
		} else {
			long now = System.currentTimeMillis();
			long sendTime = Long.parseLong(timestamp);
			if (Math.abs(now - sendTime) > 30 * 1000) {
				responseVo.setReason("时间戳校验失败!");
			}
		}
		String createDigest = SecurityUtil.getDigest(params + "deppontest" + timestamp);
		if (StringUtils.isBlank(digest) || !digest.equals(createDigest)) {
			System.out.println("摘要校验失败!");
			responseVo.setReason("摘要校验失败!");
			return responseVo;
		}
		responseVo.setReason("成功!");
		responseVo.setResulCode("1000");
		responseVo.setResult("true");
		return responseVo;
	}

	private RequestVo getTotalRequestParams(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		@SuppressWarnings("unchecked")
		Enumeration<String> enumeration = request.getParameterNames();
		while (enumeration.hasMoreElements()) {
			String key = String.valueOf(enumeration.nextElement());
			String value = request.getParameter(key);
			map.put(key, value);
		}
		System.out.println("全部请求参数:" + FastJsonUtil.toJSONString(map) + "   "
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(System.currentTimeMillis()));
		RequestVo requestVo = new RequestVo();
		requestVo.setCompanyCode(map.get("companyCode"));
		requestVo.setDigest(map.get("digest"));
		requestVo.setParams(map.get("params"));
		requestVo.setTimestamp(map.get("timestamp"));
		return requestVo;
	}

	private String getStreamParam(HttpServletRequest request) throws IOException {
		String result = "";
		ServletInputStream inputStream = null;
		try {
			inputStream = request.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
		char[] a = new char[1024];
		int temp = 0;
		while ((temp = reader.read(a)) != -1) {
			result = result + new String(a, 0, temp);
		}
		System.out.println(result);
		return result;
	}
}
