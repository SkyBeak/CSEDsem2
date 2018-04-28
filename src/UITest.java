import static org.junit.Assert.*;

import org.junit.Test;

public class UITest {

	UI u = new UI();
	
	@Test
	public void isNumeric() {
		assertTrue(u.isNumeric("9999999"));
		assertTrue(u.isNumeric("0"));
		assertFalse(u.isNumeric("999g999"));
		assertFalse(u.isNumeric("abc"));
	}
	
	@Test
	public void isNumericNeg(){
		assertTrue(u.isNumeric("-10"));
	}
	
	@Test
	public void checkDateValidity(){
		assertTrue(u.checkDateValidity("27/04/2018"));
		assertTrue(u.checkDateValidity("10/11/1997"));
		assertFalse(u.checkDateValidity("13/13/1313"));
		assertFalse(u.checkDateValidity("28/04/2018"));
		assertFalse(u.checkDateValidity("abc"));
	}

}
