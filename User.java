package com.main.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="user")
public class User {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	 
	@NotEmpty(message="please Enter full Name like Deepak Kumar")
	private String user_name;
	
	@NotNull
	@Min(value=21,message="Enter The enter age of above 21")
	private int uage;
	@NotEmpty (message="Enter The city")
	private String ucity;
	@NotEmpty(message="Enter The username __@gmail.com")
	@Column(unique = true)
	@Email(message="Enter The username __@gmail.com")
	private String username;
	@NotEmpty
	@Size(min=4,message="Please Enter password size 4 to 20 char ")
	private String upwd;

	public User(int uid,String user_name,  int uage, String ucity, String username, String upwd) {
		super();
		this.uid = uid;
		this.user_name=user_name;
		this.uage = uage;
		this.ucity = ucity;
		this.username = username;
		this.upwd = upwd;
	}

	public User() {
		super();
	}

	public  int getUid() {
		return uid;
	}
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getUage() {
		return uage;
	}

	public void setUage(int uage) {
		this.uage = uage;
	}

	public String getUcity() {
		return ucity;
	}

	public void setUcity(String ucity) {
		this.ucity = ucity;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

}
