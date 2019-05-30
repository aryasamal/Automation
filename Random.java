package com.seleniumtests.dataobject;

import java.security.SecureRandom;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   
		password(10);
		
	}
	
	public static String password(int randomStrLength) {
		char[] possibleCharacters = (new String("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?")).toCharArray();
		String randomStr = RandomStringUtils.random( randomStrLength, 0, possibleCharacters.length-1, false, false, possibleCharacters, new SecureRandom() );
		System.out.println( randomStr );
		
		return randomStr;
		
	}
}
