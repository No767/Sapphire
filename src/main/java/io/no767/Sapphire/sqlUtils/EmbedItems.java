package io.no767.Sapphire.sqlUtils;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmbedItems {
    @Id
    private String embedUUID;
    private String dateCreated;
    private String embedName;
    private String embedDescription;
    private boolean embedInline;

    public String getEmbedUUID() {
        return embedUUID;
    }
    public String getDateCreated() {
        return dateCreated;
    }
    public String getEmbedName() {
        return embedName;
    }
    public String getEmbedDescription() {
        return embedDescription;
    }
    public boolean getEmbedInline() {
        return embedInline;
    }


    public void setEmbedUUID(String embedUUID) {
        this.embedUUID = embedUUID;
    }
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
    public void setEmbedName(String embedName) {
        this.embedName = embedName;
    }
    public void setEmbedDescription(String embedDescription) {
        this.embedDescription = embedDescription;
    }
    public void setEmbedInline(boolean embedInline) {
        this.embedInline = embedInline;
    }
}
