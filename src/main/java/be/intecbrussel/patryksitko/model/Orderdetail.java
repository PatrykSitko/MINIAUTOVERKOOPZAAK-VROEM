package be.intecbrussel.patryksitko.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.*;

@Entity(name = "Orderdetails")
@NoArgsConstructor
@AllArgsConstructor
public class Orderdetail implements ModelDefaults<Integer, Orderdetail> {

    @Id
    @Getter
    @Setter
    @NonNull
    @Column(name = "orderNumber", nullable = false, columnDefinition = "INT")
    private Integer orderNumber;

    @Getter
    @Setter
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productCode", nullable = false, columnDefinition = "VARCHAR")
    private Product product;

    @Getter
    @Setter
    @NonNull
    @Column(name = "quantityOrdered", nullable = false, columnDefinition = "INT")
    private Integer quantityOrdered;

    @Getter
    @Setter
    @NonNull
    @Column(name = "priceEach", nullable = false, precision = 10, scale = 2, columnDefinition = "DECIMAL")
    private Integer priceEach;

    @Getter
    @Setter
    @NonNull
    @Column(name = "orderLineNumber", nullable = false, columnDefinition = "SMALLINT")
    private Integer orderLineNumber;

    @Override
    public Integer getPrimaryKey() {
        return this.getOrderNumber();
    }

    @Override
    public void update(Orderdetail updated) {
        this.setOrderLineNumber(updated.getOrderLineNumber());
        this.setProduct(updated.getProduct());
        this.setQuantityOrdered(updated.getQuantityOrdered());
        this.setPriceEach(updated.getPriceEach());
        this.setOrderLineNumber(updated.getOrderLineNumber());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orderLineNumber == null) ? 0 : orderLineNumber.hashCode());
        result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
        result = prime * result + ((priceEach == null) ? 0 : priceEach.hashCode());
        result = prime * result + ((product == null) ? 0 : product.hashCode());
        result = prime * result + ((quantityOrdered == null) ? 0 : quantityOrdered.hashCode());
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
        Orderdetail other = (Orderdetail) obj;
        if (orderLineNumber == null) {
            if (other.orderLineNumber != null)
                return false;
        } else if (!orderLineNumber.equals(other.orderLineNumber))
            return false;
        if (orderNumber == null) {
            if (other.orderNumber != null)
                return false;
        } else if (!orderNumber.equals(other.orderNumber))
            return false;
        if (priceEach == null) {
            if (other.priceEach != null)
                return false;
        } else if (!priceEach.equals(other.priceEach))
            return false;
        if (product == null) {
            if (other.product != null)
                return false;
        } else if (!product.equals(other.product))
            return false;
        if (quantityOrdered == null) {
            if (other.quantityOrdered != null)
                return false;
        } else if (!quantityOrdered.equals(other.quantityOrdered))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Orderdetail [orderLineNumber=" + orderLineNumber + ", orderNumber=" + orderNumber + ", priceEach="
                + priceEach + ", product=" + product + ", quantityOrdered=" + quantityOrdered + "]";
    }
}