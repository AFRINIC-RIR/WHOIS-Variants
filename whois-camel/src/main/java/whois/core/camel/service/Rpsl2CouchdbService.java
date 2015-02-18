package whois.core.camel.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.apache.camel.Body;
import whois.core.camel.command.Rpsl2CouchdbCommand;

import javax.inject.Named;

/**
 * Created by yogesh on 2/6/15.
 */
@Named("Rpsl2CouchdbService")
public class Rpsl2CouchdbService extends AbstractService<String> {

    private Gson gson = new Gson();

    public JsonElement messageReceived(@Body String msg) {
        return gson.fromJson(process(msg), JsonElement.class);
    }

    @Override
    protected Class getCommandId() {
        return Rpsl2CouchdbCommand.class;
    }
}
