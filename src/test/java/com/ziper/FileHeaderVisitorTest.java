package com.ziper;

import junit.framework.TestCase;

public class FileHeaderVisitorTest extends TestCase {

    int[] content = new int[] {
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
            0xE7,
            0xBD,
            0x9A,
            0x51,
            0xB7,
            0xEF,
            0xDC,
            0x83,
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

    }
}