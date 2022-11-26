package org.example.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class FileInfo {
    private SimpleStringProperty index = new SimpleStringProperty();
    private SimpleStringProperty fileName = new SimpleStringProperty();
    private SimpleStringProperty url = new SimpleStringProperty();
    private SimpleStringProperty status = new SimpleStringProperty();
    private SimpleStringProperty action = new SimpleStringProperty();
    private SimpleStringProperty pathToSave = new SimpleStringProperty();

    public FileInfo(String index, String fileName, String url, String status, String action, String pathToSave) {
        this.index.set(index);
        this.fileName.set(fileName);
        this.url.set(url);
        this.status.set(status);
        this.action.set(action);
        this.pathToSave.set(pathToSave);
    }

    public String getIndex() {
        return index.get();
    }

    public SimpleStringProperty indexProperty() {
        return index;
    }

    public void setIndex(String index) {
        this.index.set(index);
    }

    public String getFileName() {
        return fileName.get();
    }

    public SimpleStringProperty fileNameProperty() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName.set(fileName);
    }

    public String getUrl() {
        return url.get();
    }

    public SimpleStringProperty urlProperty() {
        return url;
    }

    public void setUrl(String url) {
        this.url.set(url);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public String getAction() {
        return action.get();
    }

    public SimpleStringProperty actionProperty() {
        return action;
    }

    public void setAction(String action) {
        this.action.set(action);
    }

    public String getPathToSave() {
        return pathToSave.get();
    }

    public SimpleStringProperty pathToSaveProperty() {
        return pathToSave;
    }

    public void setPathToSave(String pathToSave) {
        this.pathToSave.set(pathToSave);
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "index=" + index +
                ", fileName=" + fileName +
                ", url=" + url +
                ", status=" + status +
                ", action=" + action +
                ", pathToSave=" + pathToSave +
                '}';
    }
}
