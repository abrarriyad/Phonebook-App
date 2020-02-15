package com.rashid.capp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rashid.capp.dao.BaseDAO;
import com.rashid.capp.dao.ContactDAO;
import com.rashid.capp.domain.Contact;
import com.rashid.capp.rm.ContactRowMapper;
import com.rashid.capp.util.StringUtil;

@Service
public class ContactServiceImpl extends BaseDAO implements ContactService{

	@Autowired
	private ContactDAO contactDAO;
	
	@Override
	public void save(Contact contact) {
		contactDAO.save(contact);
	}

	@Override
	public void update(Contact contact) {
		contactDAO.update(contact);
		
	}

	@Override
	public void delete(Integer contactId) {
		contactDAO.delete(contactId);
		
	}

	@Override
	public void delete(Integer[] contactIds) {
		String ids = StringUtil.toCommaSeparetedString(contactIds);
		String sql = "DELETE FROM contact WHERE contactId IN("+ids+")";
		getJdbcTemplate().batchUpdate(sql);
		
	}

	@Override
	public List<Contact> findUserContacts(Integer userId) {
		return contactDAO.findByProperty("userId", userId);
		
	}

	@Override
	public List<Contact> findUserContacts(Integer userId, String txt) {
		String sql ="SELECT contactId, userId, name, phone, email, address, remark FROM contact WHERE userId=? "
				+ "AND (name like '%"+txt+"%' OR address like '%"+txt+"%' OR phone like '%"+txt+"%' OR email like '%"+txt+"%' OR remark like '%"+txt+"%')";
		
		return 	getJdbcTemplate().query(sql, new ContactRowMapper(),userId); 
	}

	@Override
	public Contact findById(Integer contactId) {
		return contactDAO.findById(contactId);
		
	}

}
