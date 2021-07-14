package io.db.api.dataTransfObj;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDataTransfObj {
	private String id;
	private String name;
	private String surname;
	private String dateOfBitrh;
}
