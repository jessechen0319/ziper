package com.ziper;

import junit.framework.TestCase;

import java.nio.charset.Charset;

public class FileHeaderVisitorTest extends TestCase {

    byte[] content = new byte[] {
            0x50,
            0x4B,
            0x03,
            0x04,
            0x0A,
            0x00,
            0x00,
            0x00,
            0x00,
            0x00,
            (byte)0xE7,
            (byte)0xBD,
            (byte)0x9A,
            0x51,
            (byte)0xB7,
            (byte)0xEF,
            (byte)0xDC,
            (byte)0x83,
            0x01,
            0x00,
            0x00,
            0x00,
            0x01,
            0x00,
            0x00,
            0x00,
            0x05,
            0x00,
            0x00,
            0x00,
            0x61,
            0x2E,
            0x74,
            0x78,
            0x74,
            0x31
    };

    public void testVisit() {
        FileHeaderVisitor visitor = new FileHeaderVisitor();
        visitor.visit(content);
        byte[] compressionData = visitor.getCompressionData();
        assertEquals("1", new String(compressionData, Charset.forName("ascii")));
    }
}