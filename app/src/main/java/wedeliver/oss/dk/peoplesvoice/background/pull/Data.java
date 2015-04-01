package wedeliver.oss.dk.peoplesvoice.background.pull;

import java.net.URL;

/**
 * Created by jnie0811 on 31-03-2015.
 */
public interface Data {

    /**
     *
     * @return
     */
    String getName();

    /**
     *
     * @return
     */
    String getShortDescription();

    /**
     *
     * @return
     */
    String getLongDescription();

    /**
     * Typen kan være feks. "Fremsættelse" | "Lovforslag som fremsat"
     * @return
     */
    String getType();

    /**
     * The URL for this Data if it comes from an HTML page
     * @return
     */
    URL getURL();
}
