import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    User u = new User();

    @Test
    public void ageCalc() {
        assertEquals(-2,u.ageCalc("26/04/2020","26/04/2018"));
        assertEquals(0,u.ageCalc("26/04/2018","26/04/2018"));
        assertEquals(48,u.ageCalc("01/01/1970","26/04/2018"));
    }
}