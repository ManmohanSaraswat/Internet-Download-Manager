package org.example;

import org.example.model.FileInfo;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadThread extends Thread{
    private FileInfo fileInfo;
    private DownloadManager downloadManager;

    public DownloadThread(FileInfo fileInfo, DownloadManager manager){
        this.fileInfo = fileInfo;
        this.downloadManager = manager;
    }
    @Override
    public void run(){
        this.fileInfo.setStatus("Downloading");
        this.downloadManager.updateUI(this.fileInfo);
        try {
            System.out.println("Downloading started");
            Files.copy(new URL(this.fileInfo.getUrl()).openStream(), Paths.get(this.fileInfo.getPathToSave()));
            this.fileInfo.setStatus("Done");
        } catch (IOException e) {
            this.fileInfo.setStatus("Failed");
            System.out.println("Error in downloading file");
            e.printStackTrace();
        }
        this.downloadManager.updateUI(this.fileInfo);
    }
}
