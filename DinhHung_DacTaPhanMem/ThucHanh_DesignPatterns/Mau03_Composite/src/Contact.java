import java.util.List;

/**
 * Component: dia chi lien lac (ca nhan hoac nhom).
 */
public abstract class Contact {

	public abstract String getName();

	public abstract void sendMail(String subject, String body);

	public void add(Contact child) {
		throw new UnsupportedOperationException("Chi nhom moi them thanh vien");
	}

	public void remove(Contact child) {
		throw new UnsupportedOperationException("Chi nhom moi xoa thanh vien");
	}

	public List<Contact> getMembers() {
		throw new UnsupportedOperationException("Chi nhom moi co danh sach thanh vien");
	}
}
