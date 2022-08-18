package datos;

import java.math.BigInteger;
import java.security.MessageDigest;

public class GetMD5 {
	public String getMD5(String pass) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] encBytes = md.digest(pass.getBytes());
			BigInteger num = new BigInteger(1, encBytes);
			String encString = num.toString(16);
			while (encString.length() < 32) {
				encString = "0" + encString;
			}
			return encString;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
