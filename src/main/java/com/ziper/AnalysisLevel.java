package com.ziper;

import com.ziper.console.ConsoleZipMain;

public enum AnalysisLevel {
    CONSOLE(new ConsoleZipMain());


    public ZipMain getZipMain() {
        return zipMain;
    }

    private ZipMain zipMain;
    AnalysisLevel (ZipMain zipMain) {
        this.zipMain = zipMain;
    }
}
