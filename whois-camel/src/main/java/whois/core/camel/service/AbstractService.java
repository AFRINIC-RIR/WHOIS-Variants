package whois.core.camel.service;

import whois.core.api.Command;
import whois.core.api.CommandFactory;

import javax.inject.Inject;

/**
 * Created by yogesh on 2/6/15.
 */
abstract class AbstractService<T> {

    @Inject
    protected CommandFactory commandFactory;

    protected abstract Class getCommandId();

    T process(String msg) {
        @SuppressWarnings("unchecked") Command<String, T> updateCommand = commandFactory.getCommand(getCommandId());
        updateCommand.setParameter(msg);
        updateCommand.run();
        return updateCommand.getResult();
    }
}
