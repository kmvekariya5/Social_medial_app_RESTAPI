package com.komal.springboot.restAPI.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
	
	//Storing data in List temporary memory
	private static int count = 0;
	private static ArrayList<User> userList = new ArrayList<User>();
	static
	{
		userList.add(new User(++count,"Adam",LocalDate.now().minusYears(30)));
		userList.add(new User(++count,"Eve",LocalDate.now().minusYears(25)));
		userList.add(new User(++count,"Zen",LocalDate.now().minusYears(33)));
	}
	
	public ArrayList<User> findAll()
	{
		return userList;
	}
	
	public User findById(Integer id)
	{
		Predicate<? super User> predicate = (User x)->x.getId() == id;
		return userList.stream().filter(predicate).findFirst().orElse(null);
		
	}
	
	public void deleteById(Integer id)
	{
		Predicate<? super User> predicate = (User x)->x.getId() == id;
		userList.removeIf(predicate);		
	}
	
	public User saveUser(User user)
	{
		//userList.add(new User(++count,user.getName(),user.getBdate()));
		user.setId(++count);
		userList.add(user);
		return user;
	}
}
