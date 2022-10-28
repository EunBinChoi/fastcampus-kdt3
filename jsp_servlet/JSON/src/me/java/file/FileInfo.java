package me.java.file;

public class FileInfo {
    private String fileName;
    private String changedFileName;
    private String fileType;
    private String fileLocation;

    public FileInfo() {
    }

    public FileInfo(String fileName, String changedFileName, String fileType, String fileLocation) {
        this.fileName = fileName;
        this.changedFileName = changedFileName;
        this.fileType = fileType;
        this.fileLocation = fileLocation;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getChangedFileName() {
        return changedFileName;
    }

    public void setChangedFileName(String changedFileName) {
        this.changedFileName = changedFileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "fileName='" + fileName + '\'' +
                ", changedFileName='" + changedFileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", fileLocation='" + fileLocation + '\'' +
                '}';
    }
}
