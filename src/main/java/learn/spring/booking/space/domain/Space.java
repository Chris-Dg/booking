package learn.spring.booking.space.domain;

public class Space {

    private String spaceId;
    private String spaceName;
    private String address;

    public Space(String spaceId, String spaceName, String address) {
        this.spaceId = spaceId;
        this.spaceName = spaceName;
        this.address = address;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public String getAddress() {
        return address;
    }
}
