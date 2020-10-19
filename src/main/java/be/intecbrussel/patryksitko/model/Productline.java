package be.intecbrussel.patryksitko.model;

import java.io.File;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Productline implements ModelDefaults<String, Productline> {

    @Id
    @Getter
    @Setter
    @NonNull
    @Column(name = "productLine", nullable = false, length = 50, columnDefinition = "VARCHAR")
    private String productLine;

    @Getter
    @Setter
    @NonNull
    @Column(name = "image", nullable = false, columnDefinition = "MEDIUMBLOB")
    private File image;

    @Getter
    @Setter
    @NonNull
    @Column(name = "textDescription", nullable = false, length = 4000, columnDefinition = "VARCHAR")
    private String textDescription;

    @Getter
    @Setter
    @NonNull
    @Column(name = "htmlDescription", nullable = false, columnDefinition = "MEDIUMTEXT")
    private String htmlDescription;

    @Override
    public String getPrimaryKey() {
        return this.getProductLine();
    }

    @Override
    public void update(Productline updatedProductline) {
        this.setProductLine(updatedProductline.getProductLine());
        this.setImage(updatedProductline.getImage());
        this.setTextDescription(updatedProductline.getTextDescription());
        this.setHtmlDescription(updatedProductline.getHtmlDescription());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((htmlDescription == null) ? 0 : htmlDescription.hashCode());
        result = prime * result + ((image == null) ? 0 : image.hashCode());
        result = prime * result + ((productLine == null) ? 0 : productLine.hashCode());
        result = prime * result + ((textDescription == null) ? 0 : textDescription.hashCode());
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
        Productline other = (Productline) obj;
        if (htmlDescription == null) {
            if (other.htmlDescription != null)
                return false;
        } else if (!htmlDescription.equals(other.htmlDescription))
            return false;
        if (image == null) {
            if (other.image != null)
                return false;
        } else if (!image.equals(other.image))
            return false;
        if (productLine == null) {
            if (other.productLine != null)
                return false;
        } else if (!productLine.equals(other.productLine))
            return false;
        if (textDescription == null) {
            if (other.textDescription != null)
                return false;
        } else if (!textDescription.equals(other.textDescription))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Productlines [htmlDescription=" + htmlDescription + ", image=" + image + ", productLine=" + productLine
                + ", textDescription=" + textDescription + "]";
    }
}