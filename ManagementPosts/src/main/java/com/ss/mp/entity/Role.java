package com.ss.mp.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ss.mp.common.entity.BaseEntity;

@Entity
@Table(name = "role")
@Getter
@Setter
public class Role extends BaseEntity{

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7376816132041259371L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "name", length = 45)
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	private List<Account> accounts = new ArrayList<>();

}
