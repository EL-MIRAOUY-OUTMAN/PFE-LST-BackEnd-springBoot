package com.springrest.pfe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.pfe.model.User;
import com.springrest.pfe.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public User inscrire(User user) {
		return	userRepository.save(user);
	}

	@Override
	public boolean authentifier(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void supprimer(Long ID) {
	userRepository.deleteById(ID);

	}

	@Override
	public String notifier(Long ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findall() {
		
		return userRepository.findAll();
	}

	@Override
	public User findbyid(Long id) {
	return userRepository.findByIdUser(id); 
	}

	@Override
	public User testeUser(String email,String password ) {
		User user =userRepository.findByEmail(email);
	   
	    if (user!=null) {
	    	 String pass=user.getPassword();
		if (pass.equals(password)) {
		return user;
		}
		else return null;
		}
		else return null;
	}

}
