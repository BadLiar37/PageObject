package pageobject.util;

import java.util.ResourceBundle;

public class TestDataReader {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("dev");

    public static String getTestData(String key) {
        String resource = resourceBundle.getString(key);

        return resource.equals("NONE") ? "" : resource;
    }
}
