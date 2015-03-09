package whois.core.camel;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.SpringRouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yogesh on 2/24/15.
 */
public class CamelServerTest extends CamelTestSupport {

    private static ApplicationContext applicationContext;

    private String body = "id: Momem\ntitle: Sa";


    @Test
    public void testEmail() throws Exception {
        ProducerTemplate startEmail = context().createProducerTemplate();

        startEmail.sendBody("restlet:http://localhost:4480/?restletMethod=post", body);
    }

    @BeforeClass
    public static void init() {
        applicationContext = new ClassPathXmlApplicationContext("/whois-camel-context.xml");
    }

    @Override
    public boolean isCreateCamelContextPerClass() {
        return true;
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        SpringRouteBuilder springRouteBuilder = new SpringRouteBuilder() {
            @Override
            public void configure() throws Exception {
                setApplicationContext(applicationContext);
            }
        };
        return springRouteBuilder;
    }
}
