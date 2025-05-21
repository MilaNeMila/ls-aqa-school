package tools;
import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config.properties"
})
public interface WebConfig extends Config{
    @Key("baseUrl")
    String baseUrl();
}

