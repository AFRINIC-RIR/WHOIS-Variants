package whois.core.camel;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import whois.core.camel.command.Json2RpslCommandTest;
import whois.core.camel.command.Rpsl2CouchdbCommandTest;
import whois.core.camel.command.Rpsl2JsonCommandTest;

/**
 * Created by yogesh on 2/9/15.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({Json2RpslCommandTest.class,
        Rpsl2CouchdbCommandTest.class,
        Rpsl2JsonCommandTest.class,
        CamelServerTest.class})
public class AllTestSuite {
}
