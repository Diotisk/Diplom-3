package site.stellarburgers.apiOperations;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import site.stellarburgers.models.User;

import static io.restassured.RestAssured.given;

public class UserOperations {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
    }

    public User generateUserData() {

        String email = RandomStringUtils.randomAlphabetic(3) + "@"
                + RandomStringUtils.randomAlphabetic(5) + ".com";
        String password = RandomStringUtils.randomNumeric(8);
        String name = RandomStringUtils.randomAlphabetic(8);

        User newUser = new User(email, password, name);

        return newUser;

    }

    public User generateUserDataWithInvalidPassword() {

        String email = RandomStringUtils.randomAlphabetic(3) + "@"
                + RandomStringUtils.randomAlphabetic(5) + ".com";
        String password = RandomStringUtils.randomNumeric(2);
        String name = RandomStringUtils.randomAlphabetic(8);

        User newUser = new User(email, password, name);

        return newUser;

    }

    public Response createUser(User newUser) {

        Response response = given()
                .header("Content-Type", "application/json")
                .body(newUser)
                .post("/api/auth/register");

        return response;
    }

    public Response loginUser(User userLoginCredentials) {
        Response response = given()
                .header("Content-Type", "application/json")
                .body(userLoginCredentials)
                .post("/api/auth/login");

        return response;
    }

    public void deleteUser(String accessToken) {

        given()
                .header("Authorization", accessToken)
                .when()
                .delete("/api/auth/user")
                .then().statusCode(202);

    }

}