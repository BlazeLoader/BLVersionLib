import net.acomputerdog.BLVersionLib.BLVersion;
import net.acomputerdog.BLVersionLib.VersionLib;

import java.io.*;
import java.net.URL;
import java.util.List;

public class VLTest {

    public static void main(String[] args) {
        try {
            System.out.println("Loaded versions: " + listToString(VersionLib.getAllVersions()));
            BLVersion newestVersion = VersionLib.getNewestVersion();
            System.out.println("Newest BL version: BL " + newestVersion.getBlVersion() + " on MC " + newestVersion.getMcVersion() + " from \"" + newestVersion.getDownloadURL() + "\".");
            System.out.println("Downloading file...");
            saveUrl(newestVersion.getBlVersion() + ".zip", newestVersion.getDownloadURL());
            System.out.println("Done.");
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

    private static void saveUrl(final String filename, final String urlString) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new BufferedInputStream(new URL(urlString).openStream());
            out = new BufferedOutputStream(new FileOutputStream(filename));

            while (in.available() > 0) {
                out.write(in.read());
            }

        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

}
