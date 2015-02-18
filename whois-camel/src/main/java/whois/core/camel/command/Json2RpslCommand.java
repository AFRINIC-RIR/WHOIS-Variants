package whois.core.camel.command;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.context.annotation.Scope;
import whois.core.api.Command;
import whois.core.model.rpsl.RpslFormatUtil;

import javax.inject.Named;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by yogesh on 2/7/15.
 */
@Named
@Scope("prototype")
public class Json2RpslCommand implements Command<String, String> {

    private String json;

    private Map<String, String> map;

    private Gson gson = new Gson();

    private RpslFormatUtil rpslFormatUtil = new RpslFormatUtil();

    public void setParameter(String parameter) {
        json = parameter;
    }

    public String getResult() {
        return rpslFormatUtil.format(map);
    }

    public void run() {
        Type stringStringMap = new TypeToken<Map<String, String>>() {
        }.getType();
        map = gson.fromJson(json, stringStringMap);
    }
}
