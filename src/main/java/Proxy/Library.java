package Proxy;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private final Map<String, Document> documents;

    public Library() {
        documents = new HashMap<>();
    }

    public void addDocument(String documentId, Document document) {
        documents.put(documentId, document);
    }

    public Document getDocument(String documentId) {
        return documents.get(documentId);
    }

    public void createProtectedDocument(String documentId, String content) {
        RealDocument realDocument = new RealDocument(documentId, content);
        DocumentProxy documentProxy = new DocumentProxy(realDocument);
        addDocument(documentId, documentProxy);
    }

    public void createUnprotectedDocument(String documentId, String content) {
        RealDocument realDocument = new RealDocument(documentId, content);
        addDocument(documentId, realDocument);
    }
}