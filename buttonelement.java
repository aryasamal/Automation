package com.seleniumtests.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.seleniumtests.core.TestLogging;

import com.seleniumtests.driver.BrowserType;
import com.seleniumtests.driver.WebUIDriver;

public class ButtonElement extends HtmlElement {

    public ButtonElement(final String label, final By by) {
        super(label, by);
    }

    @Override
    public void click() {
        TestLogging.logWebStep("click on " + toHTML(), false);

        BrowserType browser = WebUIDriver.getWebUIDriver().getConfig().getBrowser();
        if (browser == BrowserType.InternetExplore) {
            super.sendKeys(Keys.ENTER);
        } else {
            super.click();
        }
    }

    public void submit() {
        TestLogging.logWebStep("Submit form by clicking on " + toHTML(), false);
        findElement();
        element.submit();
    }
}
