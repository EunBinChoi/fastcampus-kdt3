package me.util;

import java.io.File;


// Get Path of File
// https://stackoverflow.com/questions/3153337/how-to-get-current-working-directory-in-java
public class FileUtil {
    public static String getAbsolutePathOfSource(Object object) {
        // src directory absolute path
        final String internalPath = object.getClass().getName().replace(".", File.separator);
        final String externalPath = System.getProperty("user.dir") + File.separator + "src";
        final String sourceFolderDir = externalPath + File.separator + internalPath.substring(0, internalPath.lastIndexOf(File.separator));
        return sourceFolderDir;
    }

    public static String getAbsolutePathOfOut(Object object) {
        return object.getClass().getResource("").getPath();
    }
}
