package Main.Entities;

public class FacilityUser extends Person {

	private int CreditCard;

	private String CompanyName;

	public FacilityUser() {

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
