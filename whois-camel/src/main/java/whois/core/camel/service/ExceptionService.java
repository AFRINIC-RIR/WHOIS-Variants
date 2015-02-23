package whois.core.camel.service;

import org.apache.camel.Header;
import org.apache.camel.component.restlet.RestletConstants;
import org.restlet.Response;
import org.restlet.data.Status;

import javax.inject.Named;

/**
 * Created by yogesh on 2/23/15.
 */
@Named("ExceptionService")
public class ExceptionService {

    public Object commandFailed(@Header(RestletConstants.RESTLET_RESPONSE) Response response,
                                Exception exception) {
        response.setStatus(Status.CLIENT_ERROR_NOT_FOUND);
        // FIXME Provide appropriate error code depending on nature of exception
        return exception.getMessage();
    }
}
