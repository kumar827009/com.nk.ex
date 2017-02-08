package bean;

import java.util.HashMap;

/**
 * Created by NKumar on 1/2/2017.
 */
public class ParamTest {
    public static void main(String[] as) {
        String sr = "ctx=imputeapprove-context&endDate=20150101&ap=imputation&offering=HOSP&countryCode=FR&jobId=4068&sync=false&requestId=01fdbc29-e1db-45cb-a088-040c7cf9f188&cp=ImputationInvoker&startDate=20150101&";
        sr = sr.substring(0, sr.length() - 1);
        String[] paramsArr = sr.split("&");
        String[] p = null;
        HashMap<String, String> pMap = new HashMap<String, String>();
        if (paramsArr != null && paramsArr.length != 0) {
            for (int i = 0; i < paramsArr.length; i++) {
                if (paramsArr[0] != null) {
                    p = paramsArr[0].split("=");
                    pMap.put(p[0], p[1]);
                }

            }
        }

        System.out.println(getValueFromRelayState(sr, "offering"));
        System.out.println(getRelayStateAsMap(sr, "offering").get("offering"));

    }

    public static String getValueFromRelayState(String relayState, String key) {
        relayState = relayState.substring(0, relayState.length() - 1);
        String[] paramsArr = relayState.split("&");
        String[] p = null;
        String retVal = null;
        HashMap<String, String> pMap = new HashMap<String, String>();
        if (paramsArr != null && paramsArr.length != 0) {
            for (int i = 0; i < paramsArr.length; i++) {
                if (paramsArr[i] != null) {
                    p = paramsArr[i].split("=");
                    if (key != null && key.equalsIgnoreCase(p[0]))
                        retVal = p[1];
                }

            }
        }
        return retVal;
    }

    public static HashMap<String, String> getRelayStateAsMap(String relayState, String key) {
        relayState = relayState.substring(0, relayState.length() - 1);
        String[] paramsArr = relayState.split("&");
        String[] p = null;
        HashMap<String, String> pMap = new HashMap<String, String>();
        if (paramsArr != null && paramsArr.length != 0) {
            for (int i = 0; i < paramsArr.length; i++) {
                if (paramsArr[i] != null) {
                    p = paramsArr[i].split("=");
                    pMap.put(p[0], p[1]);
                }

            }
        }
        return pMap;
    }
}
