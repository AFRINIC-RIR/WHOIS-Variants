package whois.core.model.rpsl;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by yogesh on 2/9/15.
 */
public class RpslFormatUtil {

    private transient static final String RPSL_LINE_FORMAT = "%-16s%s";

    public String format(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            sb2.setLength(0);
            sb2.append(entry.getKey()).append(":");
            sb.append(String.format(RPSL_LINE_FORMAT, sb2.toString(), entry.getValue())).append("\n");
        }
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
}
