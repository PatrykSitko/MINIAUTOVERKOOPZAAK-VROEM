package be.intecbrussel.patryksitko.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity(name = "Customers")
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements ModelDefaults<Integer, Customer> {

    @Id
    @Getter
    @Setter
    @NonNull
    @Column(name = "customerNumber", nullable = false, columnDefinition = "INT")
    private Integer customerNumber;

    @Getter
    @Setter
    @NonNull
    @Column(name = "customerName", nullable = false, length = 50, columnDefinition = "VARCHAR")
    private String customerName;

    @Getter
    @Setter
    @NonNull
    @Column(name = "contactLastName", nullable = false, length = 50, columnDefinition = "VARCHAR")
    private String contactLastName;

    @Getter
    @Setter
    @NonNull
    @Column(name = "contactFirstName", nullable = false, length = 50, columnDefinition = "VARCHAR")
    private String contactFirstName;

    @Getter
    @Setter
    @NonNull
    @Column(name = "phone", nullable = false, length = 50, columnDefinition = "VARCHAR")
    private String phone;

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
    @NonNull
    @Column(name = "city", nullable = false, length = 50, columnDefinition = "VARCHAR")
    private String city;

    @Getter
    @Setter
    @Column(name = "state", nullable = true, length = 50, columnDefinition = "VARCHAR")
    private String state;

    @Getter
    @Setter
    @Column(name = "postalCode", nullable = true, length = 15, columnDefinition = "VARCHAR")
    private String postalCode;

    @Getter
    @Setter
    @NonNull
    @Column(name = "country", nullable = false, length = 50, columnDefinition = "VARCHAR")
    private String country;

    @Getter
    @Setter
    @Column(name = "salesRepEmployeeNumber", nullable = true, columnDefinition = "INT")
    private Integer salesRepEmployeeNumber;

    @Getter
    @Setter
    @Column(name = "creditLimit", nullable = true, precision = 10, scale = 2, columnDefinition = "DECIMAL")
    private Double creditLimit;

    @Override
    public Integer getPrimaryKey() {
        return this.getCustomerNumber();
    }

    @Override
    public void update(Customer updated) {
        this.setCustomerNumber(updated.getCustomerNumber());
        this.setCustomerName(updated.getCustomerName());
        this.setContactLastName(updated.getContactLastName());
        this.setContactFirstName(updated.getContactFirstName());
        this.setPhone(updated.getPhone());
        this.setAddressLine1(updated.getAddressLine1());
        this.setAddressLine2(updated.getAddressLine2());
        this.setCity(updated.getCity());
        this.setState(updated.getState());
        this.setPostalCode(updated.getPostalCode());
        this.setCountry(updated.getCountry());
        this.setSalesRepEmployeeNumber(updated.getSalesRepEmployeeNumber());
        this.setCreditLimit(updated.getCreditLimit());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((addressLine1 == null) ? 0 : addressLine1.hashCode());
        result = prime * result + ((addressLine2 == null) ? 0 : addressLine2.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((contactFirstName == null) ? 0 : contactFirstName.hashCode());
        result = prime * result + ((contactLastName == null) ? 0 : contactLastName.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((creditLimit == null) ? 0 : creditLimit.hashCode());
        result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
        result = prime * result + ((customerNumber == null) ? 0 : customerNumber.hashCode());
        result = prime * result + ((phone == null) ? 0 : phone.hashCode());
        result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
        result = prime * result + ((salesRepEmployeeNumber == null) ? 0 : salesRepEmployeeNumber.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
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
        Customer other = (Customer) obj;
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
        if (contactFirstName == null) {
            if (other.contactFirstName != null)
                return false;
        } else if (!contactFirstName.equals(other.contactFirstName))
            return false;
        if (contactLastName == null) {
            if (other.contactLastName != null)
                return false;
        } else if (!contactLastName.equals(other.contactLastName))
            return false;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (creditLimit == null) {
            if (other.creditLimit != null)
                return false;
        } else if (!creditLimit.equals(other.creditLimit))
            return false;
        if (customerName == null) {
            if (other.customerName != null)
                return false;
        } else if (!customerName.equals(other.customerName))
            return false;
        if (customerNumber == null) {
            if (other.customerNumber != null)
                return false;
        } else if (!customerNumber.equals(other.customerNumber))
            return false;
        if (phone == null) {
            if (other.phone != null)
                return false;
        } else if (!phone.equals(other.phone))
            return false;
        if (postalCode == null) {
            if (other.postalCode != null)
                return false;
        } else if (!postalCode.equals(other.postalCode))
            return false;
        if (salesRepEmployeeNumber == null) {
            if (other.salesRepEmployeeNumber != null)
                return false;
        } else if (!salesRepEmployeeNumber.equals(other.salesRepEmployeeNumber))
            return false;
        if (state == null) {
            if (other.state != null)
                return false;
        } else if (!state.equals(other.state))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Customer [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city
                + ", contactFirstName=" + contactFirstName + ", contactLastName=" + contactLastName + ", country="
                + country + ", creditLimit=" + creditLimit + ", customerName=" + customerName + ", customerNumber="
                + customerNumber + ", phone=" + phone + ", postalCode=" + postalCode + ", salesRepEmployeeNumber="
                + salesRepEmployeeNumber + ", state=" + state + "]";
    }
}