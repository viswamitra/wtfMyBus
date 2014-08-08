package day.hack.wtfMyBus;

/**
 * Created by abhiramk on 08/08/14.
 */
public class UserLocation {
    private String user_id;
    private String bus_number;
    private String latitude;
    private String longitude;
    private String client_created_at;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getBus_number() {
        return bus_number;
    }

    public void setBus_number(String bus_number) {
        this.bus_number = bus_number;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getClient_created_at() {
        return client_created_at;
    }

    public void setClient_created_at(String client_created_at) {
        this.client_created_at = client_created_at;
    }
}
