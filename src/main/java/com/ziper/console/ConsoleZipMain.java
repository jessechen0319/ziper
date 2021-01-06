package com.ziper.console;

import com.ziper.*;

import java.io.File;
import java.io.IOException;

public class ConsoleZipMain implements ZipMain {
    private File file;
    @Override
    public void analysis(String filePath) throws IllegalArgumentException, IOException {
        file = new File(filePath);
        if (!file.exists()){
            throw new IllegalArgumentException("file not found");
        }
        ZipVisitor visitor = new ZipFileVisitor();
        ZipFile zipFile = new CommonZipFile();
        zipFile.accept(visitor, file);
    }
}
