package com.uni.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
	@Id
	private int dId;
	private String dName;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<Employee> e = new HashSet<>();

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public Set<Employee> getE() {
		return e;
	}

	public void setE(Set<Employee> e) {
		this.e = e;
	}	
	
	
}
