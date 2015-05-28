package com.cevalogistics.model;

import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employee {
	private StringProperty name;
	private StringProperty dept;
	private StringProperty func;
	private StringProperty date;
	private ArrayList<Item> itemList;
	
	public Employee() {
		this(null, null, null, null, null);
	}
	
	public Employee(String name, String dept, String func, 
			ArrayList<Item> itemList, String date) {
		this.name = new SimpleStringProperty(name);
		this.dept = new SimpleStringProperty(dept);
		this.func = new SimpleStringProperty(func);
		this.itemList = new ArrayList<Item>();
		for (int x = 0; x < 4; x++) {	
			this.itemList.add(new Item());
		}
		this.date = new SimpleStringProperty(date);
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
	
	public void setDate(String date) {
		this.date.set(date);
	}
	
	public String getDate() {
		return date.get();
	}
	
	public StringProperty dateProperty() {
		return date;
	}
	
	public Item getItem(int itemNo) {
		return itemList.get(itemNo);
	}
	
	public ArrayList<Item> getItemList() {
		return itemList;
	}
	
	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}
}