/**
 * Leaf: mot ca nhan, mot dia chi email.
 */
public class IndividualContact extends Contact {

	private final String name;
	private final String email;

	public IndividualContact(String name, String email) {
		this.name = name;
		this.email = email;
	}

	@Override
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public void sendMail(String subject, String body) {
		System.out.println("[Gui thu] To: " + name + " <" + email + ">");
		System.out.println("  Subject: " + subject);
		System.out.println("  Body: " + body);
	}
}
