package com.elhawary.accounting.service;

import java.util.List;

import com.elhawary.accounting.model.ContactUs;

public interface ContactUsService {

	List<ContactUs> findAll();

	ContactUs save(ContactUs contactUs);

}
