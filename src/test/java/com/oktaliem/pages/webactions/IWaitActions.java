package com.oktaliem.pages.webactions;

import java.awt.*;

/**
 * Author : Okta Liem
 */
public interface IWaitActions {

    void wait(int miliseconds);
    void waitWithJavascriptExecutor(int miliseconds);
    void robotWaitFor(int miliseconds) throws AWTException;

}
