import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	UITest.class,
	UserTest.class,
	CaloriesTester.class})
public class AllTests {
	
}
