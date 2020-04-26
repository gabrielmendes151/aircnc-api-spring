package br.com.projeto.aircncapi.user.repository;

import br.com.projeto.aircncapi.user.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
}
