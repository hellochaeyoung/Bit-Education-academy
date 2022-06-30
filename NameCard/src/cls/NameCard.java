package cls;

public class NameCard {
	
	String name;
	String phone;
	String email;
	
	PrintNameCard pNameCard;
	PrintPhoneCard pPhoneCard;
	
	public NameCard(String name, String phone, String email) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	public void setPrintNameCard(PrintNameCard p) {
		pNameCard = p;
	}
	
	public void print() {
		pNameCard.print(this);
	}
	
	
	public void setPrintPhoneCard(PrintPhoneCard p) {
		pPhoneCard = p;
	}
	
	public void printPhone() {
		pPhoneCard.print(this);
	}

}
