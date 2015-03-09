package whois.core.model.rpsl;

import whois.core.api.WhoisObject;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by yogesh on 12/16/14.
 */
public class RpslWhoisObject implements WhoisObject, Serializable {

    //private transient static final String RPSL_LINE_FORMAT = "%-16s%s";

    private RpslFormatUtil rpslFormatUtil = new RpslFormatUtil();

    private final Map<String, String> keyValueMap = new LinkedHashMap<String, String>();

    public Iterator<Map.Entry<String, String>> getKeyValueIterator() {
        return keyValueMap.entrySet().iterator();
    }

    public String get(String key) {
        return keyValueMap.get(key.trim().toLowerCase());
    }

    /**
     * Before recording:
     * - Key is trimmed and converted into all lower case, and
     * - Value is trimmed.
     *
     * @param key   Key
     * @param value Value
     */
    public void put(String key, String value) {
        keyValueMap.put(key.trim().toLowerCase(), value.trim());
    }

    @Override
    public String toString() {
        return rpslFormatUtil.format(keyValueMap);
    }
}
