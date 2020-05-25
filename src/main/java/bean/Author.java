package bean;

public class Author {
	
	private int authorID;
	private String firstName,lastName;
	
	public  Author() {
		
	}
	
	public Author(String lastName, String firstName) {
		this.lastName=lastName;
		this.firstName=firstName;
	}
	
	public Author(int authorID, String lastName, String firstName) {
		this.authorID=authorID;
		this.lastName=lastName;
		this.firstName=firstName;
	}

	public int getauthorID() {
		return authorID;
	}

	public void setauthorID(int authorID) {
		authorID = authorID;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		firstName = firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		lastName = lastName;
	}

	@Override
	public String toString() {
		return "Author [authorID=" + authorID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", getauthorID()=" + getauthorID() + ", getfirstName()=" + getfirstName() + ", getlastName()="
				+ getlastName() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	
	

}
