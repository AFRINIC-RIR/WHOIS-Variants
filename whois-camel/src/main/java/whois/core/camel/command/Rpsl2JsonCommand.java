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
public class Rpsl2JsonCommand implements Command<String, String> {

    private String rpsl;

    private StringBuilder json = new StringBuilder();

    public void setParameter(String parameter) {
        rpsl = parameter;
    }

    public String getResult() {
        return json.toString();
    }

    public void run() {
        StringReader sr = new StringReader(rpsl);
        BufferedReader br = new BufferedReader(sr);
        String line1;
        String[] line;
        String quotation = "\"";
        json.append("{");
        try {
            while ((line1 = br.readLine()) != null) {
                if (!line1.startsWith("%%")) {
                    line = line1.split(":");
                    json.append(quotation).append(line[0].trim().toLowerCase()).append(quotation)
                            .append(":").append(quotation).append(line[1].trim()).append(quotation).append(",");
                }
            }
        } catch (IOException e) {
            throw new CommandException("Error parsing RPSL: " + e.toString());
        }
        json.delete(json.length() - 1, json.length());
        json.append("}");
    }
}
