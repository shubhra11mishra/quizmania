package com.ssdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssdi.model.Admin;
import com.ssdi.model.Examiner;
import com.ssdi.service.AdminService;

@RestController
@RequestMapping("/quizmania/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public Admin register(@RequestBody Admin admin) {
		return adminService.createAdmin(admin);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete")
	public void delete(@RequestBody Admin admin) {
		adminService.deleteAdmin(admin);
	}
	
}
