package br.com.projeto.aircncapi.booking.model;

import br.com.projeto.aircncapi.spot.model.Spot;
import br.com.projeto.aircncapi.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Booking {

    @Id
    private ObjectId id;
    private String date;
    private Boolean approved;
    @Reference
    private User user;
    @Reference
    private Spot spot;


}
