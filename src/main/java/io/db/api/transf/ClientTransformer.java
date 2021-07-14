package io.db.api.transf;
import io.db.api.dataTransfObj.ClientDataTransfObj;
import io.db.entity.Client;

public class ClientTransformer {
	public static ClientDataTransfObj transform (Client client, String id)
	{
		return ClientDataTransfObj.builder()
				.id(id)
				.name(client.getName())
				.surname(client.getSurname())
				.dateOfBitrh(client.getDateOfBitrh())
				.build();
	}
	
	public static Client transform (ClientDataTransfObj client, String id)
	{
		return Client.builder()
				.id(id)
				.name(client.getName())
				.surname(client.getSurname())
				.dateOfBitrh(client.getDateOfBitrh())
				.build();
	}
}
