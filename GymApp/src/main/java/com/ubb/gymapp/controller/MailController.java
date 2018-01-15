package com.ubb.gymapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ubb.gymapp.dto.Mail;
import com.ubb.gymapp.model.Client;
import com.ubb.gymapp.model.Subscription;
import com.ubb.gymapp.service.SubscriptionService;

import com.ubb.gymapp.utils.MailUtil;



@RestController
public class MailController {
	@Autowired
	private SubscriptionService subscriptionService;
	@RequestMapping(value = "/mailSender", method = RequestMethod.POST)
	public String sendMail(@RequestBody Mail mail) {
		try {
			List<String> emailAdressList = getMailAdreses(mail.getSubs());
			for(String adress : emailAdressList){
				MailUtil.sendMail(mail.getSubject(), mail.getBody(), adress);
			}
			return "Successfully Sent E-mails";
		}catch (Exception e){
			return "Failed to Send E-mails";
		}
	}
	
	public List<String> getMailAdreses(List<Subscription> listOfSubs){
		List<String> list = new ArrayList<String>();
		List<Client> listClients = subscriptionService.findClients(listOfSubs);
			for(Client elemClient : listClients){
				list.add(elemClient.getEmail());
			}
		
		return list;
	}
}
