package helper;

import io.qameta.allure.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AssertStatus {

    @Step
    public static void assertStatusCode(int actualStatusCode, int expectedStatusCode){
        assertThat(actualStatusCode,equalTo(expectedStatusCode));
    }
}
