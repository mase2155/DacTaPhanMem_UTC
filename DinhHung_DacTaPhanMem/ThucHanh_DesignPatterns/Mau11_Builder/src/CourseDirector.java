/** Director: dinh nghia thu tu xay dung website mon hoc. */
public class CourseDirector {

	private final CourseWebsiteBuilder builder;

	public CourseDirector(CourseWebsiteBuilder builder) {
		this.builder = builder;
	}

	public void constructFullWebsite() {
		builder.buildDeCuong();
		builder.buildBaiGiang();
		builder.buildThucHanh();
		builder.buildBaiTap();
		builder.buildDanhGia();
	}
}
