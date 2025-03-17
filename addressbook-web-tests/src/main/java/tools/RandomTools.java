package tools;
import com.github.javafaker.Faker;


public class RandomTools {

    Faker faker = new Faker();
    public String groupName = faker.pokemon().name(),
            randomHeader = faker.gameOfThrones().quote(),
            randomFooter = faker.educator().university();


}
