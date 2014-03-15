package Main.Entities.usage;

import Main.Entities.Person;

public class UnitUserImpl extends Person implements UnitUser {


    private String creditCard;

	private String companyName;

    private int unitUserId;

	public UnitUserImpl() {

	}


    @Override
    public String getCreditCard() {
        return creditCard;
    }

    @Override
    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public String getCompanyName() {
        return companyName;
    }

    @Override
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public int getUnitUserId(){
        return unitUserId;
    }

}
