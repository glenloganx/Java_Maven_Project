package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter
public class SwitcherViews {
    @JsonProperty
    private String viewType;
    @JsonProperty
    private boolean enabled;
    @JsonProperty
    private String _id;
}
