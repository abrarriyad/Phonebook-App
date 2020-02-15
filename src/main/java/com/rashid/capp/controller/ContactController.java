package com.rashid.capp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rashid.capp.domain.Contact;
import com.rashid.capp.service.ContactService;

@Controller
public class ContactController {
	
		@Autowired
		private ContactService contactService;
		
		@RequestMapping(value="/user/contact_form")
		public String contactForm(Model model) {
			Contact contact = new Contact();
			model.addAttribute("command" , contact);
			
			return "contact_form"; //JSP Form view
		}
		
		@RequestMapping(value="/user/save_contact")
		public String saveOrUpdateContact(@ModelAttribute("command") Contact contact, Model model,HttpSession session) {
			Integer contactId = (Integer) session.getAttribute("aContactId");
			if(contactId==null) {
				//save task
				try {	
					Integer userId = (Integer) session.getAttribute("userId");
					contact.setUserId(userId); //FK Logged in userId
					contactService.save(contact);
					return "redirect:clist?act=sv"; 
				}catch(Exception e) {
					model.addAttribute("err", "Failed to save contact");
					return "contact_form";
				}
			}else {
				//update task
				try {	
					contact.setContactId(contactId); //PK
					contactService.update(contact);
					return "redirect:clist?act=ed"; 
				}catch(Exception e) {
					model.addAttribute("err", "Failed to Edit contact");
					return "contact_form";
				}
			}
			
	}
	
		@RequestMapping(value="/user/clist")
		public String contactList(Model model, HttpSession session) {
			Integer userId = (Integer) session.getAttribute("userId");
			model.addAttribute("contactList", contactService.findUserContacts(userId));
			return "clist"; //JSP Form view
		}
		
		@RequestMapping(value="/user/contact_search")
		public String contactSearch(Model model, HttpSession session, @RequestParam("freeText") String freeText) {
			Integer userId = (Integer) session.getAttribute("userId");
			
			model.addAttribute("contactList", contactService.findUserContacts(userId,freeText));
			return "clist"; //JSP Form view
		}
		
		@RequestMapping(value="/user/del_contact")
		public String deleteContact(@RequestParam("cid") Integer contactId) {
			contactService.delete(contactId);
			return "redirect:clist?act=del";
		}
		
		@RequestMapping(value="/user/bulk_cdelete")
		public String deleteBulkContact(@RequestParam("cid") Integer[] contactIds) {
			contactService.delete(contactIds);
			return "redirect:clist?act=del";
		}
		
		@RequestMapping(value="/user/edit_contact")
		public String prepareEditForm(Model model, HttpSession session,@RequestParam("cid") Integer contactId) {
			session.setAttribute("aContactId", contactId);
			Contact contact = contactService.findById(contactId);
			model.addAttribute("command",contact);
			return "contact_form";
		}
		
}
