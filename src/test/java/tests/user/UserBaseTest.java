package tests.user;

import data.user.UserDataFactory;
import org.testng.annotations.BeforeMethod;
import specs.InitialStateSpec;
import specs.SpecManager;
import tests.BaseTest;

public class UserBaseTest extends BaseTest {
    protected static UserDataFactory userDataFactory;

    @BeforeMethod
    public void setupUsers() {
        SpecManager.setRequestSpec(InitialStateSpec.set());
        userDataFactory = new UserDataFactory();
    }
}
