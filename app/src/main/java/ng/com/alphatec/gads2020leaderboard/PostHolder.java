package ng.com.alphatec.gads2020leaderboard;

import com.google.gson.annotations.SerializedName;

import retrofit2.http.Field;

public class PostHolder {
    @SerializedName("entry.1824927963")
    private String emailAddress; //entry.1824927963;

    @SerializedName("entry.1877115667")
    private String firstName; //entry.1877115667;


    @SerializedName("entry.2006916086")
    private String lastName; //entry.2006916086;

    @SerializedName("entry.642603327")
    private String gitHubLink; //entry.284483984;

    @SerializedName("entry.284483984")
    private String trackNumber; //entry.284483984;

    private int userId;
    private Integer id;
    private String title;
    private String body;

    public PostHolder() {
    }

    public PostHolder(String emailAddress, String firstName, String lastName, String trackNumber, String gitHubLink) {
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.trackNumber = trackNumber;
        this.gitHubLink = gitHubLink;
    }

    public PostHolder(int userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(String trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getBody() {
        return body;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGitHubLink() {
        return gitHubLink;
    }

    public void setGitHubLink(String gitHubLink) {
        this.gitHubLink = gitHubLink;
    }
}
