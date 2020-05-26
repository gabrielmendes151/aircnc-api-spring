package br.com.projeto.aircncapi.spot.model;


import br.com.projeto.aircncapi.spot.dto.SpotRequest;
import br.com.projeto.aircncapi.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Transient;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Spot {

    @Id
    private ObjectId id;
    private List<String> techs;
    private String thumbnail;
    private String company;
    private BigDecimal price;
    @Reference
    private User user;
    @Transient
    private String thumbnail_url;

    public static Spot of (SpotRequest request){
        var spot = new Spot();
        BeanUtils.copyProperties(request, spot);
        spot.setTechs(Stream.of(request.getTechs().split(","))
            .map(String::trim)
            .collect(Collectors.toList()));
        return spot;
    }
}
