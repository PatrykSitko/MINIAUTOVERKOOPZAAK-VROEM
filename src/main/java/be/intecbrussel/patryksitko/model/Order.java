package be.intecbrussel.patryksitko.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity(name = "Orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order implements ModelDefaults<Integer, Order> {

    @Id
    @Getter
    @Setter
    @NonNull
    @Column(name = "orderNumber", nullable = false, columnDefinition = "INT")
    private Integer orderNumber;

    @Getter
    @Setter
    @NonNull
    @Column(name = "orderDate", nullable = false, columnDefinition = "DATE")
    private Date orderDate;

    @Getter
    @Setter
    @NonNull
    @Column(name = "requiredDate", nullable = false, columnDefinition = "DATE")
    private Date requiredDate;

    @Getter
    @Setter
    @Column(name = "shippedDate", nullable = true, columnDefinition = "DATE")
    private Date shippedDate;

    @Getter
    @Setter
    @NonNull
    @Column(name = "status", nullable = false, length = 15, columnDefinition = "VARCHAR")
    private String status;

    @Getter
    @Setter
    @Column(name = "comments", nullable = true, columnDefinition = "TEXT")
    private String comments;

    @Getter
    @Setter
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerNumber", nullable = false, columnDefinition = "INT", foreignKey = @ForeignKey(name = "customerNumber"))
    private Customer customer;

    @Override
    public Integer getPrimaryKey() {
        return this.getOrderNumber();
    }

    @Override
    public void update(Order updated) {
        this.setOrderNumber(updated.getOrderNumber());
        this.setOrderDate(updated.getOrderDate());
        this.setShippedDate(updated.getShippedDate());
        this.setStatus(updated.getStatus());
        this.setComments(updated.getComments());
        this.setCustomer(updated.getCustomer());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((comments == null) ? 0 : comments.hashCode());
        result = prime * result + ((customer == null) ? 0 : customer.hashCode());
        result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
        result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
        result = prime * result + ((requiredDate == null) ? 0 : requiredDate.hashCode());
        result = prime * result + ((shippedDate == null) ? 0 : shippedDate.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
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
        Order other = (Order) obj;
        if (comments == null) {
            if (other.comments != null)
                return false;
        } else if (!comments.equals(other.comments))
            return false;
        if (customer == null) {
            if (other.customer != null)
                return false;
        } else if (!customer.equals(other.customer))
            return false;
        if (orderDate == null) {
            if (other.orderDate != null)
                return false;
        } else if (!orderDate.equals(other.orderDate))
            return false;
        if (orderNumber == null) {
            if (other.orderNumber != null)
                return false;
        } else if (!orderNumber.equals(other.orderNumber))
            return false;
        if (requiredDate == null) {
            if (other.requiredDate != null)
                return false;
        } else if (!requiredDate.equals(other.requiredDate))
            return false;
        if (shippedDate == null) {
            if (other.shippedDate != null)
                return false;
        } else if (!shippedDate.equals(other.shippedDate))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Order [comments=" + comments + ", customer=" + customer + ", orderDate=" + orderDate + ", orderNumber="
                + orderNumber + ", requiredDate=" + requiredDate + ", shippedDate=" + shippedDate + ", status=" + status
                + "]";
    }

}