package main.DAL;

import main.Entities.Facility.Facility;
import main.Entities.Facility.Unit;

import java.util.List;

/**
 * Created by Jackson on 2/8/14.
 */
public interface IFacilityDAO {
    Facility create(Facility facilty);

    Facility update(Facility facility);

    void delete(Facility facility);

    Facility get(int id);

    List<Facility> getAll();

    Unit getUnit(int unitId);


}
