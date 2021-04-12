package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	UserRepository userrep;

	@Override
	public void AddUser(User user) {
		// TODO Auto-generated method stub
		this.userrep.save(user);
		
	}

	@Override
	public List<User> RetrieveUser() {
		// TODO Auto-generated method stub
		List<User> list = (List<User>)userrep.findAll();
		return list;
	}

	@Override
	public void UpdateUserById(User user, int id) {
		// TODO Auto-generated method stub
		this.userrep.save(user);
		
	}

	@Override
	public void DeleteUser(int id) {
		// TODO Auto-generated method stub
		this.userrep.deleteById(id);
		
	}

}
