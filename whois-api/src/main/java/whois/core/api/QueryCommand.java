package whois.core.api;

import org.springframework.context.annotation.Scope;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by yogesh on 12/23/14.
 */
@Named
@Scope("prototype")
public class QueryCommand implements Command {

    @Inject
    private Store store;

    @Inject
    private Observer observer;

    @Inject
    private ModelAdapter modelAdapter;

    private String commandLine;

    public void run() {
        Class objectType = modelAdapter.getModelClass(null);
        store.load(objectType, commandLine, observer);
    }

    public void setParameter(String commandLine) {
        this.commandLine = commandLine;
    }

    public String getResult() {
        return observer.report();
    }

}
