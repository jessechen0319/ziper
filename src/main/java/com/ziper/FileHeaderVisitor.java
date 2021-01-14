package com.ziper;

import com.ziper.util.BytesContentReader;

public class FileHeaderVisitor extends ZipVisitor{
    
    private int magic;
    private int minimalExtractVersion;
    private int bitFlag;
    private int compressionMethod;
    private int modifyDate;
    private int modifyTime;
    private byte[] crc = new byte[4];
    private int compressionSize;
    private int unCompressionSize;
    private int fileNameLength;
    private int extraFieldLength;
    private byte[] fileNameContent;

    public int getLength() {
        return length;
    }

    private int length;
    
    private final  static int MAGIC_CODE = 0x04034B50;
    
    public static boolean testMagicHeader(byte[] content){
        if (content.length<4){
            return false;
        }
        BytesContentReader bytesContentReader = new BytesContentReader(content);
        try {
            return MAGIC_CODE == bytesContentReader.readUInt_4();
        } finally {
            bytesContentReader = null;//release instance
        }
    }

    public int getMagic() {
        return magic;
    }

    public int getMinimalExtractVersion() {
        return minimalExtractVersion;
    }

    public int getBitFlag() {
        return bitFlag;
    }

    public int getCompressionMethod() {
        return compressionMethod;
    }

    public int getModifyDate() {
        return modifyDate;
    }

    public int getModifyTime() {
        return modifyTime;
    }

    public byte[] getCrc() {
        return crc;
    }

    public int getCompressionSize() {
        return compressionSize;
    }

    public int getUnCompressionSize() {
        return unCompressionSize;
    }

    public int getFileNameLength() {
        return fileNameLength;
    }

    public int getExtraFieldLength() {
        return extraFieldLength;
    }

    public byte[] getFileNameContent() {
        return fileNameContent;
    }

    public byte[] getExtraFieldContent() {
        return extraFieldContent;
    }

    public byte[] getCompressionData() {
        return compressionData;
    }

    private byte[] extraFieldContent;
    private byte[] compressionData;

    /**
     * Offset Bytes Description 译
     * 0 4 Local file header signature = 0x04034b50 (read as a little-endian number) (0x04034b50)
     * 4 2 Version needed to extract (minimum)
     * 6 2 General purpose bit flag
     * 8 2 Compression method
     * 10 2 File last modification time
     * 12 2 File last modification date
     * 14 4 CRC-32
     * 18 4 Compressed size
     * 22 4 Uncompressed size
     * 26 2 File name length (n)
     * 28 2 Extra field length (m)
     * 30 n File name
     * 30+n m Extra field
     * */

    @Override
    public void visit(byte[] content) {
        BytesContentReader bytesContentReader = new BytesContentReader(content);
        magic = bytesContentReader.readUInt_4();
        minimalExtractVersion = bytesContentReader.readUInt_2();
        bitFlag = bytesContentReader.readUInt_2();
        compressionMethod = bytesContentReader.readUInt_2();
        modifyDate = bytesContentReader.readUInt_2();
        modifyTime = bytesContentReader.readUInt_2();
        bytesContentReader.readByte(crc);
        compressionSize = bytesContentReader.readUInt_4();
        unCompressionSize = bytesContentReader.readUInt_4();
        fileNameLength = bytesContentReader.readUInt_2();
        extraFieldLength = bytesContentReader.readUInt_2();
        fileNameContent = new byte[fileNameLength];
        extraFieldContent = new byte[extraFieldLength];
        compressionData = new byte[compressionSize];
        bytesContentReader.readByte(fileNameContent);
        bytesContentReader.readByte(extraFieldContent);
        bytesContentReader.readByte(compressionData);
        length = bytesContentReader.getPosition();
    }
}
