package com.ss.mp.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.ss.mp.common.entity.BaseEntity;

@Entity
@Table(name = "account")
@Getter
@Setter
public class Account extends BaseEntity{

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6434182705306338358L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "user_name", nullable = false, length = 200)
	private String userName;
	
	@Column(name = "pass", nullable = false, length = 200)
	private String passWord;
	
	@Column(name = "full_name", length = 200)
	private String fullName;
	
	@Column(name = "phone_number", length = 200)
	private String phoneNumber;
	
	@Column(name = "email", length = 200)
	private String email;
	
	@Column(name = "avatar")
	private String avatar;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_role")
	private Role role;

}
