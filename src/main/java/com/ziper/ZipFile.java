package com.ziper;

import java.io.File;
import java.io.IOException;

public interface ZipFile {
    void accept(ZipVisitor visitor, File file) throws IOException;
}
