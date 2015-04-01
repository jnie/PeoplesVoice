package wedeliver.oss.dk.peoplesvoice.background.pull;

import android.renderscript.Element;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jnie0811 on 01-04-2015.
 */
public class PulledDataHTMLFTImpl implements PulledData {

    private static final String MAINURL = "http://www.folketingstidende.dk";

    @Override
    public List<Data> getData() {
        List<Data> dataList = new ArrayList<Data>();
        Document doc = null;

        try {
            doc = Jsoup.connect(MAINURL + "/Folketingstidende/Folketingstidende.aspx?session=&startDate=20141007&endDate=20150401&eftDocType=1&showPublicationDate=0&sortColumn=caseNumber&sortOrder=desc&startRecord=1&numberOfRecords=25&totalNumberOfRecords=#pagination").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        org.jsoup.nodes.Element table = doc.getElementsByClass("journalAppendix").get(0);

        Elements rows = table.getElementsByTag("tr");

        for (org.jsoup.nodes.Element row: rows) {
            Elements tableData = row.getElementsByTag("td");
            if (tableData.size() > 1) {
                DataImpl data = new DataImpl();
                String name = row.select("td").first().text();
                data.setName(name);
                String shortDescription = row.select("td").get(1).text();
                data.setShortDescription(shortDescription);

                String type = row.select("td").get(2).text();
                data.setType(type);

                org.jsoup.nodes.Element urlElement = row.select("td").last().getElementsByTag("a").first();
                String urlEl = urlElement.text();
                data.setURLString(MAINURL + urlEl);

                dataList.add(data);
            }
        }

        return dataList;
    }

    public static void main(String[] args) {
        PulledData pulledData = new PulledDataHTMLFTImpl();
        List<Data> dataList = pulledData.getData();
        for (Data data : dataList) {
            System.out.println(data.getName());
            System.out.println(data.getLongDescription());
            System.out.println(data.getShortDescription());
            System.out.println(data.getType());
            System.out.println(data.getURL());
        }
    }
}
