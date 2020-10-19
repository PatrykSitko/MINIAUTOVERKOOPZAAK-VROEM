package be.intecbrussel.patryksitko.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ForeignKey;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements ModelDefaults<String, Payment> {

    @Getter
    @Setter
    @NonNull
    @Column(name = "customerNumber", columnDefinition = "INT")
    @JoinColumn(name = "customerNumber", nullable = false, foreignKey = @ForeignKey(name = "customerNumber"))
    private Integer customerNumber;

    @Id
    @Getter
    @Setter
    @NonNull
    @Column(name = "checkNumber", nullable = false, length = 50, columnDefinition = "VARCHAR")
    private String checkNumber;

    @Getter
    @Setter
    @NonNull
    @Column(name = "paymentDate", nullable = false, columnDefinition = "DATE")
    private Date paymentDate;

    @Getter
    @Setter
    @NonNull
    @Column(name = "amount", nullable = false, precision = 10, scale = 2, columnDefinition = "DECIMAL")
    private Integer amount;

    @Override
    public String getPrimaryKey() {
        return this.getCheckNumber();
    }

    @Override
    public void update(Payment updated) {
        this.setCustomerNumber(updated.getCustomerNumber());
        this.setCheckNumber(updated.getCheckNumber());
        this.setPaymentDate(updated.getPaymentDate());
        this.setAmount(updated.getAmount());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((amount == null) ? 0 : amount.hashCode());
        result = prime * result + ((checkNumber == null) ? 0 : checkNumber.hashCode());
        result = prime * result + ((customerNumber == null) ? 0 : customerNumber.hashCode());
        result = prime * result + ((paymentDate == null) ? 0 : paymentDate.hashCode());
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
        Payment other = (Payment) obj;
        if (amount == null) {
            if (other.amount != null)
                return false;
        } else if (!amount.equals(other.amount))
            return false;
        if (checkNumber == null) {
            if (other.checkNumber != null)
                return false;
        } else if (!checkNumber.equals(other.checkNumber))
            return false;
        if (customerNumber == null) {
            if (other.customerNumber != null)
                return false;
        } else if (!customerNumber.equals(other.customerNumber))
            return false;
        if (paymentDate == null) {
            if (other.paymentDate != null)
                return false;
        } else if (!paymentDate.equals(other.paymentDate))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Payments [amount=" + amount + ", checkNumber=" + checkNumber + ", customerNumber=" + customerNumber
                + ", paymentDate=" + paymentDate + "]";
    }
}