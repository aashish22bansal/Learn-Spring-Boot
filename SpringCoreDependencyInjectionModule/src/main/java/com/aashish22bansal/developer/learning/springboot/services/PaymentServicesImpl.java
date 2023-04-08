package com.aashish22bansal.developer.learning.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aashish22bansal.developer.learning.springboot.dao.PaymentDAO;

/**
 * @author Aashish Bansal
 *
 */
@Service
public class PaymentServicesImpl implements PaymentService {
	
	/**
	 * @author Aashish Bansal
	 * Here, the annotation @Autowired will tell Spring that
	 */
	@Autowired
	private PaymentDAO dao;

	/**
	 * @return the dao
	 */
	public PaymentDAO getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(PaymentDAO dao) {
		this.dao = dao;
	}
}
