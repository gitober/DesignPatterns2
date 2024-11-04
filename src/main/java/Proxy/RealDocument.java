package Proxy;

import java.util.Date;

public class RealDocument implements Document {
    private final String documentId;
    private final Date creationDate;
    private final String content;

    public RealDocument(String documentId, String content) {
        this.documentId = documentId;
        this.creationDate = new Date();
        this.content = content;
    }

    @Override
    public String getContent(User user) {
        return content;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    public String getDocumentId() {
        return documentId;
    }
}