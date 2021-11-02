package Data;
/**
 * @author Beñat;
 */

import java.util.Objects;

public class User {

    private String userName;
    private String password;
    private boolean isAdmin;

    /**
     *
     * @param userName
     * @param password
     * @param isAdmin
     */

    public User(String userName, String password, boolean isAdmin){
        this.userName = userName;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

}
