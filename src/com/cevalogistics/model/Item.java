package com.cevalogistics.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Item {
	private StringProperty quantity;
	private StringProperty snat;
	private StringProperty itemName;
	private StringProperty cost;
	
	public Item() {
		this(null, null, null, null);
	}
	
	public Item(String quantity, String snat, String itemName, String cost) {
		this.quantity = new SimpleStringProperty(quantity);
		this.snat = new SimpleStringProperty(snat);
		this.itemName = new SimpleStringProperty(itemName);
		this.cost = new SimpleStringProperty(cost);
	}
	
	public void setQuantity(String quantity) {
		this.quantity.set(quantity);
	}
	
	public String getQuantity() {
		return quantity.get();
	}
	
	public StringProperty quantityProperty() {
		return quantity;
	}
	
	public void setSnat(String snat) {
		this.snat.set(snat);
	}
	
	public String getSnat() {
		return snat.get();
	}
	
	public StringProperty snatProperty() {
		return snat;
	}
	
	public void setItemName(String itemName) {
		this.itemName.set(itemName);
	}
	
	public String getItemName() {
		return itemName.get();
	}
	
	public StringProperty itemNameProperty() {
		return itemName;
	}
	
	public void setCost(String cost) {
		this.cost.set(cost);
	}
	
	public String getCost() {
		return cost.get();
	}
	
	public StringProperty costProperty() {
		return cost;
	}
}