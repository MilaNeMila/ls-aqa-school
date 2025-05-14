package tools;
import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${browser}.properties"
})
public interface DriverConfig extends Config {
    @Key("browser")
    @DefaultValue("chrome")
    String browser();
}
