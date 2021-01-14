package com.ziper;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ZipFileReaderTest {
	
	@Test
	public void testFileByte() throws IOException {
		String path = "src/test/resources";
		File file = new File(path);
		String absolutePath = file.getAbsolutePath();
		File testZipFile = new File(absolutePath, "1.zip");
		Assert.assertTrue(testZipFile.exists());

		byte[] bytes = IOUtils.toByteArray(new FileInputStream(testZipFile));
		FileHeaderVisitor fileHeaderVisitor = new FileHeaderVisitor();
		fileHeaderVisitor.visit(bytes);
		System.out.println(new String(fileHeaderVisitor.getCompressionData()));
	}
}
