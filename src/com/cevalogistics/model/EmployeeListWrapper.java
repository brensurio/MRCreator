package com.cevalogistics.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employeeList")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeListWrapper {
	private List<Employee> employeeList;
	
	@XmlElement(name = "employee")
	public List<Employee> getEmployees() {
		return employeeList;
	}
	
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
}