package Main.DAL;


import Main.Entities.Facility.Unit;
import Main.Entities.Facility.UnitImpl;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Jackson on 3/16/14.
 */
public class UnitDAOHibTest extends TestCase {

    private Unit unit;
    private UnitDAOHib unitDAOHib;

    @Before
    public void setUp() throws Exception {
        unit = new UnitImpl();
        unit.setUnitNumber(101);
        unit.setCapacity(102);
        unit.setFacilityId(50);

       //ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/app-context.xml");


        unitDAOHib = new UnitDAOHib();


    }

    @After
    public void tearDown() throws Exception {



    }

    @Test
    public void testCreateUnit() throws Exception {
        unit = unitDAOHib.CreateUnit(unit);

        Assert.assertNotNull(unit.getUnitId());
        Assert.assertTrue(unit.getUnitId() == 0);

    }

    @Test
    public void testCreateUnit1() throws Exception {

    }

    @Test
    public void testGetUnit() throws Exception {

    }

    @Test
    public void testUpdateUnit() throws Exception {

    }

    @Test
    public void testGetUnitForFacility() throws Exception {

    }

    @Test
    public void testDeleteUnit() throws Exception {

    }
}
