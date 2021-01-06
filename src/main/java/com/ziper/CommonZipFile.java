package com.ziper;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CommonZipFile implements ZipFile{
    @Override
    public void accept(ZipVisitor visitor, File file) throws IOException {
        byte[] bytes = FileUtils.readFileToByteArray(file);
        visitor.visit(bytes);
    }
}
