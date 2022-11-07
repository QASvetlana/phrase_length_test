import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class lengthTest {
    @ParameterizedTest
    @ValueSource(strings = {"", "hfdjksnbfghdjnvht"})
    public void testForLengthText(String name) {

        if (name.length() < 15) {
            System.out.println("The answer is not expected");
        }
        JsonPath response = RestAssured
                .given()
                .get("http://playground.learnqa.ru/api/hello")
                .jsonPath();
        String answer = response.getString("answer");
        assertEquals("Hello, someone", answer, "The answer is not expected");
    }
}
