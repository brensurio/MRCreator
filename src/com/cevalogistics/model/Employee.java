package com.cevalogistics.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Employee {
	private StringProperty name;
	private StringProperty dept;
	private StringProperty func;
	private ObservableList<Item> itemList;
	
	public Employee() {
		this(null, null, null, null);
	}
	
	public Employee(String name, String dept, String func, 
			ObservableList<Item> itemList) {
		this.name = new SimpleStringProperty(name);
		this.dept = new SimpleStringProperty(dept);
		this.func = new SimpleStringProperty(func);
		this.itemList = FXCollections.observableArrayList();
		for (int x = 0; x < 4; x++) {	
			this.itemList.add(new Item());
		}
	}
	
	public void setName(String name) {
		this.name.set(name);
	}
	
	public String getName() {
		return name.get();
	}
	
	public StringProperty nameProperty() {
		return name;
	}
	
	public void setDept(String dept) {
		this.dept.set(dept);
	}
	
	public String getDept() {
		return dept.get();
	}
	
	public StringProperty deptProperty() {
		return dept;
	}
	
	public void setFunc(String func) {
		this.func.set(func);
	}
	
	public String getFunc() {
		return func.get();
	}
	
	public StringProperty funcProperty() {
		return func;
	}
	
	public Item getItem(int itemNo) {
		return itemList.get(itemNo);
	}
}