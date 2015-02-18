package whois.core.camel;

import org.apache.camel.spring.Main;

/**
 * Created by yogesh on 2/6/15.
 */
public class CamelServer {

    public static void main(String[] args) throws Exception {
        Main.main("-ac", "whois-camel-context.xml");
    }
}
