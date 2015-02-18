package whois.core.camel.service;

import org.apache.camel.Body;
import org.apache.solr.common.SolrInputDocument;
import whois.core.camel.command.Rpsl2SolrCommand;

import javax.inject.Named;

/**
 * Created by yogesh on 2/6/15.
 */
@Named("Rpsl2SolrService")
public class Rpsl2SolrService extends AbstractService<SolrInputDocument> {

    public SolrInputDocument messageReceived(@Body String msg) {
        return process(msg);
    }

    @Override
    protected Class getCommandId() {
        return Rpsl2SolrCommand.class;
    }
}
