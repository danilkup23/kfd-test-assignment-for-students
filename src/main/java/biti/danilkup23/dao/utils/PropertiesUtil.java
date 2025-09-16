package biti.danilkup23.dao.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    private static final String PROPERTIES_NAME = "library.properties";
    private static final Properties PROPS = new Properties();

    static {
        getProps();
    }

    public static String getProperty(String key) {
        return PROPS.getProperty(key);
    }

    private static void getProps() {
        try(InputStream propsStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(PROPERTIES_NAME)){
            PROPS.load(propsStream);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
