package tools;
import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config.properties"
})
public interface WebConfig extends Config{
    @Key("baseUrl")
    @DefaultValue("http://localhost:8080/addressbook")
    String baseUrl();
}
