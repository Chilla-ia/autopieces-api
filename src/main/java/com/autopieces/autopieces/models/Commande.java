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
    private Long idCommande;

    @Column(name = "commande_date")
    @ApiModelProperty("date")
    @CreatedDate
    private Date orderDate;

    @Column(name = "client_id")
    @ApiModelProperty("client")
    private Long clientId;

    @ApiModelProperty("article")
    @Column(name = "article_id")
    private Long articleId;

    public Commande() {
    }

    public Commande(Date orderDate, Long clientId, Long articleId) {
        this.orderDate = orderDate;
        this.clientId = clientId;
        this.articleId = articleId;
    }

    @Override
    public String toString() {
        return "Commande [id=" + idCommande + ", date=" + orderDate + ", clients=" + clientId + ", articles=" + articleId + "]";
    }

    public Long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDate() {
        return orderDate;
    }

    public void setDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Long getClients() {
        return clientId;
    }

    public void setClients(Long clientId) {
        this.clientId = clientId;
    }

    public Long getArticle() {
        return articleId;
    }

    public void setArticles(Long articleId) {
        this.articleId = articleId;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
