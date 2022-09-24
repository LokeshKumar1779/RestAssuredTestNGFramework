package helper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AssertError {

    public static void assertErrorCode(int actualStatusCode, int expectedStatusCode){
        assertThat(actualStatusCode, equalTo(expectedStatusCode));
    }

    public static void assertErrorStatus(int actualStatus, int expectedStatus){
        assertThat(actualStatus, equalTo(expectedStatus));
    }

    public static void assertErrorMsg(String actualStatusMsg, String expectedStatusMsg){
        assertThat(actualStatusMsg, equalTo(expectedStatusMsg));
    }
}
