package br.com.projeto.aircncapi.User.dto;

import br.com.projeto.aircncapi.User.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserResponse {

    private String id;
    private String email;

    public static UserResponse of(User user) {
        return UserResponse.builder()
            .id(user.getId().toString())
            .email(user.getEmail())
            .build();
    }
}
