package whois.core.camel.command;

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
public class Rpsl2XmlCommand implements Command<String, String> {

    private String rpsl;

    private StringBuilder xml = new StringBuilder();

    public void setParameter(String parameter) {
        rpsl = parameter;
    }

    public String getResult() {
        return xml.toString();
    }

    public void run() {
        StringReader sr = new StringReader(rpsl);
        BufferedReader br = new BufferedReader(sr);
        String line1;
        String[] line;
        xml.append("<object>\n");
        try {
            while ((line1 = br.readLine()) != null) {
                if (!line1.startsWith("%%")) {
                    line = line1.split(":");
                    xml.append("  <field name=\"").append(line[0].trim().toLowerCase()).append("\" value=\"")
                            .append(line[1].trim()).append("\"/>\n");
                }
            }
        } catch (IOException e) {
            throw new CommandException("Error parsing RPSL: " + e.toString());
        }
        xml.append("</object>\n");
    }
}
