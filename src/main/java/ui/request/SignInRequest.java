package ui.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class SignInRequest {
    private String brandId;
    @Builder.Default private String department = "";
    @Builder.Default private String device = "";
    private String login;
    private String password;


    public static SignInRequest of(SignUpRequest signUpRequest) {
        return SignInRequest.builder()
                .brandId(signUpRequest.getBrandId())
                .login(signUpRequest.getEmail())
                .password(signUpRequest.getPassword())
                .build();
    }
}
