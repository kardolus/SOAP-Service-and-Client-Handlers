package us.kardol.utility;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Guillermo Kardolus
 */
public class SignatureTest {

    /**
     * Test of getSignature method, of class Signature.
     */
    @Test
    public void testGetSignature() {
        Signature instance = new Signature();
        System.out.println("Testing " + instance.getClass().getName() + ".getSignature(key,data)");
        String key = "secret", data = "Message";
        String expResult = "qnR8UCqJggD55PohusaBNviGoOJ67HC6Btry4qXLVZc=";
        String result = instance.getSignature(key, data);
        assertEquals(expResult, result);
    }
    
}
