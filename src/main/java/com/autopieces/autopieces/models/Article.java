package com.autopieces.autopieces.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private long idArticle;

    @Column(name = "article_name")
    @ApiModelProperty("name")
    private String name;

    @Column(name = "article_price")
    @ApiModelProperty("price")
    private Float price;

    @JsonIgnore
    @ManyToMany(mappedBy = "articles", fetch = FetchType.EAGER)
    private Set<Clients> clients = new HashSet<>();

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

    public long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(long idArticle) {
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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
