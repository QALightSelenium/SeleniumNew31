package suit;

import aparattest.AddAparatTest;
import logintests.InvalidLoginWithParametrs;
import logintests.ValidLogin;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import parentTest.ParentTest;


    @RunWith(Suite.class)
    @Suite.SuiteClasses({
            ValidLogin.class,
            InvalidLoginWithParametrs.class,
    })

public class SuitLogin{


}
