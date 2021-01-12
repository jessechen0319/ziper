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

	 @Test
	 public void readUInt_2() {

		 BytesContentReader reader = new BytesContentReader(new byte[]{
				 0x0a,
				 0x0b
		 });
		 assertEquals(reader.readUInt_2(), 0x0b0a);
		 assertEquals(reader.position, 2);
	 }

	 @Test
	 public void readByte() {
		 BytesContentReader reader = new BytesContentReader(new byte[]{
				 0x0a,
				 0x0b,
				 0x0c,
				 0x0d
		 });
		 byte[] bytes = new byte[4];
		 reader.readByte(bytes);
		 assertArrayEquals(bytes, new byte[]{
		 		 0x0a,
				 0x0b,
				 0x0c,
				 0x0d});
		 assertEquals(reader.position, 4);
	 }
 }