import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseTest {

    @BeforeMethod
    public void beforeMethod(Method method){
        System.out.println("Method name : " +method.getName() + "/n" + "Thread Id : " +Thread.currentThread().getId());
    }
}
