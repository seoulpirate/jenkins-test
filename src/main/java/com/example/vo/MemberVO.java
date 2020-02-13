package com.example.vo;

public class MemberVO {
	private String userid;
	private String username;
	private int age;
	private String gender;
	private String city;
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", username=" + username + ", age=" + age + ", gender=" + gender
				+ ", city=" + city + "]";
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public MemberVO(String userid, String username, int age, String gender, String city) {
		super();
		this.userid = userid;
		this.username = username;
		this.age = age;
		this.gender = gender;
		this.city = city;
	}
	public MemberVO() {
		super();
	}
}
