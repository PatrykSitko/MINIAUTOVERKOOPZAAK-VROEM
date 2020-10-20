package be.intecbrussel.patryksitko.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity(name = "Employees")
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements ModelDefaults<Integer, Employee> {

    @Id
    @Getter
    @Setter
    @NonNull
    @Column(name = "employeeNumber", nullable = false, columnDefinition = "INT")
    private Integer employeeNumber;

    @Getter
    @Setter
    @NonNull
    @Column(name = "lastName", nullable = false, length = 50, columnDefinition = "VARCHAR")
    private String lastName;

    @Getter
    @Setter
    @NonNull
    @Column(name = "firstName", nullable = false, length = 50, columnDefinition = "VARCHAR")
    private String firstName;

    @Getter
    @Setter
    @NonNull
    @Column(name = "extension", nullable = false, length = 10, columnDefinition = "VARCHAR")
    private String extension;

    @Getter
    @Setter
    @NonNull
    @Column(name = "email", nullable = false, length = 100, columnDefinition = "VARCHAR")
    private String email;

    @Getter
    @Setter
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "officeCode", nullable = false, columnDefinition = "VARCHAR", foreignKey = @ForeignKey(name = "officeCode"))
    private Office office;

    @Getter
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reportsTo", nullable = true, columnDefinition = "INT", foreignKey = @ForeignKey(name = "employeeNumber"))
    private Employee reportsTo;

    @Getter
    @Setter
    @NonNull
    @Column(name = "jobTitle", nullable = false, length = 50, columnDefinition = "VARCHAR")
    private Integer jobTitle;

    @Override
    public Integer getPrimaryKey() {
        return this.getEmployeeNumber();
    }

    @Override
    public void update(Employee updated) {
        this.setEmployeeNumber(updated.getEmployeeNumber());
        this.setLastName(updated.getLastName());
        this.setFirstName(updated.getFirstName());
        this.setExtension(updated.getExtension());
        this.setEmail(updated.getEmail());
        this.setOffice(updated.getOffice());
        this.setReportsTo(updated.getReportsTo());
        this.setJobTitle(updated.getJobTitle());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((employeeNumber == null) ? 0 : employeeNumber.hashCode());
        result = prime * result + ((extension == null) ? 0 : extension.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((jobTitle == null) ? 0 : jobTitle.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((office == null) ? 0 : office.hashCode());
        result = prime * result + ((reportsTo == null) ? 0 : reportsTo.hashCode());
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
        Employee other = (Employee) obj;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (employeeNumber == null) {
            if (other.employeeNumber != null)
                return false;
        } else if (!employeeNumber.equals(other.employeeNumber))
            return false;
        if (extension == null) {
            if (other.extension != null)
                return false;
        } else if (!extension.equals(other.extension))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (jobTitle == null) {
            if (other.jobTitle != null)
                return false;
        } else if (!jobTitle.equals(other.jobTitle))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (office == null) {
            if (other.office != null)
                return false;
        } else if (!office.equals(other.office))
            return false;
        if (reportsTo == null) {
            if (other.reportsTo != null)
                return false;
        } else if (!reportsTo.equals(other.reportsTo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Employee [email=" + email + ", employeeNumber=" + employeeNumber + ", extension=" + extension
                + ", firstName=" + firstName + ", jobTitle=" + jobTitle + ", lastName=" + lastName + ", office="
                + office + ", reportsTo=" + reportsTo + "]";
    }
}