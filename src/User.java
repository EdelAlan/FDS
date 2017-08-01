import java.io.Serializable;

/**
 * Created by alan on 08/05/2017.
 */

public class User implements Serializable {
    String name;
    String password;
    String email;
    String phoneNumber;

    public User(String name, String password, String email, String phoneNumber) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
