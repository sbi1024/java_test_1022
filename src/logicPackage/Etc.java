package logicPackage;

import java.util.Objects;

public class Etc {
    private String Country;
    private String City;
    private String name;

    private Etc() {}

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etc etc = (Etc) o;
        return Country.equals(etc.Country) && City.equals(etc.City) && name.equals(etc.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Country, City, name);
    }

    @Override
    public String toString() {
        return "Etc{" +
                "Country='" + Country + '\'' +
                ", City='" + City + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static Etc createEtc(){
        return new Etc();
    }
}
