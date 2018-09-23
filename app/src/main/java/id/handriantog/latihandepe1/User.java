package id.handriantog.latihandepe1;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * todo FILE FOR
 */
public class User extends RealmObject{

    @PrimaryKey
    int id;
    String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
