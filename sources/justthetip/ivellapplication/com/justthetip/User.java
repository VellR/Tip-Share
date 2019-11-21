package justthetip.ivellapplication.com.justthetip;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    public String email;
    public String username;

    public User() {
    }

    public User(String username2, String email2) {
        this.username = username2;
        this.email = email2;
    }
}
