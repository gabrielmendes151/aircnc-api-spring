package br.com.projeto.aircncapi.spot.dto;

import br.com.projeto.aircncapi.spot.predicate.SpotPredicate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class SpotFiltros {

    private String tech;
    private ObjectId userId;

    @JsonIgnore
    public SpotPredicate toPredicate() {
        return new SpotPredicate()
            .comTech(tech)
            .comUserId(userId);
    }
}
