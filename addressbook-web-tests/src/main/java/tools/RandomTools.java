package tools;
import com.github.javafaker.Faker;


public class RandomTools {

    Faker faker = new Faker();
    public String groupName = faker.pokemon().name();
    public String randomHeader = faker.gameOfThrones().quote();
    public String randomFooter = faker.educator().university();
}
