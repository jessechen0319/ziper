package com.ziper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZipFileVisitor extends ZipVisitor{
    public List<FileHeaderVisitor> getFileHeaderVisitors() {
        return fileHeaderVisitors;
    }

    private List<FileHeaderVisitor> fileHeaderVisitors = new ArrayList<>();
    @Override
    public void visit(byte[] content) {
        while (FileHeaderVisitor.testMagicHeader(content)){
            FileHeaderVisitor visitor = new FileHeaderVisitor();
            visitor.visit(content);
            fileHeaderVisitors.add(visitor);
            content = Arrays.copyOfRange(content, visitor.getLength(), content.length);
        }
        
    }
}
