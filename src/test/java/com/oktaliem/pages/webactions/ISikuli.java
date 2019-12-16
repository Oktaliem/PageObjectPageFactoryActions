package com.oktaliem.pages.webactions;

import org.sikuli.script.FindFailed;

public interface ISikuli {
    void clickViaSikuli(String filePath, String fileName) throws FindFailed;

    void doubleClickViaSikuli(String filePath, String fileName) throws FindFailed;

    void typeViaSikuli(String filePath, String fileName, String text) throws FindFailed;

    void hoverViaSikuli(String filePath, String fileName) throws FindFailed;

    void findViaSikuli(String filePath, String fileName) throws FindFailed;
}
