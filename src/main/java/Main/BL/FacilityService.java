package Main.BL;

import Main.Entities.Facility.Facility;


public class FacilityService implements IFacilityService {

    private Facility facility;

    @Override
    public Facility getFacility() {
        return facility;
    }

    @Override
    public void setFacility(Facility facility)
    {
        this.facility = facility;
    }


}
