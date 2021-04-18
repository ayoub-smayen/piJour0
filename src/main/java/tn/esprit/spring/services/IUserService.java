package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entity.Publication;
import tn.esprit.spring.entity.User;

public interface IUserService {
	
	public void AddUser(User user);
	public List<User> RetrieveUser();
	public void UpdateUserById(User user, int id);
	public void DeleteUser(int id);

}
