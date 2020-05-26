package br.com.projeto.aircncapi.user.dto;

import br.com.projeto.aircncapi.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserResponse {

    private String _id;
    private String email;

    public static UserResponse of(User user) {
        return UserResponse.builder()
            ._id(user.getId().toString())
            .email(user.getEmail())
            .build();
    }
}
