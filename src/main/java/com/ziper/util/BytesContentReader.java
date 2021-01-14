package com.ziper.util;

public class BytesContentReader {

	public int getPosition() {
		return position;
	}

	protected int position = 0;
	
	private byte[] content;
	
	public BytesContentReader(byte[] bytes){
		this.content = bytes;
	}
	
	public int readUInt_2(){
		int result = 0x0000;
		
		if (content.length < 2+position) {
			throw new RuntimeException("out of bounds");
		}
		
		int val1 = content[position];
		int val2 = content[position+1];
		position += 2;
		
		result = val2 << 8 | val1;
		
		return result;
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
	
	public void readByte(byte[] bytes){
		if (bytes.length + position > content.length) {
			throw new RuntimeException("out of bounds");
		}
		for (int i = 0; i < bytes.length; i++) {
			bytes[i] = content[position];
			position +=1;
		}
	}
	
}
