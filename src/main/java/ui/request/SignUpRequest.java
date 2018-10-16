package ui.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class SignUpRequest {
    @Builder.Default
    private String address = "someValue";
    @Builder.Default
    private String affiliateId = "someValue";
    @Builder.Default
    private String birthDate = "1989-02-19";
    @Builder.Default
    private String brandId = "redbox";
    @Builder.Default
    private String btag = "string";
    @Singular
    List<Object> campaigns = new ArrayList<>();
    @Builder.Default
    private String city = "Kyiv";
    @Builder.Default
    private String country = "UA";
    @Builder.Default
    private String currency = "EUR";
    private String email;
    @Builder.Default
    private String firstName = "firstName";
    @Builder.Default
    private String gender = "UNDEFINED";
    @Builder.Default
    private String identifier = "string";
    @Builder.Default
    private String intendedAmountToSpend = "";
    @Builder.Default
    private String languageCode = "an";
    @Builder.Default
    private String lastName = "lastName";
    @Builder.Default
    private String login = "LoginName";
    @Builder.Default
    private String password = "Itis_realPassoword16";
    @Builder.Default
    private String phone = "637136364";
    @Builder.Default
    private String phone2 = "637136365";
    @Builder.Default
    private String phoneCode = "380";
    @Builder.Default
    private String phoneCode2 = "380";
    @Builder.Default
    private String postCode = "02232";
    @Builder.Default
    private String state = "active";
    @Builder.Default
    private Subscriptions subscriptions = new Subscriptions();
}
