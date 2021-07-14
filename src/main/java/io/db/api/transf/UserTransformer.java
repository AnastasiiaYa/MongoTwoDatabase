package io.db.api.transf;
import io.db.api.dataTransfObj.UserDataTransfObj;
import io.db.entity.User;

public class UserTransformer {

	public static UserDataTransfObj transform(User user, String id)
	{
		return UserDataTransfObj.builder()
				.id(id)
				.name(user.getName())
				.surname(user.getSurname())
				.dateOfBitrh(user.getDateOfBitrh())
				.build();
	}
	
	public static User transform(UserDataTransfObj user, String id)
	{
		return User.builder()
				.id(id)
				.name(user.getName())
				.surname(user.getSurname())
				.dateOfBitrh(user.getDateOfBitrh())
				.build();
	}
	
}
