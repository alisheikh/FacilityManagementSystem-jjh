package Main.Entities.usage;

/**
 * Created by Jackson on 3/13/14.
 */
public interface UnitUser {
    String getCreditCard();

    void setCreditCard(String creditCard);

    String getCompanyName();

    void setCompanyName(String companyName);

    int getId();

    void setId(int id);

    String getFirstName();

    String getLastName();

    int getPhoneNumber();

    String getEmailAddress();


    void setLastName(String last_name);

    void setFirstName(String first_name);

    void setPhoneNumber(int phone_number);

    void setEmailAddress(String email_address);
}
