package com.ear.core.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;

import org.apache.commons.lang3.RandomStringUtils;
public class PasswordUtil {

	public String generatePasswordRandom() {	
		
		String strPassword = "";
		
		try {
			
			char[] possibleCharacters = (new String("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?")).toCharArray();
			String randomPassword = RandomStringUtils.random( 11, 0, possibleCharacters.length-1, false, false, possibleCharacters, new SecureRandom());
			
		    InputStream targetStream = new ByteArrayInputStream(randomPassword.getBytes());
		    
			int ch;			
			
			while(true) {				
				ch = targetStream.read();				
				if(ch == -1 || (char)ch == '\n') {
					break;
				} 				
				else if ((char) ch != '\r'){
					strPassword = strPassword + (char)ch;
				}
			}
					    
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		return strPassword;
		
	}	
    
}
