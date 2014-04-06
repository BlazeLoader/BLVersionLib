package net.acomputerdog.BLVersionLib;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * A version list downloaded from a URL
 */
public class NetVersionList extends VersionList {
    private final BLVersion newestVersion;
    private final Map<String, BLVersion> allVersions = new HashMap<String, BLVersion>();

    public NetVersionList(URL url) {
        try {
            Properties prop = new Properties();
            prop.load(url.openStream());
            for (Object obj : prop.keySet()) {
                String version = (String) obj;
                if (!"newest".equals(version)) {
                    String[] parts = version.split(REGEX_UNDERSCORE);
                    if (parts.length >= 2) {
                        allVersions.put(version, new BLVersion(parts[0], parts[1], prop.getProperty(version)));
                    }
                }
            }
            newestVersion = allVersions.get(prop.getProperty("newest", ""));
        } catch (Exception e) {
            throw new RuntimeException("Unable to download version list!", e);
        }
    }

    /**
     * Gets all BL versions from this VersionList
     *
     * @return Return an Array of BLVersions containing all versions from this list.  Should be ordered the
     */
    @Override
    public Map<String, BLVersion> getVersions() {
        return allVersions;
    }

    /**
     * Gets the newest BLVersion from this list
     *
     * @return Return the newest BLVersion from this list.
     */
    @Override
    public BLVersion getNewestVersion() {
        return newestVersion;
    }
}
