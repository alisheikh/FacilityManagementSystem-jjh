package Main.Entities.usage;
import Main.Entities.Facility.Facility;
import Main.Entities.Person;
import org.joda.time.DateTime;
import java.util.List;

public class UnitUsage {

    private int id;

    private List<Person> user;

	private DateTime startTime;

	private DateTime endTime;

	private Facility facility;

    public UnitUsage()
    {
    }

    public List<Person> getUser() {
        return user;
    }

    public void setUser(List<Person> user) {
        this.user = user;
    }

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    public DateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(DateTime endTime) {
        this.endTime = endTime;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
