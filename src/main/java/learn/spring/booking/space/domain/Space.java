package learn.spring.booking.space.domain;

public class Space {

    private String spaceId;
    private String spaceName;
    private String address;
    private double price;

    public Space(
            String spaceId,
            String spaceName,
            String address,
            double price
    ) {
        this.spaceId = spaceId;
        this.spaceName = spaceName;
        this.address = address;
        this.price = price;
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

    public double getPrice() {
        return price;
    }
}
