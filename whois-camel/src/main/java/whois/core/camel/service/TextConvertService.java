package whois.core.camel.service;

import org.apache.camel.Body;
import org.apache.camel.Header;
import whois.core.camel.command.*;

import javax.inject.Named;
import java.io.IOException;

/**
 * Created by yogesh on 2/6/15.
 */
@Named("TextConvertService")
public class TextConvertService extends AbstractService<String> {

    private String conversion;

    public String messageReceived(@Header("conversion") String conversion, @Body String msg) throws IOException {
        this.conversion = conversion;
        return process(msg);
    }

    @Override
    protected Class getCommandId() {
        if ("json2rpsl".equalsIgnoreCase(conversion)) {
            return Json2RpslCommand.class;
        } else if ("rpsl2couchdb".equalsIgnoreCase(conversion)) {
            return Rpsl2CouchdbCommand.class;
        } else if ("rpsl2html".equalsIgnoreCase(conversion)) {
            return Rpsl2HtmlCommand.class;
        } else if ("rpsl2xhtml".equalsIgnoreCase(conversion)) {
            return Rpsl2HtmlCommand.class;
        } else if ("rpsl2xml".equalsIgnoreCase(conversion)) {
            return Rpsl2XmlCommand.class;
        }
        return Rpsl2JsonCommand.class;
    }
}
