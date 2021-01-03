package com.ziper.console;

import com.ziper.ZipMain;

import java.io.File;

public class ConsoleZipMain implements ZipMain {
    private File file;
    @Override
    public void analysis(String filePath) throws IllegalArgumentException {
        file = new File(filePath);
        if (!file.exists()){
            throw new IllegalArgumentException("file not found");
        }
    }
}
