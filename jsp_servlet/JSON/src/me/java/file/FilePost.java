package me.java.file;

import java.util.LinkedList;
import java.util.List;

public class FilePost {

    private String userId = "";
    private String title = "";
    private List<FileInfo> files = new LinkedList<>();

    public FilePost() {
    }

    public FilePost(String userId) {
        this.userId = userId;
    }

    public FilePost(String userId, String title) {
        this.userId = userId;
        this.title = title;
    }

    public FilePost(String userId, String title, List<FileInfo> files) {
        this.userId = userId;
        this.title = title;
        this.files = files;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<FileInfo> getFiles() {
        return files;
    }

    public void setFiles(List<FileInfo> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "FilePost{" +
                "userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", files=" + files +
                '}';
    }
}
