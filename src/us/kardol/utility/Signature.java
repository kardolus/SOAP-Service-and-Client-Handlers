package us.kardol.utility;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 * @author Guillermo Kardolus
 */
public class Signature {
    public String getSignature(String key, String data){
        String result = null;
        
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            
            result = Base64.encodeBase64String(sha256_HMAC.doFinal(data.getBytes("UTF-8")));
        } catch (InvalidKeyException | NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            Logger.getLogger(Signature.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
}
