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
public class Rpsl2HtmlCommand implements Command<String, String> {

    private String rpsl;

    private StringBuilder html = new StringBuilder();

    public void setParameter(String parameter) {
        rpsl = parameter;
    }

    public String getResult() {
        return html.toString();
    }

    public void run() {
        StringReader sr = new StringReader(rpsl);
        BufferedReader br = new BufferedReader(sr);
        String line1;
        String[] line;
        html.append("<table>\n");
        try {
            while ((line1 = br.readLine()) != null) {
                if (!line1.startsWith("%%")) {
                    line = line1.split(":");
                    html.append("  <tr><td>").append(line[0].trim().toLowerCase()).append("</td><td>")
                            .append(line[1].trim()).append("</td></tr>\n");
                }
            }
        } catch (IOException e) {
            throw new CommandException("Error parsing RPSL: " + e.toString());
        }
        html.append("</table>\n");
    }
}
