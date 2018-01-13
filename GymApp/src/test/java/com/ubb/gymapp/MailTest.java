package com.ubb.gymapp;

import java.security.GeneralSecurityException;

import utils.MailUtil;

public class MailTest {

	public static void main(String[] args) {
		try {
			MailUtil.sendMail("The subject", "The body", "barata.andra@yahoo.ro");
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
