package com.oktaliem.pages.baseactions;

import com.oktaliem.pages.webactions.ISikuli;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/**
 * Author : Okta Liem
 */
public class BaseSikuliAct extends BaseScreenshot implements ISikuli {
    public static Logger log = Logger.getLogger("Library Test");
    private Pattern pattern;
    private Screen sikuli = new Screen();

    public BaseSikuliAct(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickViaSikuli(String filePath, String fileName) throws FindFailed {
        pattern = new Pattern(filePath + fileName);
        log.info("Pattern: " + filePath + fileName);
        sikuli.find(pattern);
        sikuli.wait(pattern, 20);
        sikuli.click(filePath + fileName);
        log.info("click with sikuli");
    }

    @Override
    public void doubleClickViaSikuli(String filePath, String fileName) throws FindFailed {
        pattern = new Pattern(filePath + fileName);
        log.info("Pattern: " + filePath + fileName);
        sikuli.wait(pattern, 20);
        sikuli.doubleClick(pattern);
        log.info("double click with sikuli");
    }

    @Override
    public void typeViaSikuli(String filePath, String fileName, String text) throws FindFailed {
        pattern = new Pattern(filePath + fileName);
        log.info("Pattern: " + filePath + fileName);
        sikuli.wait(pattern, 20);
        sikuli.type(pattern, text);
        log.info("type with sikuli");
    }

    @Override
    public void hoverViaSikuli(String filePath, String fileName) throws FindFailed {
        pattern = new Pattern(filePath + fileName);
        log.info("Pattern: " + filePath + fileName);
        sikuli.wait(pattern, 20);
        sikuli.hover(pattern);
        log.info("hover with sikuli");
    }

    @Override
    public void findViaSikuli(String filePath, String fileName) throws FindFailed {
        pattern = new Pattern(filePath + fileName);
        log.info("Pattern: " + filePath + fileName);
        sikuli.wait(pattern, 20);
        sikuli.find(pattern);
        log.info("find with sikuli");
    }

}
