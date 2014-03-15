package Main.Entities.maintenance;

/**
 * Created by Jackson on 3/13/14.
 */
public interface MaintenanceStaff  {
    int getId();

    String getFirstName();

    String getLastName();

    double getPayPerHour();

    void setPayPerHour(double payPerHour);

    boolean isFullTime();

    void setFullTime(boolean isFullTime);

    double getHoursPerWeek();

    void setHoursPerWeek(double hoursPerWeek);


    int getPhoneNumber();

    String getEmailAddress();

    void setId(int id);

    void setFirstName(String first_name);

    void setLastName(String last_name);

    void setPhoneNumber(int phone_number);

    void setEmailAddress(String email_address);
}
