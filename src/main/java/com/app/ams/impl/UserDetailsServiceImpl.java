package com.app.ams.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.app.ams.model.MyUserDetails;
import com.app.ams.model.Privilege;
import com.app.ams.model.User;
import com.app.ams.service.UserService;

public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserService userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		Privilege privilege = user.getPrivilege();
		// System.out.println(privilege.getAccess());
		// for (Role role : user.getRoles()) {
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + privilege.getAccess()));
		// }

		org.springframework.security.core.userdetails.User _user = new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), grantedAuthorities);
		MyUserDetails customUserDetail = new MyUserDetails(user, _user);
		customUserDetail.setAuthorities(grantedAuthorities);
		// return new
		// org.springframework.security.core.userdetails.User(user.getUsername(),
		// user.getPassword(),
		// grantedAuthorities);
		return customUserDetail;
	}
}
