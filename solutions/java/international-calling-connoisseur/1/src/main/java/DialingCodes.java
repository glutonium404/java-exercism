import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DialingCodes {

    HashMap<Integer, String> dialingCodes = new HashMap<Integer, String>();

    public Map<Integer, String> getCodes() {
        return dialingCodes;
    }

    public void setDialingCode(Integer code, String country) {
        dialingCodes.put(code, country);
    }

    public String getCountry(Integer code) {
        return dialingCodes.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        if (dialingCodes.containsValue(country) || dialingCodes.containsKey(code))
            return;
        dialingCodes.put(code, country);
    }

    public Integer findDialingCode(String country) {
        for (Entry<Integer, String> entrySet : dialingCodes.entrySet()) {
            if (entrySet.getValue() == country) {
                return entrySet.getKey();
            }
        }
        return null;
    }

    public void updateCountryDialingCode(Integer code, String country) {
        Integer dc = findDialingCode(country);

        if (dc == null) {
            return;
        }

        dialingCodes.put(code, country);
        dialingCodes.remove(dc);
    }
}
