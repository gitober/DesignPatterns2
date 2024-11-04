package Proxy;

import java.util.Date;

public class DocumentProxy implements Document {
    private final RealDocument realDocument;
    private final AccessControlService accessControlService;

    public DocumentProxy(RealDocument realDocument) {
        this.realDocument = realDocument;
        this.accessControlService = AccessControlService.getInstance();
    }

    @Override
    public String getContent(User user) throws AccessDeniedException {
        if (accessControlService.isAllowed(realDocument.getDocumentId(), user.getUsername())) {
            return realDocument.getContent(user);
        } else {
            throw new AccessDeniedException("Access denied for user: " + user.getUsername());
        }
    }

    @Override
    public Date getCreationDate() {
        return realDocument.getCreationDate();
    }
}