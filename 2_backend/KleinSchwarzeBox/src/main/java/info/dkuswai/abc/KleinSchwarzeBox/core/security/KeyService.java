package info.dkuswai.abc.KleinSchwarzeBox.core.security;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class KeyService {
	private PublicKey publicKey = null;
	private PrivateKey privateKey = null;
	private Cipher cipher;
	
	public KeyService() {
		genKey(1024);
	}

	KeyService(int keyLength) {
		genKey(keyLength);
	}
	
	KeyService(String fileName) {
		loadKey(fileName);
	}

	public KeyService(String pubKey, String priKey) {
		makeKey(pubKey, priKey);
	}

	private void genKey(int keyLength) {
		KeyPairGenerator generator;
		try {
			generator = KeyPairGenerator.getInstance("RSA");
			generator.initialize(keyLength);
			KeyPair keyPair = generator.generateKeyPair();
			publicKey = keyPair.getPublic();
			privateKey = keyPair.getPrivate();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		try {
			cipher = Cipher.getInstance("RSA");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}

	public int loadKey(String fileName) {
		try {
			File pubFile = new File(fileName + ".pub");
			byte[] pubKeyBytes = Files.readAllBytes(pubFile.toPath());
			X509EncodedKeySpec pubSpec = new X509EncodedKeySpec(pubKeyBytes);
			
			File priFile = new File(fileName + ".pri");
			byte[] priKeyBytes = Files.readAllBytes(priFile.toPath());
			System.out.println(priKeyBytes.length);
			PKCS8EncodedKeySpec priSpec = new PKCS8EncodedKeySpec(priKeyBytes);

			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			publicKey = keyFactory.generatePublic(pubSpec);
			privateKey = keyFactory.generatePrivate(priSpec);
		} catch (IOException | GeneralSecurityException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int makeKey(String pubKey, String priKey) {
		//@Author: @yoseplee
		//@description:
		//make key from pubkey and prikey from outside source
		//this can be utilized for web application which is independent from keyService instance
		//i.e. a web application based on rest api but want to show key based work,
		//that application has only public key and private key that had made before
		//if it wanted to encoding and decoding througt its key, this should make keyService instance again
		//at this point, this method can strongly be utilized.
		try {
			//decode using Base64 from java util
			//because of missing a single or some characters in key can occur during
			//the casting to String object and vice versa
			byte[] clearPubKey = Base64.getDecoder().decode(pubKey);
			byte[] clearPriKey = Base64.getDecoder().decode(priKey);

			//using public key and private key in a byte[], thrown with String
			//ready to instantiate a KeyService object with those two parameters
			X509EncodedKeySpec pubSpec = new X509EncodedKeySpec(clearPubKey);
			PKCS8EncodedKeySpec priSpec = new PKCS8EncodedKeySpec(clearPriKey);

			//generate keys
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			this.publicKey = keyFactory.generatePublic(pubSpec);
			this.privateKey = keyFactory.generatePrivate(priSpec);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//make cipher
		try {
			cipher = Cipher.getInstance("RSA");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int storeKey(String fileName) {
		try {
			File pubFile = new File(fileName + ".pub");
			FileOutputStream pubOut = new FileOutputStream(pubFile);
			pubOut.write(publicKey.getEncoded());
			pubOut.flush();
			pubOut.close();

			File priFile = new File(fileName + ".pri");
			FileOutputStream priOut = new FileOutputStream(priFile);
			priOut.write(privateKey.getEncoded());
			priOut.flush();
			priOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public String encryptTextToPrivate(String msg){
		String message = "";
		try {
			cipher.init(Cipher.ENCRYPT_MODE, privateKey);
			Base32 encoder = new Base32();
			message = encoder.encode(cipher.doFinal(msg.getBytes("UTF-8")));
		} catch (IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException | InvalidKeyException e) {
 			e.printStackTrace();
		}
		return message;
	}
	public String encryptTextToPublic(String msg){
		String message = "";
		try {
			cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			Base32 encoder = new Base32();
			message = encoder.encode(cipher.doFinal(msg.getBytes("UTF-8")));
		} catch (IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException | InvalidKeyException e) {
 			e.printStackTrace();
		}
		return message;
	}

	public String decryptTextToPublic(String msg) {
		String message = "";
		try {
			cipher.init(Cipher.DECRYPT_MODE, publicKey);
			Base32 decoder = new Base32();
			message = new String(cipher.doFinal(decoder.decode(msg)), "UTF-8");
		} catch (InvalidKeyException | UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return message;
	}
	public String decryptTextToPrivate(String msg) {
		String message = "";
		try {
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			Base32 decoder = new Base32();
			message = new String(cipher.doFinal(decoder.decode(msg)), "UTF-8");
		} catch (InvalidKeyException | UnsupportedEncodingException | IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		return message;
	}
	public PublicKey getPublicKey(){
		return publicKey;
	}
	public PrivateKey getPrivateKey(){
		return privateKey;
	}
}