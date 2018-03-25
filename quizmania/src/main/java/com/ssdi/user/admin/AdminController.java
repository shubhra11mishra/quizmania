package com.ssdi.user.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quizmania/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public Admin login(@RequestBody Admin admin) {		
		return adminService.getAdminByEmail(admin);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public Admin register(@RequestBody Admin admin) {
		return adminService.createAdmin(admin);
	}

}
