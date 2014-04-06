import net.acomputerdog.BLVersionLib.BLVersion;
import net.acomputerdog.BLVersionLib.VersionLib;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class VLTest {

    public static void main(String[] args) {
        try {
            System.out.println("Loaded versions: " + listToString(VersionLib.getAllVersions()));
            BLVersion newestVersion = VersionLib.getNewestVersion();
            System.out.println("Newest BL version: BL " + newestVersion.getBlVersion() + " on MC " + newestVersion.getMcVersion() + " from \"" + newestVersion.getDownloadURL() + "\".");
            System.out.println("Downloading file...");
            saveUrl(newestVersion.getBlVersion(), newestVersion.getDownloadURL());
        } catch (Exception e) {
            System.out.println("Exception running test!");
            e.printStackTrace();
        }
    }

    private static String listToString(List l) {
        StringBuilder builder = new StringBuilder(l.size() * 2);
        int numAdded = 0;
        for (Object obj : l) {
            if (numAdded > 0) {
                builder.append(",[");
            } else {
                builder.append("[");
            }
            builder.append(obj.toString());
            builder.append("]");
            numAdded++;
        }
        return builder.toString();
    }

    private static void saveUrl(final String filename, final String urlString) throws MalformedURLException, IOException {
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try {
            in = new BufferedInputStream(new URL(urlString).openStream());
            fout = new FileOutputStream(filename);

            final byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                fout.write(data, 0, count);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (fout != null) {
                fout.close();
            }
        }
    }

}
