package com.ziper.util;

public class BytesContentReader {
	
	protected int position = 0;
	
	private byte[] content;
	
	public BytesContentReader(byte[] bytes){
		this.content = bytes;
	}
	
	public int readUInt_4(){
		int result = 0x00;
		if (content.length < 4+position) {
			throw new RuntimeException("out of bounds");
		}
		
		for (int i = 1; i<=4; i++){
			int value = content[i+position-1];
			for (int j = 1; j<i;j++){
				value = value<<8;
			}
			result = result | value;
		}
		
		position +=4;
		
		return result;
	}
	
}
