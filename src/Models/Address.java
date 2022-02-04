package Models;

public class Address implements Comparable<Address> {
    String street;
    Integer number;
    String city;
    String state;

    public Address(String street, Integer number, String city, String state) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" + street + "," + number + "," + city + "}";
    }

    @Override
    public int compareTo(Address address) {
        return this.getState().compareTo(address.getState());
    }
}
