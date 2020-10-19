package be.intecbrussel.patryksitko.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity(name = "Offices")
@NoArgsConstructor
@AllArgsConstructor
public class Office implements ModelDefaults<String, Office> {

    @Id
    @Getter
    @Setter
    @NonNull
    @Column(name = "officeCode", nullable = false, length = 10, columnDefinition = "VARCHAR")
    private String officeCode;

    @Getter
    @Setter
    @NonNull
    @Column(name = "city", nullable = false, length = 50, columnDefinition = "VARCHAR")
    private String city;

    @Getter
    @Setter
    @NonNull
    @Column(name = "addressLine1", nullable = false, length = 50, columnDefinition = "VARCHAR")
    private String addressLine1;

    @Getter
    @Setter
    @Column(name = "addressLine2", nullable = true, length = 50, columnDefinition = "VARCHAR")
    private String addressLine2;

    @Getter
    @Setter
    @Column(name = "state", nullable = true, length = 50, columnDefinition = "VARCHAR")
    private String state;

    @Getter
    @Setter
    @NonNull
    @Column(name = "country", nullable = false, length = 50, columnDefinition = "VARCHAR")
    private String country;

    @Getter
    @Setter
    @NonNull
    @Column(name = "postalCode", nullable = false, length = 15, columnDefinition = "VARCHAR")
    private String postalCode;

    @Getter
    @Setter
    @NonNull
    @Column(name = "territory", nullable = false, length = 10, columnDefinition = "VARCHAR")
    private String territory;

    @Override
    public String getPrimaryKey() {
        return this.getOfficeCode();
    }

    @Override
    public void update(Office updated) {
        this.setOfficeCode(updated.getOfficeCode());
        this.setCity(updated.getCity());
        this.setAddressLine1(updated.getAddressLine1());
        this.setAddressLine2(updated.getAddressLine2());
        this.setState(updated.getState());
        this.setCountry(updated.getCountry());
        this.setPostalCode(updated.getPostalCode());
        this.setTerritory(updated.getTerritory());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((addressLine1 == null) ? 0 : addressLine1.hashCode());
        result = prime * result + ((addressLine2 == null) ? 0 : addressLine2.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((officeCode == null) ? 0 : officeCode.hashCode());
        result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + ((territory == null) ? 0 : territory.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Office other = (Office) obj;
        if (addressLine1 == null) {
            if (other.addressLine1 != null)
                return false;
        } else if (!addressLine1.equals(other.addressLine1))
            return false;
        if (addressLine2 == null) {
            if (other.addressLine2 != null)
                return false;
        } else if (!addressLine2.equals(other.addressLine2))
            return false;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (officeCode == null) {
            if (other.officeCode != null)
                return false;
        } else if (!officeCode.equals(other.officeCode))
            return false;
        if (postalCode == null) {
            if (other.postalCode != null)
                return false;
        } else if (!postalCode.equals(other.postalCode))
            return false;
        if (state == null) {
            if (other.state != null)
                return false;
        } else if (!state.equals(other.state))
            return false;
        if (territory == null) {
            if (other.territory != null)
                return false;
        } else if (!territory.equals(other.territory))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Offices [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city
                + ", country=" + country + ", officeCode=" + officeCode + ", postalCode=" + postalCode + ", state="
                + state + ", territory=" + territory + "]";
    }
}