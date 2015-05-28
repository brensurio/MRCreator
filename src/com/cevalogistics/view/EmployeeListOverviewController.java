package com.cevalogistics.view;

import java.util.Optional;

import com.cevalogistics.model.Employee;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class EmployeeListOverviewController {
	@FXML
	private TableView<Employee> employeeTable;
	@FXML
	private TableColumn<Employee, String> nameColumn;
	@FXML
	private Label nameLabel;
	@FXML
	private Label deptLabel;
	@FXML
	private Label funcLabel;
	@FXML
	private Label item1Desc;
	@FXML
	private Label item1Snat;
	@FXML
	private Label item1Quan;
	@FXML
	private Label item1Cost;
	@FXML
	private Label item2Desc;
	@FXML
	private Label item2Snat;
	@FXML
	private Label item2Quan;
	@FXML
	private Label item2Cost;
	@FXML
	private Label item3Desc;
	@FXML
	private Label item3Snat;
	@FXML
	private Label item3Quan;
	@FXML
	private Label item3Cost;
	@FXML
	private Label item4Desc;
	@FXML
	private Label item4Snat;
	@FXML
	private Label item4Quan;
	@FXML
	private Label item4Cost;
	@FXML
	private Label dateBorrowed;
	
	private Stage dialogStage;
	private Employee employee;
	
	@FXML
	private void initialize() {
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		employeeTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
			showEmployeeDetails(newValue);
		});
	}
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	public void setEmployeeList(ObservableList<Employee> employeeList) {
		employeeTable.setItems(employeeList);
	}
	
	public void showEmployeeDetails(Employee tempEmployee) {
		if (tempEmployee != null) {
			employee = employeeTable.getSelectionModel().getSelectedItem();
			nameLabel.setText(employee.getName());
			deptLabel.setText(employee.getDept());
			funcLabel.setText(employee.getFunc());
			item1Desc.setText(employee.getItem(0).getItemName());
			item1Snat.setText(employee.getItem(0).getSnat());
			item1Quan.setText(employee.getItem(0).getQuantity());
			item1Cost.setText(employee.getItem(0).getCost());
			item2Desc.setText(employee.getItem(1).getItemName());
			item2Snat.setText(employee.getItem(1).getSnat());
			item2Quan.setText(employee.getItem(1).getQuantity());
			item2Cost.setText(employee.getItem(1).getCost());
			item3Desc.setText(employee.getItem(2).getItemName());
			item3Snat.setText(employee.getItem(2).getSnat());
			item3Quan.setText(employee.getItem(2).getQuantity());
			item3Cost.setText(employee.getItem(2).getCost());
			item4Desc.setText(employee.getItem(3).getItemName());
			item4Snat.setText(employee.getItem(3).getSnat());
			item4Quan.setText(employee.getItem(3).getQuantity());
			item4Cost.setText(employee.getItem(3).getCost());
			dateBorrowed.setText(employee.getDate());
		} else {
			nameLabel.setText(null);
			deptLabel.setText(null);
			funcLabel.setText(null);
			item1Desc.setText(null);
			item1Snat.setText(null);
			item1Quan.setText(null);
			item1Cost.setText(null);
			item2Desc.setText(null);
			item2Snat.setText(null);
			item2Quan.setText(null);
			item2Cost.setText(null);
			item3Desc.setText(null);
			item3Snat.setText(null);
			item3Quan.setText(null);
			item3Cost.setText(null);
			item4Desc.setText(null);
			item4Snat.setText(null);
			item4Quan.setText(null);
			item4Cost.setText(null);
			dateBorrowed.setText(null);
		}
	}
	
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}
	@FXML
	private void handleKeyBoardCancel(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			dialogStage.close();
		}
	}
	
	@FXML
	private void handleDelete() {
		int selectedIndex = employeeTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirm Delete");
			alert.setHeaderText("Data will be deleted");
			alert.setContentText("Data will be removed from records");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK) {
				employeeTable.getItems().remove(selectedIndex);
			}
		} else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(dialogStage);
			alert.setTitle("No Selection");
			alert.setHeaderText("No Employee Selected");
			alert.setContentText("Please select an employee from the table");
			alert.showAndWait();
		}
	}
	@FXML
	private void handleKeyBoardDelete(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			int selectedIndex = employeeTable.getSelectionModel().getSelectedIndex();
			if (selectedIndex >= 0) {
				employeeTable.getItems().remove(selectedIndex);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.initOwner(dialogStage);
				alert.setTitle("No Selection");
				alert.setHeaderText("No Employee Selected");
				alert.setContentText("Please select an employee from the table");
				alert.showAndWait();
			}
		}
	}
}