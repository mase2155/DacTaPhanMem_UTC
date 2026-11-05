import java.util.HashMap;
import java.util.Map;

public final class PlatformFactory {

	private static final Map<String, Platform> cache = new HashMap<>();

	private PlatformFactory() {
	}

	public static synchronized Platform getPlatformInstance(String type) {
		Platform platform = cache.get(type);
		if (platform == null) {
			switch (type) {
				case "PYTHON":
					platform = new PythonPlatform();
					break;
				case "JAVA":
					platform = new JavaPlatform();
					break;
				default:
					throw new IllegalArgumentException("Nen tang chua ho tro: " + type);
			}
			cache.put(type, platform);
		} else {
			System.out.println("[Factory] Tai su dung flyweight da co: " + type);
		}
		return platform;
	}
}
