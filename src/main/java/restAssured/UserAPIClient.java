package restAssured;

import io.restassured.RestAssured;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import pojo.CreateUser;
import pojo.UpdateUser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class UserAPIClient{
    public UserAPIClient() throws IOException {
        this.config = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        this.config.load(fis);

    }
    String createUserEndPoint = "/api/users";
    String getUserEndPoint = "/api/users/%s";
    String updateUserEndPoint = "/api/users/%s";
    Properties config;
    CreateUser createUser = new CreateUser();
    UpdateUser updateUser = new UpdateUser();

    private static String userId;

    public CreateUser createUser () {

        createUser.setName(config.getProperty("name"));
        createUser.setJob(config.getProperty("job"));

        {
        String response = RestAssured.given()
                .contentType("application/json").log().all()
                .body(createUser)
                .post(config.getProperty("baseURI") +createUserEndPoint ).then().log().all()
                .statusCode(201)
                .extract().response()
                .getBody().asString();

        // Fetching the token and add it to CardService
        JSONObject jsonObject = new JSONObject(response);
        userId = jsonObject.optString("id");

    }
    return createUser;
}

    public  void getCreatedUserDetails ()  {


        {
            String response = RestAssured.given()
                    .contentType("application/json").log().all()
                    .when()
                    .get(config.getProperty("baseURI") +String.format(getUserEndPoint,userId) )
                    .then().log().all()
                    .statusCode(200)
                    .extract().response()
                    .getBody().asString();

        }
    }

    public UpdateUser updateUser () {

        updateUser.setName(config.getProperty("updatedName"));
        updateUser.setJob(config.getProperty("updatedJob"));

        {
            String response = RestAssured.given()
                    .contentType("application/json").log().all()
                    .body(updateUser)
                    .put(config.getProperty("baseURI") +String.format(updateUserEndPoint,userId)).then().log().all()
                    .statusCode(200)
                    .extract().response()
                    .getBody().asString();

        }
        return updateUser;
    }

}



