package me.java.util;

import java.io.File;

public class PathUtil {
    public static String getAbsolutePathOfSource(Class<?> clazz) {
        // src directory absolute path
        final String internalPath = clazz.getName().replace(".", File.separator);
        final String externalPath = System.getProperty("user.dir") + File.separator + "src";
        final String sourceFolderDir = externalPath + File.separator + internalPath.substring(0, internalPath.lastIndexOf(File.separator));
        return sourceFolderDir;
    }

    public static String getAbsolutePathOfOut(Class<?> clazz) {
        return clazz.getResource("").getPath();
    }
}
