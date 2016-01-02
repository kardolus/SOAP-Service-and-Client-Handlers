package us.kardol.utility;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Guillermo Kardolus
 */
public class TimeStampTest {
    /**
     * Test of getTimeStamp method, of class TimeStamp.
     */
    @Test
    public void testGetTimeStamp() {
        Date d = new Date(1449862511021L);
        TimeStamp instance = new TimeStamp();
        System.out.println("Testing " + instance.getClass().getName() + ".getTimeStamp(date)");
        String expResult = "2015-12-11T19:35:11Z";
        String result = instance.getTimeStamp(d);
        assertEquals(expResult, result);
    }
    
}
