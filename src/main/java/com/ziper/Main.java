package com.ziper;

import java.io.IOException;

public class Main {

    private static Main instance = new Main();

    public static void main(String[] args) throws IOException {

        String filePath = instance.findFilePath(args);
        if (filePath == null) {
            throw new IllegalArgumentException("need zip file path");
        }

        AnalysisLevel.CONSOLE.getZipMain().analysis(filePath);
    }

    private String findFilePath(String[] args) {

        int index = 0;
        for (String attribute : args) {
            if (attribute.equals("-f")){
                return args[index + 1];
            }
            index++;
        }
        return null;
    }
}
