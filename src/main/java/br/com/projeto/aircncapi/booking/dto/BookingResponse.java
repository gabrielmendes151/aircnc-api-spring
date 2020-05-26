package br.com.projeto.aircncapi.booking.dto;

import br.com.projeto.aircncapi.booking.model.Booking;
import br.com.projeto.aircncapi.spot.dto.SpotResponse;
import br.com.projeto.aircncapi.user.dto.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingResponse {

    private String _id;
    private String date;
    private Boolean approved;
    private UserResponse user;
    private SpotResponse spot;

    public static BookingResponse of(Booking booking) {
        return BookingResponse.builder()
            ._id(booking.getId().toString())
            .date(booking.getDate())
            .approved(booking.getApproved())
            .user(UserResponse.of(booking.getUser()))
            .spot(SpotResponse.of(booking.getSpot()))
            .build();
    }
}
