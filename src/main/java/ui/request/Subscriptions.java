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
public class Subscriptions {
    @Builder.Default private boolean marketingMail = true;
    @Builder.Default private boolean marketingSMS = true;
    @Builder.Default private boolean tailorMadeEmail = true;
    @Builder.Default private boolean tailorMadeSMS = true;
}
