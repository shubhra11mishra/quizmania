package com.ssdi.service;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.ssdi.dao.AdminPasscodeRepository;
import com.ssdi.dao.AdminRepository;
import com.ssdi.model.Admin;
import com.ssdi.model.AdminPasscode;

import mockit.*;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.Verifications;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class AdminServiceTest {

	@Injectable
	private AdminRepository adminRepository;
	
	@Injectable
	private AdminPasscodeRepository adminPasscodeRepository = new AdminPasscodeRepository() {
		
		@Override
		public <S extends AdminPasscode> Iterable<S> saveAll(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public <S extends AdminPasscode> S save(S entity) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Optional<AdminPasscode> findById(String id) {
			// TODO Auto-generated method stub
			AdminPasscode adminPasscode = new AdminPasscode();
			adminPasscode.setPasscode("123456");
			Optional<AdminPasscode> opt = Optional.of(adminPasscode);
			return opt;
		}
		
		@Override
		public Iterable<AdminPasscode> findAllById(Iterable<String> ids) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Iterable<AdminPasscode> findAll() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public boolean existsById(String id) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void deleteById(String id) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAll(Iterable<? extends AdminPasscode> entities) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void delete(AdminPasscode entity) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public long count() {
			// TODO Auto-generated method stub
			return 0;
		}
	};
	
	@Tested
	AdminService adminService;
	
	@Test
	public void createAdminServiceTest() {
		Admin testAdmin = new Admin("TestUserFirstName", "TestUserLastName", "TestUserEmail", "TestUserPassword",
				"123456");
		
		new Expectations() {
			{
				adminRepository.save(testAdmin);
			}
		};
		
		adminService.createAdmin(testAdmin);
	}
	
}
