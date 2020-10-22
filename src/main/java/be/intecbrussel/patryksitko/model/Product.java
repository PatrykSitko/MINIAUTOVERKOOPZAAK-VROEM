package be.intecbrussel.patryksitko.model;

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

@Entity(name = "Products")
@NoArgsConstructor
@AllArgsConstructor
public class Product implements ModelDefaults<String, Product> {

    @Id
    @Getter
    @Setter
    @NonNull
    @Column(name = "productCode", nullable = false, length = 15, columnDefinition = "VARCHAR")
    private String productCode;

    @Getter
    @Setter
    @NonNull
    @Column(name = "productName", nullable = false, length = 70, columnDefinition = "VARCHAR")
    private String productName;

    @Getter
    @Setter
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productLine", nullable = false, columnDefinition = "VARCHAR", foreignKey = @ForeignKey(name = "productLine"))
    private Productline productline;

    @Getter
    @Setter
    @NonNull
    @Column(name = "productScale", nullable = false, length = 10, columnDefinition = "VARCHAR")
    private String productScale;

    @Getter
    @Setter
    @NonNull
    @Column(name = "productVendor", nullable = false, length = 50, columnDefinition = "VARCHAR")
    private String productVendor;

    @Getter
    @Setter
    @NonNull
    @Column(name = "productDescription", nullable = false, columnDefinition = "TEXT")
    private String productDescription;

    @Getter
    @Setter
    @NonNull
    @Column(name = "quantityInStock", nullable = false, columnDefinition = "SMALLINT")
    private Integer quantityInStock;

    @Getter
    @Setter
    @NonNull
    @Column(name = "buyPrice", nullable = false, precision = 10, scale = 2, columnDefinition = "DECIMAL")
    private String buyPrice;

    @Getter
    @Setter
    @NonNull
    @Column(name = "MSRP", nullable = false, precision = 10, scale = 2, columnDefinition = "DECIMAL")
    private String MSRP;

    @Override
    public String getPrimaryKey() {
        return this.getProductCode();
    }

    @Override
    public void update(Product updated) {
        this.setProductCode(updated.getProductCode());
        this.setProductName(updated.getProductName());
        this.setProductline(updated.getProductline());
        this.setProductScale(updated.getProductScale());
        this.setProductVendor(updated.getProductVendor());
        this.setProductDescription(updated.getProductDescription());
        this.setQuantityInStock(updated.getQuantityInStock());
        this.setBuyPrice(updated.getBuyPrice());
        this.setMSRP(updated.getMSRP());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((MSRP == null) ? 0 : MSRP.hashCode());
        result = prime * result + ((buyPrice == null) ? 0 : buyPrice.hashCode());
        result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
        result = prime * result + ((productDescription == null) ? 0 : productDescription.hashCode());
        result = prime * result + ((productName == null) ? 0 : productName.hashCode());
        result = prime * result + ((productScale == null) ? 0 : productScale.hashCode());
        result = prime * result + ((productVendor == null) ? 0 : productVendor.hashCode());
        result = prime * result + ((productline == null) ? 0 : productline.hashCode());
        result = prime * result + ((quantityInStock == null) ? 0 : quantityInStock.hashCode());
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
        Product other = (Product) obj;
        if (MSRP == null) {
            if (other.MSRP != null)
                return false;
        } else if (!MSRP.equals(other.MSRP))
            return false;
        if (buyPrice == null) {
            if (other.buyPrice != null)
                return false;
        } else if (!buyPrice.equals(other.buyPrice))
            return false;
        if (productCode == null) {
            if (other.productCode != null)
                return false;
        } else if (!productCode.equals(other.productCode))
            return false;
        if (productDescription == null) {
            if (other.productDescription != null)
                return false;
        } else if (!productDescription.equals(other.productDescription))
            return false;
        if (productName == null) {
            if (other.productName != null)
                return false;
        } else if (!productName.equals(other.productName))
            return false;
        if (productScale == null) {
            if (other.productScale != null)
                return false;
        } else if (!productScale.equals(other.productScale))
            return false;
        if (productVendor == null) {
            if (other.productVendor != null)
                return false;
        } else if (!productVendor.equals(other.productVendor))
            return false;
        if (productline == null) {
            if (other.productline != null)
                return false;
        } else if (!productline.equals(other.productline))
            return false;
        if (quantityInStock == null) {
            if (other.quantityInStock != null)
                return false;
        } else if (!quantityInStock.equals(other.quantityInStock))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product [MSRP=" + MSRP + ", buyPrice=" + buyPrice + ", productCode=" + productCode
                + ", productDescription=" + productDescription + ", productName=" + productName + ", productScale="
                + productScale + ", productVendor=" + productVendor + ", productline=" + productline
                + ", quantityInStock=" + quantityInStock + "]";
    }
}