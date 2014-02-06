package Main.DAL;

import Main.Entities.Facility;

import java.util.List;

/**
 * Created by john on 2/5/14.
 */
public interface IFacilityFactory {
    FacilityFactory Create(Facility facilty);

    FacilityFactory Update(Facility facility);

    void Delete(int ID);

    Facility Get(int ID);

    List<Facility> GetAll();

}
