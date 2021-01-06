package com.ziper.console;

import com.ziper.ZipMain;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;

public class ConsoleZipMainTest extends TestCase {

    ZipMain zipMain = new ConsoleZipMain();

    @Test
    public void test_file_not_exist(){
        int exception = 0;
        try {
            zipMain.analysis("not_exists");
        } catch (IllegalArgumentException | IOException e) {
            exception++;
        } finally {
            assertTrue(exception>0);
        }
    }

}