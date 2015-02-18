package whois.core.camel.service;

import org.apache.camel.Body;
import org.apache.camel.Header;
import whois.core.api.DeleteCommand;
import whois.core.api.QueryCommand;
import whois.core.api.UpdateCommand;

import javax.inject.Named;

/**
 * Created by yogesh on 2/6/15.
 */
@Named("WhoisService")
public class WhoisService extends AbstractService<String> {

    private String command;

    public String messageReceived(@Header("command") String command, @Body String msg) {
        this.command = command;
        return process(msg);
    }

    @Override
    protected Class getCommandId() {
        if ("update".equalsIgnoreCase(command)) {
            return UpdateCommand.class;
        } else if ("upd".equalsIgnoreCase(command)) {
            return UpdateCommand.class;
        } else if ("delete".equalsIgnoreCase(command)) {
            return DeleteCommand.class;
        } else if ("del".equalsIgnoreCase(command)) {
            return DeleteCommand.class;
        }
        return QueryCommand.class;
    }
}
