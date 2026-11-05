import java.util.ArrayList;
import java.util.List;

/**
 * Composite: nhom gom ca nhan hoac nhom con.
 */
public class GroupContact extends Contact {

	private final String groupName;
	private final List<Contact> members = new ArrayList<>();

	public GroupContact(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String getName() {
		return groupName;
	}

	@Override
	public void add(Contact child) {
		members.add(child);
	}

	@Override
	public void remove(Contact child) {
		members.remove(child);
	}

	@Override
	public List<Contact> getMembers() {
		return members;
	}

	@Override
	public void sendMail(String subject, String body) {
		System.out.println("=== Gui thu den NHOM: " + groupName + " ===");
		for (Contact member : members) {
			member.sendMail(subject, body);
		}
		System.out.println("=== Het nhom " + groupName + " ===\n");
	}
}
