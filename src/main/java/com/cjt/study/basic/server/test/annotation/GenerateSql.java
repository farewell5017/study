package com.cjt.study.basic.server.test.annotation;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 注解 模拟简单jdbc
 * 
 * @author 308655 cjt
 * @date 2016年10月11日 上午10:37:18
 */
public class GenerateSql {

	public static void main(String[] args) throws Exception, Exception {
		UserEntity user = new UserEntity();
		// user.setAge(19);
		user.setEmail("cuijiateng@qq.com");
		user.setHomeProvince("安徽,上海,浙江");
		user.setName("张三,李四");
		// user.setSex("男");
		String sql1 = doGenerate(user);
		System.out.println(sql1);
		List<UserEntity> list = doQuery(sql1);
		for (UserEntity userEntity : list) {
			System.out.println(userEntity.toString());
		}
		System.out.println("正常结束!");
	}

	/**
	 * 拼接sql
	 * 
	 * @author 308655 cjt
	 * @date 2016年10月11日 上午10:38:47
	 * @param user
	 * @return
	 * @throws NoSuchMethodException
	 * @throws Exception
	 */
	private static String doGenerate(UserEntity user) throws NoSuchMethodException, Exception {
		@SuppressWarnings("unchecked")
		Class<UserEntity> forName = (Class<UserEntity>) Class
				.forName("com.cjt.study.basic.server.test.annotation.UserEntity");
		System.out.println("forName =" + forName);
		System.out.println("forName.getName()=" + forName.getName());
		System.out.println("forName.getCanonicalName()=" + forName.getCanonicalName());
		System.out.println("forName.getModifiers()=" + forName.getModifiers());
		System.out.println("forName.getSimpleName()=" + forName.getSimpleName());
		StringBuffer sql = new StringBuffer();
		Class<? extends UserEntity> c = user.getClass();
		boolean isExist = c.isAnnotationPresent(Table.class);
		if (!isExist) {
			throw new IllegalArgumentException("不支持的注解类型!");
		}
		Table tableName = c.getAnnotation(Table.class);
		sql.append("select * from ").append(tableName.value()).append(" where 1=1 ");
		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			boolean existFieldAnno = field.isAnnotationPresent(Column.class);
			if (existFieldAnno) {
				Column column = field.getAnnotation(Column.class);
				field.setAccessible(true);
				Object object = field.get(user);
				if (object != null && object instanceof String) {
					sql.append(" and ").append(column.value());
					String str = (String) object;
					if (str.contains(",")) {
						String[] strArr = str.split(",");
						sql.append(" in (");
						for (String string : strArr) {
							sql.append("'").append(string).append("'").append(",");
						}
						sql.deleteCharAt(sql.length() - 1);
						sql.append(")");
					} else {
						sql.append("='").append(str).append("'");
					}
				}
				if (object != null && object instanceof Integer) {
					sql.append(" and ").append(column.value()).append("=").append((Integer) object);
				}
			}
		}
		return sql.toString();
	}

	/**
	 * jdbc执行数据库查询
	 * 
	 * @author 308655 cjt
	 * @date 2016年10月11日 上午10:39:08
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	private static List<UserEntity> doQuery(String sql) throws Exception {
		ArrayList<UserEntity> list = new ArrayList<UserEntity>();
		UserEntity user = new UserEntity();
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/study";
		String username = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, username, password);
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			user.setName(rs.getString("name"));
			user.setAge(rs.getInt("age"));
			user.setEmail(rs.getString("email"));
			user.setHomeProvince(rs.getString("home_province"));
			user.setSex(rs.getString("sex"));
			list.add(user);
		}
		return list;
	}
}
