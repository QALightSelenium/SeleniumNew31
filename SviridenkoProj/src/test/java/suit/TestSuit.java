package suit;

import aparattest.AddAparatTest;
import aparattest.InvalidAddAparatWithParametrs;
import logintests.InvalidLoginWithParametrs;
import logintests.ValidLogin;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ValidLogin.class,
        InvalidLoginWithParametrs.class,
        AddAparatTest.class,
        InvalidAddAparatWithParametrs.class
})

public class TestSuit {
}
