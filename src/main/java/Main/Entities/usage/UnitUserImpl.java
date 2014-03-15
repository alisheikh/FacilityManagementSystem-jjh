package Main.Entities.usage;

import Main.Entities.PersonImpl;

public class UnitUserImpl extends PersonImpl implements UnitUser {


    private String creditCard;

	private String companyName;



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
    public int getId(){
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

}
