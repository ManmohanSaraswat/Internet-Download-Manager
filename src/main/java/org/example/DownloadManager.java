package org.example;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableIntegerValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import org.example.config.AppConfig;
import org.example.model.FileInfo;
import java.io.File;

public class DownloadManager {
    public int index = 0;
    @FXML
    private TextField urlTextField;

    @FXML
    private TableView<FileInfo> tableView;
    @FXML
    void downloadButtonClicked(ActionEvent event){
        String url = urlTextField.getText().trim();
        String fileName = url.substring(url.lastIndexOf("/") + 1);
        String status = "STARTING";
        String action = "OPEN";
        String path = AppConfig.DOWNLOAD_PATH + File.separator + fileName;
        FileInfo fileInfo = new FileInfo((index + 1) + "", fileName, url, status, action, path);
        DownloadThread thread = new DownloadThread(fileInfo, this);
        this.tableView.getItems().add(fileInfo);
        this.index += 1;
        thread.start();
    }

    @FXML
    public void initialize(){
        System.out.println("View initialized");
        ObservableList<TableColumn<FileInfo, ?>> columns = this.tableView.getColumns();
        TableColumn<FileInfo, String> sNo = (TableColumn<FileInfo, String>) columns.get(0);
        sNo.setCellValueFactory(p -> p.getValue().indexProperty());

        TableColumn<FileInfo, String> fileName = (TableColumn<FileInfo, String>) columns.get(1);
        fileName.setCellValueFactory(p -> p.getValue().fileNameProperty());

        TableColumn<FileInfo, String> url = (TableColumn<FileInfo, String>) columns.get(2);
        url.setCellValueFactory(p -> p.getValue().urlProperty());

        TableColumn<FileInfo, String> status = (TableColumn<FileInfo, String>) columns.get(3);
        status.setCellValueFactory(p -> p.getValue().statusProperty());

        TableColumn<FileInfo, String> action = (TableColumn<FileInfo, String>) columns.get(4);
        action.setCellValueFactory(p -> p.getValue().actionProperty());
    }

    public void updateUI(FileInfo fileInfo) {
        System.out.println(fileInfo);
        this.tableView.refresh();
    }
}
