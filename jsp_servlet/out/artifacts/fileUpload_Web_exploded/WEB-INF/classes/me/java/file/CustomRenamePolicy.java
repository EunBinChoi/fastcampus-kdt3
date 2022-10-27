package me.java.file;

import com.oreilly.servlet.multipart.FileRenamePolicy;

import java.io.File;

public class CustomRenamePolicy implements FileRenamePolicy {
    private String fullPath = "";

    public CustomRenamePolicy(String fullPath) {
        this.fullPath = fullPath;
    }

    @Override
    public File rename(File f) {
        String name = f.getName();
       return new File(fullPath + File.separator + System.nanoTime());
    }


}
