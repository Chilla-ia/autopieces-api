package com.autopieces.autopieces.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@DynamicUpdate
@Table(name = "article")
@ApiModel("Article Entity")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("article_id")
    @Column(name = "article_id")
    private Long idArticle;

    @Column(name = "article_name")
    @ApiModelProperty("name")
    private String name;

    @Column(name = "article_price")
    @ApiModelProperty("price")
    private Float price;

    @Column(name = "marge")
    @ApiModelProperty("marge")
    private Float marge;

    public Article() {
    }

    public Article(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Article [id=" + idArticle + ", name=" + name + ", price=" + price + "]";
    }

    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getPriceWithMarge() {
        return price + (price * marge / 100);
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
