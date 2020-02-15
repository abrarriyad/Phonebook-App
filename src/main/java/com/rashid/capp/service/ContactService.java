package com.rashid.capp.service;

import java.util.List;

import com.rashid.capp.domain.Contact;

public interface ContactService {
	
	public void save(Contact contact);
	public void update(Contact contact);
	public void delete(Integer contactId);
	public void delete(Integer[] contactIds);
	public Contact findById(Integer contactId);
	public List<Contact> findUserContacts(Integer userId);
	public List<Contact> findUserContacts(Integer userId, String txt);
	
}
