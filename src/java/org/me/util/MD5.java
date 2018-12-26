


package org.me.util;

import java.security.*;
import java.math.*;

public class MD5 {
   
    public static String encode(String value) throws Exception{
       MessageDigest m=MessageDigest.getInstance("MD5");
       m.update(value.getBytes(),0,value.length());
       return new BigInteger(1,m.digest()).toString(16);
    }
}
