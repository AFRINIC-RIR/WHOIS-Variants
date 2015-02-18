package whois.core.camel.command;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;


/**
 * Created by yogesh on 2/7/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/whois-core-context.xml"})
public class Json2RpslCommandTest {

    @Inject
    private Json2RpslCommand subject;


    @Test
    public void test001() {

        String json = "{\"a\":\"b\",\"c\":\"d\"}";
        subject.setParameter(json);
        subject.run();

        assertEquals("a:              b\nc:              d", subject.getResult());

    }
}
