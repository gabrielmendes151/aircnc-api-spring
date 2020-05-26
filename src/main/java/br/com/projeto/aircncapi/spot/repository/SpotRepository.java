package br.com.projeto.aircncapi.spot.repository;

import br.com.projeto.aircncapi.spot.model.Spot;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface SpotRepository extends MongoRepository<Spot, ObjectId>, QuerydslPredicateExecutor<Spot> {
}
