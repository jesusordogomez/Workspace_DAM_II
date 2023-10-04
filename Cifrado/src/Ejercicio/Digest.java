package Ejercicio;

import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Digest {

	public StringBuffer Cifrar(byte[] cad1) throws DigestException, NoSuchAlgorithmException{

		 MessageDigest md = MessageDigest.getInstance("SHA-256");
		     md.update(cad1);
		     byte[] cad1Digest = md.digest();

		StringBuffer hexString = new StringBuffer();
			for(int i = 0; i<cad1Digest.length; i++) {
				hexString.append(Integer.toHexString(0xFF & cad1Digest[i]));
			}
		return hexString;
	}

}
