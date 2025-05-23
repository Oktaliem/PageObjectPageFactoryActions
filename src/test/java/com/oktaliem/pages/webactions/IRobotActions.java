package com.oktaliem.pages.webactions;

import java.awt.*;

/**
 * Author : Okta Liem
 */
public interface IRobotActions {
    /** https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/java/awt/event/KeyEvent.html*/

    void robotKeyPress(int keyEvent) throws AWTException;
    void robotMouseMove(int xCoordinate, int yCoordinate) throws AWTException;
    void robotLeftClick() throws AWTException;
    void robotRightClick() throws AWTException;
    void robotDoubleClick()throws AWTException;
    void robotPressEnter()throws AWTException;
    void robotPressTab()throws AWTException;
    void robotSelectAll()throws AWTException;
    void robotInputText(String keyboard) throws AWTException;
}
