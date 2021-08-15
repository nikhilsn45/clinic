package com.persistent.service;

import java.util.Arrays;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.persistent.dao.UserDao;
import com.persistent.entities.User;

@Service
@Transactional
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserDao udao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UserService(UserDao udao) {
		this.udao = udao;
	}

	public UserService() {
	}
	
	public void addUser(User u)
	{
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		udao.save(u);
	}
	
	public User getUserByUserNameAndPassword(String un, String p)
	{
		return udao.findUserByUserNameAndPassword(un,p);
	}
	
	/*public User getUserByUserName(String un) {
		return udao.findUserByUserName(un);
	}


	public String checkPasswordForUserName(String un) {
		User u = getUserByUserName(un);
		return u.getPassword();
	}*/
	
	

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(String role){
		return Arrays.asList(new SimpleGrantedAuthority(role));
	}
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		if(userName.equals("admin"))
			return new org.springframework.security.core.userdetails.User("admin", "$2a$10$B7DBPbsxTM6DBXyC6hzKuOKC5urOkZh77dlqAGcc8P1prPa1q5zZq", mapRolesToAuthorities("ROLE_admin"));

		User user = udao.findByUserName(userName);
		System.out.println("here "+ userName);
		
		if(user==null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), mapRolesToAuthorities(user.getType()));

	}


}
