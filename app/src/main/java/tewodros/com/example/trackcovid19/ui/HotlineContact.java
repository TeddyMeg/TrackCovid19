package tewodros.com.example.trackcovid19.ui;

public class HotlineContact {
    private String countryName;
    private String phone;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public HotlineContact(String countryName, String phone) {
        this.countryName = countryName;
        this.phone = phone;
    }
}
