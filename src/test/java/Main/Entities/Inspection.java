package Main.Entities;


import java.util.Date;

public class Inspection {

	private int ID;

	private Facility Facility;

	private int InspectingStaffID;

	private Date InspectionDate;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Facility getFacility() {
        return Facility;
    }

    public void setFacility(Facility facility) {
        Facility = facility;
    }

    public int getInspectingStaffID() {
        return InspectingStaffID;
    }

    public void setInspectingStaffID(int inspectingStaffID) {
        InspectingStaffID = inspectingStaffID;
    }

    public Date getInspectionDate() {
        return InspectionDate;
    }

    public void setInspectionDate(Date inspectionDate) {
        InspectionDate = inspectionDate;
    }
}
