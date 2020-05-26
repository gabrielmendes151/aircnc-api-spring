package br.com.projeto.aircncapi.spot.predicate;

import br.com.projeto.aircncapi.utils.PredicateBase;
import lombok.Data;
import org.bson.types.ObjectId;

import java.util.Objects;

import static br.com.projeto.aircncapi.spot.model.QSpot.spot;

@Data
public class SpotPredicate extends PredicateBase {

    public SpotPredicate comTech(String tech) {
        if (Objects.nonNull(tech)) {
            builder.and(spot.techs.any().eq(tech));
        }
        return this;
    }

    public SpotPredicate comUserId(ObjectId userId) {
        if (Objects.nonNull(userId)) {
            builder.and(spot.user.id.eq(userId));
        }
        return this;
    }
}
