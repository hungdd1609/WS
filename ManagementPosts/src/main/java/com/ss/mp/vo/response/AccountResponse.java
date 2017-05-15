package com.ss.mp.vo.response;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.ss.mp.common.utils.MPBeanUtils;
import com.ss.mp.entity.Account;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class AccountResponse implements Serializable{

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

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 8036540769408365601L;
	
	private Integer id;
	
	private String userName;
	
	private String fullName;
	
	private String phoneNumber;
	
	private String email;
	
	private String avatar;
	
	public AccountResponse (Account account) {
		super();
		MPBeanUtils.copyPropertiesIgnoreNull(account, this);
	}

}
