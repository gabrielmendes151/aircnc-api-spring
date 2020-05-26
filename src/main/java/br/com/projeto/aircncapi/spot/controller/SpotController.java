package br.com.projeto.aircncapi.spot.controller;

import br.com.projeto.aircncapi.booking.dto.BookingRequest;
import br.com.projeto.aircncapi.booking.dto.BookingResponse;
import br.com.projeto.aircncapi.booking.service.BookingService;
import br.com.projeto.aircncapi.spot.dto.SpotFiltros;
import br.com.projeto.aircncapi.spot.dto.SpotRequest;
import br.com.projeto.aircncapi.spot.dto.SpotResponse;
import br.com.projeto.aircncapi.spot.service.SpotService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/spots")
@CrossOrigin
public class SpotController {

    @Autowired
    private SpotService service;
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public SpotResponse save(@RequestPart SpotRequest request, MultipartFile thumbnail,
                             @RequestHeader("user_id") ObjectId userId) {
        return service.save(request, thumbnail, userId);
    }

    @GetMapping
    public List<SpotResponse> getAllByFiltros(SpotFiltros filtros) {
        return service.getAllByFiltros(filtros);
    }

    @PostMapping("{spot_id}/bookings")
    public BookingResponse saveBooking(@RequestBody BookingRequest request, @PathVariable("spot_id") ObjectId spotId,
                                       @RequestHeader("user_id") ObjectId userId) {
        return bookingService.save(request, spotId, userId);
    }
}
