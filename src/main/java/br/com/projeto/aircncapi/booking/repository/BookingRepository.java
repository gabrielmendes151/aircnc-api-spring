package br.com.projeto.aircncapi.booking.repository;

import br.com.projeto.aircncapi.booking.model.Booking;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, ObjectId> {
}
