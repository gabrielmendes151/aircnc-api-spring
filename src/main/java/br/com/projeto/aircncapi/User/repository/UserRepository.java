package br.com.projeto.aircncapi.User.repository;

import br.com.projeto.aircncapi.User.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
}
