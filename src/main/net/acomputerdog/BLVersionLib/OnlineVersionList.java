package net.acomputerdog.BLVersionLib;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * A NetVersionList configured to use the official version list.
 */
public class OnlineVersionList extends NetVersionList {
    private static final URL onlineURL = getOnlineURL();

    public OnlineVersionList() {
        super(onlineURL);
    }

    private static URL getOnlineURL() {
        try {
            return new URL("http://pastebin.com/raw.php?i=Q2D6et60");
        } catch (MalformedURLException e) {
            throw new RuntimeException("Impossible error, a hardcoded URL is invalid!");
        }
    }
}
