package io.db.api.controller;
import static io.db.api.transf.ClientTransformer.transform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.db.api.dataTransfObj.ClientDataTransfObj;
import io.db.entity.Client;
import io.db.service.ClientService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {
	
	@Autowired
	private final ClientService clientService;
	
	@PostMapping
	public ClientDataTransfObj create(@RequestBody ClientDataTransfObj clientDto) {
		Client client = transform(clientDto, clientDto.getId());
		return transform(clientService.create(client), client.getId());
	}

	@GetMapping("/{id}")
	public ClientDataTransfObj getClient(@PathVariable("id") String id) {
		return transform(clientService.getById(id), id);
	}

	@PutMapping("/{id}")
	public ClientDataTransfObj update(@PathVariable("id") String id, @RequestBody ClientDataTransfObj client) {
		return transform(clientService.update(transform(client, id)), id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String id) {
		clientService.delete(id);
	}
}
