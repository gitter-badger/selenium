package com.github.ebour.selenium.factories.api.browser;

public class BrowserInitializationException extends Exception
{
    public BrowserInitializationException(String msg)
    {
        super(msg);
    }

    public BrowserInitializationException(String browserType, String msg)
    {
        super("Unable to instantiate browser: "+browserType + ". Reason: " + msg);
    }
}
