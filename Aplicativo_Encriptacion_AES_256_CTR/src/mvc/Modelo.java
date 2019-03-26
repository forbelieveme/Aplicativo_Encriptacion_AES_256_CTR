package mvc;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;


public class Modelo {

	static String stringToHexadecimal(String text) throws UnsupportedEncodingException {
		byte[] myBytes = text.getBytes("UTF-8");

		return DatatypeConverter.printHexBinary(myBytes);
	}

	static String byteToHexadecimal(byte[] iv) {

		return DatatypeConverter.printHexBinary(iv);

	}
	/*
	 * public static String decrypt(String key, byte[] initVector, String encrypted)
	 * { try { IvParameterSpec iv = new IvParameterSpec(initVector); SecretKeySpec
	 * skeySpec = new SecretKeySpec(key.getBytes(), "AES");
	 * 
	 * Cipher cipher = Cipher.getInstance("AES/CTR/PKCS5PADDING");
	 * cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
	 * 
	 * byte[] decrypted =
	 * cipher.doFinal(DatatypeConverter.parseHexBinary(encrypted)); return new
	 * String(decrypted); } catch (Exception ex) { ex.printStackTrace(); }
	 * 
	 * return null; }
	 */

	public String desencriptar(String contrasena, String textoEncriptado) throws UnsupportedEncodingException {
		try {
			String[] iv_texto = textoEncriptado.split(":");

			IvParameterSpec iv = new IvParameterSpec(DatatypeConverter.parseHexBinary(iv_texto[0]));
			SecretKeySpec skeySpec = new SecretKeySpec(contrasena.getBytes(), "AES");

			Cipher cipher = Cipher.getInstance("AES/CTR/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);


			byte[] decrypted = cipher.doFinal(DatatypeConverter.parseHexBinary(iv_texto[1]));
			return new String(decrypted);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
		

	}

//	public String encriptar(String contrasena, String texto) throws UnsupportedEncodingException {
//
//		CkCrypt2 encriptar = new CkCrypt2();
//		encriptar.put_CryptAlgorithm("aes");
//		encriptar.put_CipherMode("ctr");
//		encriptar.put_KeyLength(256);
//		encriptar.put_EncodingMode("hex");
//
//		byte[] iv = new byte[16];
//		SecureRandom srandom = new SecureRandom();
//		srandom.nextBytes(iv);
//		String ivStringHex = byteToHexadecimal(iv);
//		System.out.println(ivStringHex);
//
//		encriptar.SetEncodedIV(ivStringHex, "hex");
//
//		encriptar.SetEncodedKey(stringToHexadecimal(contrasena), "hex");
//
//		String textoEncriptado = encriptar.encryptStringENC(texto);
//
//		return ivStringHex + ":" + textoEncriptado;
//	}

}
