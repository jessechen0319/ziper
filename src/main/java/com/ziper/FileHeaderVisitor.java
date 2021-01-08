package com.ziper;

import com.ziper.util.BytesContentReader;

public class FileHeaderVisitor extends ZipVisitor{

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
        
    }
}
