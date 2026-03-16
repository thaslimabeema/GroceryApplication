package utility;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	Faker f = new Faker();

	public String randomUsername() {
		return f.name().username();
	}

	public String randomPassword() {
		return f.internet().password();
	}

	public String randomFullname() {
		return f.name().fullName();
	}

	public String randomEmail() {
		return f.internet().emailAddress();
	}

	public String randomMobileNumber() {
		return f.phoneNumber().cellPhone();
	}

}
