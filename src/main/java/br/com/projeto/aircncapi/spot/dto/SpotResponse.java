package br.com.projeto.aircncapi.spot.dto;

import br.com.projeto.aircncapi.spot.model.Spot;
import br.com.projeto.aircncapi.user.dto.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpotResponse {

    private String _id;
    private String company;
    private BigDecimal price;
    private List<String> techs;
    private String thumbnail;
    private UserResponse user;
    private String thumbnail_uri;

    public static SpotResponse of(Spot spot) {
        var response = new SpotResponse();
        BeanUtils.copyProperties(spot, response);
        response.set_id(spot.getId().toString());
        response.setUser(UserResponse.of(spot.getUser()));
        response.setThumbnail_uri(getThumbnailUri(spot.getThumbnail()));
        return response;
    }

    public static String getThumbnailUri(String thumbnail) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/files/")
            .path(thumbnail)
            .toUriString();
    }
}
