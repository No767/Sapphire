package io.no767.Sapphire.sqlUtils;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class KumikoUser {
    @Id
    private String userUUID;
    private String username;
    private String dateJoined;
    private boolean isActive;

    public String getUserUUID() {
        return userUUID;
    }

    public String getUsername() {
        return username;
    }

    public String getDateJoined() {
        return dateJoined;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
}
