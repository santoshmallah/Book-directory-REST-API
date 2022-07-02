package com.santosh.main.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import com.santosh.main.model.BookVO;
import com.santosh.main.model.UserVO;

public class BookUtil {

	public static List<BookVO> getDiscountedPrice(List<BookVO> bookVOs) {
		List<BookVO> newBookVOs = new ArrayList<BookVO>();
		BookVO bookVO = null;
		try {
			for (BookVO b : bookVOs) {
				bookVO = new BookVO();
				if (b.getCouponCode() != null && b.getCouponCode().equalsIgnoreCase("FIRSTBOOK")) {
					int price = b.getPrice();
					int newP = price - (int) (price * 0.3);
					bookVO.setTitle(b.getTitle());
					bookVO.setAuthor(b.getAuthor());
					bookVO.setCouponCode(b.getCouponCode());
					bookVO.setChapters(b.getChapters());
					bookVO.setDateOfPublication(b.getDateOfPublication());
					bookVO.setId(b.getId());
					bookVO.setImage(b.getImage());
					bookVO.setPrice(newP);
					newBookVOs.add(bookVO);
				} else {
					newBookVOs.add(b);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newBookVOs;
	}

	public static String encrypt(String input) throws NoSuchPaddingException, NoSuchAlgorithmException,
			InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

		SecretKey key = AESUtil.generateKey(128);
		IvParameterSpec ivParameterSpec = AESUtil.generateIv();
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);
		byte[] cipherText = cipher.doFinal(input.getBytes());
		return Base64.getEncoder().encodeToString(cipherText);
	}

	public static UserVO encryptUserData(UserVO userVO) {
		UserVO us = new UserVO();
		try {
			us.setEmail(BookUtil.encrypt(userVO.getEmail()));
			us.setName(BookUtil.encrypt(userVO.getEmail()));
			us.setAuthProvider(userVO.getAuthProvider());
			us.setCreatedTime(userVO.getCreatedTime());
			us.setEnable(userVO.isEnable());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return us;
	}

	public static String decrypt(String cipherText) throws NoSuchPaddingException, NoSuchAlgorithmException,
			InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

		SecretKey key = AESUtil.generateKey(128);
		IvParameterSpec ivParameterSpec = AESUtil.generateIv();
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);
		byte[] plainText = cipher.doFinal(Base64.getDecoder().decode(cipherText));
		return new String(plainText);
	}

}
