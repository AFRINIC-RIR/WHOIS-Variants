package whois.core.camel.codec;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.textline.TextLineDecoder;
import org.apache.mina.filter.codec.textline.TextLineEncoder;
import whois.core.socket.AbstractSocketEventListener;

import javax.inject.Named;

/**
 * Created by yogesh on 2/8/15.
 */
@Named("MultilineTextCodecFactory")
public class MultilineTextCodecFactory implements ProtocolCodecFactory {

    public ProtocolEncoder getEncoder(IoSession ioSession) throws Exception {
        return new TextLineEncoder();
    }

    public ProtocolDecoder getDecoder(IoSession ioSession) throws Exception {
        return new TextLineDecoder(AbstractSocketEventListener.EOF);
    }
}
