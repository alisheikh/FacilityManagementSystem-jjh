package Main.DAL;

import Main.Entities.Inspection;

/**
 * Created by john on 2/5/14.
 */
public interface IInspectionFactory {
    Inspection Create(Inspection inspection);

    Inspection Update(Inspection inspection);

    void Delete(int ID);

    Inspection Get(int ID);
}
