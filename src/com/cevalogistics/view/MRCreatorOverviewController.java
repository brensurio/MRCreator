package com.cevalogistics.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cevalogistics.MainApp;
import com.cevalogistics.model.Employee;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
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
	private void handlePrint() throws Exception {
		FileInputStream file = new FileInputStream(new File("C:\\testbook.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet mainForm = workbook.getSheetAt(0);
		XSSFCellStyle style = workbook.createCellStyle();
		XSSFCellStyle style2 = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		XSSFRow row;
		XSSFCell cell;
		//Initialize rows and columns
		for (int x = 8; x < 12; x++) {
			row =  mainForm.createRow(x);
			//Initialize cells per rows
			for (int y = 0; y < 10; y++) {
				cell = mainForm.getRow(x).createCell(y);
			}
			
		}
		for (int x = 14; x < 18; x++) {
			row = mainForm.createRow(x);
			for (int y = 0; y < 10; y++) {
				cell = mainForm.getRow(x).createCell(y);
			}
		}
		row  = mainForm.createRow(37);
		row = mainForm.createRow(47);
		
		style2.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		XSSFCell nameCell = mainForm.getRow(8).getCell(1);
		nameCell.setCellType(Cell.CELL_TYPE_STRING);
		XSSFCell deptCell = mainForm.getRow(9).getCell(4);
		deptCell.setCellType(Cell.CELL_TYPE_STRING);
		deptCell.setCellStyle(style2);
		XSSFCell funcCell = mainForm.getRow(10).getCell(4);
		funcCell.setCellType(Cell.CELL_TYPE_STRING);
		funcCell.setCellStyle(style2);
		XSSFCell notedByCell = mainForm.getRow(37).createCell(2);
		notedByCell.setCellStyle(style2);
		XSSFCell dateCell = mainForm.getRow(47).createCell(2);
		
		cell = mainForm.getRow(8).getCell(0);
		cell.setCellValue("I, ");
		cell = mainForm.getRow(8).getCell(4);
		font.setFontHeight(10);
		style.setFont(font);
		cell.setCellValue(", hereby acknowledge receipt of the company property/ies described hereunder,");
		cell.setCellStyle(style);
		cell = mainForm.getRow(9).getCell(0);
		cell.setCellValue("for the exclusive and official use of ");
		cell = mainForm.getRow(9).getCell(7);
		cell.setCellValue("department/branch for my use in the");
		cell = mainForm.getRow(10).getCell(0);
		cell.setCellValue("performance of my official functions as ");
		cell = mainForm.getRow(10).getCell(7);
		cell.setCellValue("subject to the company's policies");
		cell = mainForm.getRow(11).getCell(0);
		cell.setCellValue("on accountability.");
		cell = mainForm.getRow(47).createCell(0);
		cell = mainForm.getRow(47).getCell(0);
		cell.setCellValue("Date Issued:");
		
		nameCell.setCellValue((String) employee.getName());
		deptCell.setCellValue("aba naman");
		funcCell.setCellValue(employee.getFunc());
		notedByCell.setCellValue("Agnes Benedicto");
		
		FileOutputStream out = new FileOutputStream("C:\\testbook.xlsx");
		workbook.write(out);
		out.close();
	}
}