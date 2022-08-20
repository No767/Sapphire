package io.no767.Sapphire.sqlUtils;

import java.io.Serializable;

public class PostNewEmbed implements Serializable {

    private String embedName;
    private String embedDescription;
    private boolean embedInline;

    public void setEmbedName(String embedName) {
        this.embedName = embedName;
    }
    public void setEmbedDescription(String embedDescription) {
        this.embedDescription = embedDescription;
    }
    public void setEmbedInline(boolean embedInline) {
        this.embedInline = embedInline;
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
}
