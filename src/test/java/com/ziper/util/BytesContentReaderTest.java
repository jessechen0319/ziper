package com.ziper.util;

import org.junit.Test;

import static org.junit.Assert.*;


 public class BytesContentReaderTest {
	@Test
	public void readUInt_4() {
		BytesContentReader reader = new BytesContentReader(new byte[]{
				0x50,
				0x4B,
				0x03,
				0x04
		});
		assertEquals(reader.readUInt_4(), 0x04034B50);
		assertEquals(reader.position, 4);
	}
}