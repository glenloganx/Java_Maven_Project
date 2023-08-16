package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter @Setter @ToString
public class Prefs {
    @JsonProperty
    private String permissionLevel;
    @JsonProperty
    private boolean hideVotes;
    @JsonProperty
    private String voting;
    @JsonProperty
    private String comments;
    @JsonProperty
    private String invitations;
    @JsonProperty
    private boolean selfJoin;
    @JsonProperty
    private boolean cardCovers;
    @JsonProperty
    private boolean isTemplate;
    @JsonProperty
    private String cardAging;
    @JsonProperty
    private boolean calendarFeedEnabled;
    @JsonProperty
    private List<Object> hiddenPluginBoardButtons;
    @JsonProperty
    private List<SwitcherViews> switcherViews;
    @JsonProperty
    private String background;
    @JsonProperty
    private String backgroundColor;
    @JsonProperty
    private Object backgroundImage;
    @JsonProperty
    private Object backgroundImageScaled;
    @JsonProperty
    private boolean backgroundTile;
    @JsonProperty
    private String backgroundBrightness;
    @JsonProperty
    private String backgroundBottomColor;
    @JsonProperty
    private String backgroundTopColor;
    @JsonProperty
    private boolean canBePublic;
    @JsonProperty
    private boolean canBeEnterprise;
    @JsonProperty
    private boolean canBeOrg;
    @JsonProperty
    private boolean canBePrivate;
    @JsonProperty
    private boolean canInvite;
}
