package io.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import io.db.entity.User;
import io.db.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@EnableMongoRepositories(basePackages = "io.db.repository.UserRepository")
public class UserService {
	
	@Autowired
	private final UserRepository userRepository;
	
	public User create(User user)
	{
		return userRepository.save(user);
	}
	
	public User getById(String id)
	{
		return userRepository.findById(id).get();
	}
	
	public User update(User user)
	{
		return userRepository.save(user);
	}
	
	public void delete(String id)
	{
		userRepository.deleteById(id);
	}
}
