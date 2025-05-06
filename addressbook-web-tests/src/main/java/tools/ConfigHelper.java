package tools;

import org.aeonbits.owner.ConfigFactory;

import java.util.Map;

public class ConfigHelper{
    public static DriverConfig getDriverConfig() {
        return ConfigFactory.create(DriverConfig.class);
    }

    public static WebConfig getWebConfig() {
        return ConfigFactory.create(WebConfig.class);
    }
}
