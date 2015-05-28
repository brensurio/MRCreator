package com.cevalogistics.view;

import com.cevalogistics.MainApp;
import com.cevalogistics.model.Employee;
import com.cevalogistics.util.DateUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class MRCreatorOverviewController {
	@FXML
	private TextField nameField;
	@FXML
	private TextField funcField;
	@FXML
	private ComboBox<String> deptChoice;
	@FXML
	private TextField notedbyField;
	@FXML
	private TextField item0QtyField;
	@FXML
	private TextField item0SNAField;
	@FXML
	private TextField item0DescField;
	@FXML
	private TextField item0CstField;
	@FXML
	private TextField item1QtyField;
	@FXML
	private TextField item1SNAField;
	@FXML
	private TextField item1DescField;
	@FXML
	private TextField item1CstField;
	@FXML
	private TextField item2QtyField;
	@FXML
	private TextField item2SNAField;
	@FXML
	private TextField item2DescField;
	@FXML
	private TextField item2CstField;
	@FXML
	private TextField item3QtyField;
	@FXML
	private TextField item3SNAField;
	@FXML
	private TextField item3DescField;
	@FXML
	private TextField item3CstField;
	@FXML
	private DatePicker datePicker;
	@FXML
	private ImageView cevaLogo;
	
	private ObservableList<String> deptChoiceData = FXCollections.observableArrayList();
	private MainApp mainApp;
	private Employee employee;
	
	public MRCreatorOverviewController() { 
		employee = new Employee();
		deptChoiceData.addAll("OCM/OPMD", "BUSINESS DEVT", "CUSTOMER SERVICE",
			"AIR EXPORT", "BREAKBULK", "ACCOUNTING", "CREDIT AND COLLECTION",
			"WAREHOUSE 1", "WAREHOUSE 2", "FACILITIES", "OCEAN EXPORT",
			"SEA IMPORT", "AIR IMPORT", "BILLING SECTION (MAI & MSI)",
			"DOMESTIC/ITDD", "LOCAL BOOKS/REGGA", "CASHIER", "HRD", "IS&S",
			"PURCHASING", "ZDS/LEAN/KAIZEN", "LAGUNA CL", "Cebu", "Baguio",
			"LAGUNA FM", "LAGUNA P&G", "Davao");
		deptChoiceData.sort(null); 
	}
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	private void initialize() {
		deptChoice.setItems(deptChoiceData);
		cevaLogo.setImage(new Image("file:resources/images/mainlogo.png"));
	}
	@FXML
	private void handleDate() {
		this.employee.setDate(DateUtil.format(datePicker.getValue()));
	}
	@FXML
	private void handleName() {
		this.employee.setName(nameField.getText());
	}
	@FXML
	private void handleDeptChoice() {
		this.employee.setDept(deptChoice.getSelectionModel().getSelectedItem());
	}
	@FXML
	private void handleFunc() {
		this.employee.setFunc(funcField.getText());
	}
	@FXML
	private void handleItem0Qty() {
		this.employee.getItem(0).setQuantity(item0QtyField.getText());
	}
	@FXML
	private void handleItem0SNA() {
		this.employee.getItem(0).setSnat(item0SNAField.getText());
	}
	@FXML
	private void handleItem0Desc() {
		this.employee.getItem(0).setItemName(item0DescField.getText());
	}
	@FXML
	private void handleItem0Cst() {
		this.employee.getItem(0).setCost(item0CstField.getText());
	}
	@FXML
	private void handleItem1Qty() {
		this.employee.getItem(1).setQuantity(item1QtyField.getText());
	}
	@FXML
	private void handleItem1SNA() {
		this.employee.getItem(1).setSnat(item1SNAField.getText());
	}
	@FXML
	private void handleItem1Desc() {
		this.employee.getItem(1).setItemName(item1DescField.getText());
	}
	@FXML
	private void handleItem1Cst() {
		this.employee.getItem(1).setCost(item1CstField.getText());
	}
	@FXML
	private void handleItem2Qty() {
		this.employee.getItem(2).setQuantity(item2QtyField.getText());
	}
	@FXML
	private void handleItem2SNA() {
		this.employee.getItem(2).setSnat(item2SNAField.getText());
	}
	@FXML
	private void handleItem2Desc() {
		this.employee.getItem(2).setItemName(item2DescField.getText());
	}
	@FXML
	private void handleItem2Cst() {
		this.employee.getItem(2).setCost(item2CstField.getText());
	}
	@FXML
	private void handleItem3Qty() {
		this.employee.getItem(3).setQuantity(item3QtyField.getText());
	}
	@FXML
	private void handleItem3SNA() {
		this.employee.getItem(3).setSnat(item3SNAField.getText());
	}
	@FXML
	private void handleItem3Desc() {
		this.employee.getItem(3).setItemName(item3DescField.getText());
	}
	@FXML
	private void handleItem3Cst() {
		this.employee.getItem(3).setCost(item3CstField.getText());
	}
	
	@FXML
	private void handleCreate() {
		if (employee.getName() == null || employee.getDept() == null || employee.getFunc() == null) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Data Error");
			alert.setHeaderText("Missing Data");
			alert.setContentText("Name, Department, and Function cannot be empty!");
			alert.showAndWait();
		} else {
		mainApp.getEmployeeList().add(this.employee);
		employee = new Employee();
		}
	}
	@FXML
	private void handleKeyBoardCreate(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			if (employee.getName() == null || employee.getDept() == null || employee.getFunc() == null) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Data Error");
				alert.setHeaderText("Missing Data");
				alert.setContentText("Name, Department, and Function cannot be empty!");
				alert.showAndWait();
			} else {
			mainApp.getEmployeeList().add(this.employee);
			employee = new Employee();
			}	
		}
	}
	
	@FXML
	private void handleSearch() {
		mainApp.showEmployeeListOverview(mainApp.getEmployeeList());
	}
	
	@FXML
	private void handleClearField() {
		nameField.clear();
		funcField.clear();
		notedbyField.clear();
		item0QtyField.clear();
		item0SNAField.clear();
		item0DescField.clear();
		item0CstField.clear();
		item1QtyField.clear();
		item1SNAField.clear();
		item1DescField.clear();
		item1CstField.clear();
		item2QtyField.clear();
		item2SNAField.clear();
		item2DescField.clear();
		item2CstField.clear();
		item3QtyField.clear();
		item3SNAField.clear();
		item3DescField.clear();
		item3CstField.clear();
	}
}