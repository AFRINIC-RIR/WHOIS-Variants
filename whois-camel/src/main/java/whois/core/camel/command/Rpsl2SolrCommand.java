package whois.core.camel.command;

import org.apache.solr.common.SolrInputDocument;
import org.springframework.context.annotation.Scope;
import whois.core.api.Command;
import whois.core.api.CommandException;

import javax.inject.Named;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by yogesh on 2/7/15.
 */
@Named
@Scope("prototype")
public class Rpsl2SolrCommand implements Command<String, SolrInputDocument> {

    private String rpsl;

    private SolrInputDocument json = new SolrInputDocument();

    public void setParameter(String parameter) {
        rpsl = parameter;
    }

    public SolrInputDocument getResult() {
        return json;
    }

    public void run() {
        StringReader sr = new StringReader(rpsl);
        BufferedReader br = new BufferedReader(sr);
        String line1;
        String[] line;
        try {
            while ((line1 = br.readLine()) != null) {
                if (!line1.startsWith("%%")) {
                    line = line1.split(":");
                    json.addField(line[0].toLowerCase().trim(), line[1].trim());
                }
            }
        } catch (IOException e) {
            throw new CommandException("Error parsing RPSL: " + e.toString());
        }
    }
}
