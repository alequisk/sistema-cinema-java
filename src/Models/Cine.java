package Models;

public class Cine implements Comparable<Cine> {
    String name;
    Address address;

    public Cine(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object cine) {
        return cine instanceof Cine && ((Cine) cine).getName().equals(name) && ((Cine) cine).getAddress().equals(address);
    }

    @Override
    public String toString() {
        return "Cine{" + name + "," + address + "}";
    }

    @Override
    public int compareTo(Cine cine) {
        return this.name.compareTo(cine.getName());
    }
}
