package Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AccessControlService {
    private static AccessControlService instance;
    private final Map<String, String> accessList;

    private AccessControlService() {
        accessList = new HashMap<>();
        // Pekka ja Kalevi on in the club
        accessList.put("Pekka", "doc1");
        accessList.put("Kalevi", "doc2");
    }

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public boolean isAllowed(String documentId, String username) {
        return accessList.containsKey(username) && accessList.get(username).equals(documentId);
    }
}