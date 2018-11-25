package android.api.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import android.api.model.User;

public interface UserRepository extends MongoRepository<User, String> { //CrudRepository<User, String> {

	public User findByLogin(String login);
	
}
