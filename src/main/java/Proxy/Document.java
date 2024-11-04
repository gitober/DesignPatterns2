package Proxy;

import java.util.Date;

public interface Document {
    String getContent(User user) throws AccessDeniedException;
    Date getCreationDate();
}