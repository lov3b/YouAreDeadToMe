public class OSUtil {
    public enum OS {
        WINDOWS, LINUX, MAC
    }

    private static OS os = null;

    public static OS getOS() {
        if (os == null) {
            String operatingSystem = System.getProperty("os.name");
            if (operatingSystem.contains("win"))
                os = OS.WINDOWS;
            else if (operatingSystem.contains("mac"))
                os = OS.MAC;
            else if (operatingSystem.contains("nix") || operatingSystem.contains("nux")) {
                os = OS.LINUX;
            }
        }
        return os;
    }

}
