import org.junit.Test;

import static org.junit.Assert.*;

public class CaloriesTester {

    Calories c = new Calories();
    User testUser = new User("Tessa",165,"12/05/1986",62,"female");

    @Test
    public void maintain(){
        assertEquals(1397,c.maintain(testUser));
    }

    @Test
    public void BMR() {
        assertEquals(88.362, c.BMR(0,0,0,"male"),0.0001);
        assertEquals(447.593, c.BMR(0,0,0,"female"), 0.0001);
        assertEquals(267.9775, c.BMR(0,0,0,""),0.00001);
        assertEquals(100.881, c.BMR(1,1,1,"male"),0.0001);
        assertEquals(455.608, c.BMR(1,1,1,"female"),0.0001);
        assertEquals(278.2445, c.BMR(1,1,1,""), 0.00001);
        assertEquals(12607.362, c.BMR(1000,1000,1000,"male"),0.0001);
        assertEquals(8462.593, c.BMR(1000,1000,1000,"female"), 0.0001);
        assertEquals(10534.9775, c.BMR(1000,1000,1000,""), 0.00001);
        assertEquals(1824.422, c.BMR(70,190,20,"male"), 0.0001);
        assertEquals(1596.903, c.BMR(70,190,20,"female"), 0.0001);
        assertEquals(1710.6625, c.BMR(70,190,20,""), 0.00001);
        assertEquals(455.608, c.BMR(01,1,001,"female"),0.0001);
    }

    @Test
    public void dailyIntake() {
        assertEquals(0,c.dailyIntake(0,0),0.0001);
        assertEquals(0,c.dailyIntake(0,999999999),0.0001);
        assertEquals(0,c.dailyIntake(01,0),0.0001);
        assertEquals(1,c.dailyIntake(1,1),0.0001);
        assertEquals(1,c.dailyIntake(2,0.5),0.0001);
        assertEquals(99980001,c.dailyIntake(9999,9999),0.0001);
    }
}