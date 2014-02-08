package Main.Entities.usage;

import Main.Entities.Person;
import Main.Entities.Facility.Facility;

public class UnitUser extends Person {


    private int CreditCard;

	private String CompanyName;

    private Facility facility;

	public UnitUser() {

	}

    public Facility getFacility(){
       return facility;
    }

    public void setFacility(Facility facility){
        this.facility = facility;
    }

    public int getCreditCard() {
        return CreditCard;
    }

    public void setCreditCard(int creditCard) {
        CreditCard = creditCard;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }
}
