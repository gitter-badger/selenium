package com.github.ebour.selenium.firefox.factory;

import com.github.ebour.selenium.factories.api.browser.BrowserProxy;
import org.browsermob.core.har.Har;
import org.browsermob.core.har.HarPage;
import org.browsermob.proxy.ProxyServer;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by ebour on 25/06/15.
 */
public class FirefoxBrowserProfilingProxy implements BrowserProxy
{
    private final ProxyServer server;

    public FirefoxBrowserProfilingProxy(ProxyServer server)
    {
        this.server = server;
    }

    @Override
    public void resetData()
    {
        server.cleanup();
    }

    @Override
    public Long getPageLoadDuration(String pageTitle)
    {
        for(HarPage page : getHar().getLog().getPages())
        {
            if(page.getTitle().equals(pageTitle))
            {
                return page.getPageTimings().getOnContentLoad();
            }
        }
        return new Long(-1);
    }

    private Har getHar()
    {
        return server.getHar();
    }
}
