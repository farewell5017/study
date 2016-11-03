package com.cjt.study.basic.server.test.annotation;

@Table("t_user")
public class UserEntity {
	@Column("name")
	private String name;
	@Column("sex")
	private String sex;
	@Column("email")
	private String email;
	@Column("home_province")
	private String homeProvince;
	@Column("age")
	private Integer age;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the homeProvince
	 */
	public String getHomeProvince() {
		return homeProvince;
	}

	/**
	 * @param homeProvince
	 *            the homeProvince to set
	 */
	public void setHomeProvince(String homeProvince) {
		this.homeProvince = homeProvince;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserEntity [name=" + name + ", sex=" + sex + ", email=" + email + ", homeProvince=" + homeProvince
				+ ", age=" + age + "]";
	}

}
