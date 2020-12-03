package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "T_Articles" )
public class Article {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int    idArticle;

    private String description;
    private String brand;
    private Double price;

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle( int idArticle ) {
        this.idArticle = idArticle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand( String brand ) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice( Double price ) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Article [idArticle=" + idArticle + ", description=" + description + ", brand=" + brand + ", price="
                + price + "]";
    }

}
