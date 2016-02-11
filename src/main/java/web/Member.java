package web;

public class Member {

    private long id;
    private String givenname;
    private String lastName;
    private String address;
    private String email;
    
    public Member(String givenname, String lastName, String address, String email, long id) {
        this.givenname = givenname;
        this.lastName = lastName;
        this.address = address;
        this.email = email;     
        this.id = id;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGivenname() {
		return givenname;
	}

	public void setGivenname(String givenname) {
		this.givenname = givenname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}