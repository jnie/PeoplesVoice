package wedeliver.oss.dk.peoplesvoice.background.pull;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jnie0811 on 01-04-2015.
 */
public class DataImpl implements Data {

    private String name;
    private String shortDescr;
    private String longDescr;
    private String type;
    private URL url;

    public DataImpl() {}

    public DataImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getShortDescription() {
        return shortDescr;
    }

    @Override
    public String getLongDescription() {
        return longDescr;
    }

    @Override
    public URL getURL() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescr = shortDescription;
    }

    public void setURLString(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
