public class TestBuilderPattern {

	public static void main(String[] args) {
		CourseWebsiteBuilder builder = new DacTaPhanMemBuilder();
		CourseDirector director = new CourseDirector(builder);
		director.constructFullWebsite();
		System.out.println(builder.getWebsite());
		System.out.println();

		builder = new TuTuongHCMBuilder();
		director = new CourseDirector(builder);
		director.constructFullWebsite();
		System.out.println(builder.getWebsite());
	}
}
