package Main.Entities;
import org.joda.time.DateTime;

public class FacilityUsage {

	private Person person;

	private DateTime startTime;

	private DateTime endTime;

	private Facility facility;//NOTE: I'm not sure I like this implementation. See Issues.txt

    public FacilityUsage()
    {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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
}
