package Main.Entities;

/**
 * Created by Jackson on 3/13/14.
 */
public interface Person {
    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    int getPhoneNumber();

    void setPhoneNumber(int phoneNumber);

    int getId();

    void setId(int id);

    String getEmailAddress();

    void setEmailAddress(String emailAddress);
}
