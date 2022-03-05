package com.autopieces.autopieces.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.annotation.CreatedDate;

@Data
@Entity
@DynamicUpdate
@Table(name = "commande")
@ApiModel("Commande Entity")
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("commande_id")
    @Column(name = "commande_id")
    private long idCommande;

    @Column(name = "commande_date")
    @ApiModelProperty("date")
    @CreatedDate
    private Date orderDate;

    @Column(name = "client_id")
    @ApiModelProperty("client")
    private long clientId;

    @ApiModelProperty("article")
    @Column(name = "article_id")
    private long articleId;

    public Commande() {
    }

    public Commande(Date orderDate, long clientId, long articleId) {
        this.orderDate = orderDate;
        this.clientId = clientId;
        this.articleId = articleId;
    }

    @Override
    public String toString() {
        return "Commande [id=" + idCommande + ", date=" + orderDate + ", clients=" + clientId + ", articles=" + articleId + "]";
    }

    public long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(long idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDate() {
        return orderDate;
    }

    public void setDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public long getClients() {
        return clientId;
    }

    public void setClients(long clientId) {
        this.clientId = clientId;
    }

    public long getArticle() {
        return articleId;
    }

    public void setArticles(long articleId) {
        this.articleId = articleId;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
