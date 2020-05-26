package br.com.projeto.aircncapi.booking.service;

import br.com.projeto.aircncapi.booking.dto.BookingRequest;
import br.com.projeto.aircncapi.booking.dto.BookingResponse;
import br.com.projeto.aircncapi.booking.model.Booking;
import br.com.projeto.aircncapi.booking.repository.BookingRepository;
import br.com.projeto.aircncapi.exception.ValidacaoException;
import br.com.projeto.aircncapi.spot.model.Spot;
import br.com.projeto.aircncapi.spot.repository.SpotRepository;
import br.com.projeto.aircncapi.user.model.User;
import br.com.projeto.aircncapi.user.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private final static ValidacaoException USER_NOT_FOUND = new ValidacaoException("User does not exist.");
    private final static ValidacaoException SPOT_NOT_FOUND = new ValidacaoException("Spot does not exist.");

    @Autowired
    private BookingRepository repository;
    @Autowired
    private SpotRepository spotRepository;
    @Autowired
    private UserRepository userRepository;

    public BookingResponse save(BookingRequest request, ObjectId spotId, ObjectId userId) {
        var user = userRepository.findById(userId).orElseThrow(() -> USER_NOT_FOUND);
        var spot = spotRepository.findById(spotId).orElseThrow(() -> SPOT_NOT_FOUND);
        return BookingResponse.of(repository.save(getBooking(request, user, spot)));

    }

    private Booking getBooking(BookingRequest request, User user, Spot spot) {
        return Booking.builder()
            .date(request.getDate())
            .user(user)
            .spot(spot)
            .build();
    }
}
