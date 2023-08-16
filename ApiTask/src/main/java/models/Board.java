package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString @Getter @Setter @NoArgsConstructor
public class Board {
    @JsonProperty
    private String id;
    @JsonProperty
    private String name;
    @JsonProperty
    private String desc;
    @JsonProperty
    private Object descData;
    @JsonProperty
    private boolean closed;
    @JsonProperty
    private String idOrganization;
    @JsonProperty
    private Object idEnterprise;
    @JsonProperty
    private boolean pinned;
    @JsonProperty
    private String url;
    @JsonProperty
    private String shortUrl;
    @JsonProperty
    private Prefs prefs;
    @JsonProperty
    private LabelNames labelNames;
    @JsonProperty
    private Limits limits;
}
