package config;

public class UserBuilder {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String address;
    private String city;
    private String zipcode;
    private String state;
    private String mobile;

    public UserBuilder(String email, String firstName, String lastName, String password, String address, String city, String zipcode, String state, String mobile) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.address = address;
        this.city = city;
        this.zipcode = zipcode;
        this.state = state;
        this.mobile = mobile;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getState() {
        return state;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }
}