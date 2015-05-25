package com.cevalogistics.view;

import java.io.File;

import com.cevalogistics.MainApp;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

public class RootLayoutController {

	private MainApp mainApp;
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	@FXML
	private void handleNew() {
		mainApp.getEmployeeList().clear();
		mainApp.setEmployeeListFilePath(null);
	}
	
	@FXML
	private void handleOpen() {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML file (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);
		File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());
		
		if (file != null) {
			mainApp.loadEmployeeListFromFile(file);
		}
	}
	
	@FXML
	private void handleSave() {
		File employeeFile = mainApp.getEmployeeListFilePath();
		if (employeeFile != null) {
			mainApp.saveEmployeeListToFile(employeeFile);
		} else {
			handleSaveAs();
		}
	}
	
	@FXML
	private void handleSaveAs() {
		FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            mainApp.saveEmployeeListToFile(file);
        }
	}

	@FXML
	private void handleAbout() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("MRCreator");
		alert.setHeaderText("About");
		alert.setContentText("Author: Bren Louis M. Surio\n");
		alert.showAndWait();
	}
	
	@FXML
	private void handleClose() {
		Platform.exit();
	}
}
