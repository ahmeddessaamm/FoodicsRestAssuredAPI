package testPackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.CreateUser;
import pojo.UpdateUser;
import restAssured.UserAPIClient;

import java.io.IOException;

public class RestAssuredAPITests  {
    UserAPIClient userAPIClient = new UserAPIClient();


    RestAssuredAPITests() throws IOException {
    }

    @Test(priority = 1)
    public void createUserTest()  {
        CreateUser createdUser = userAPIClient.createUser();
        Assert.assertEquals(createdUser.getName(), "ahmed");
        Assert.assertEquals(createdUser.getJob(), "engineer");
    }
    @Test(priority = 2)
    public void getUserDetailsTest()
    {
        userAPIClient.getCreatedUserDetails();

    }
    @Test(priority = 3)
    public void updateUserDetailsTest()  {
        UpdateUser updateUser = userAPIClient.updateUser();

        Assert.assertEquals(updateUser.getName(), "mahmoud");
        Assert.assertEquals(updateUser.getJob(), "doctor");
    }
}
