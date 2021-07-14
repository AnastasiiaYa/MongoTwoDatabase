package io.db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import io.db.entity.Client;
import io.db.repository.client.ClientRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@EnableMongoRepositories(basePackages = "io.db.repository.ClientRepository")
public class ClientService {
	
	@Autowired
	private final ClientRepository clientRepository;
	
	public Client create(Client client)
	{
		return clientRepository.save(client);
	}
	
	public Client getById(String id)
	{
		return clientRepository.findById(id).get();
	}
	
	public Client update(Client client)
	{
		return clientRepository.save(client);
	}
	
	public void delete(String id)
	{
		clientRepository.deleteById(id);
	}
}
