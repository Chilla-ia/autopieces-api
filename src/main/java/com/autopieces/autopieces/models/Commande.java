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
    private Date orderDate;

    @Column(name = "client_id")
    @JoinColumn(name = "client_id")
    @ApiModelProperty("client")
    @ManyToOne
    private Clients client;

    @JsonManagedReference
    @ApiModelProperty("article")
    @OneToMany(mappedBy = "commande")
    private List<Article> articles;

    public Commande() {
    }

    public Commande(Date orderDate, Clients client, List<Article> articles) {
        this.orderDate = orderDate;
        this.client = client;
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Commande [id=" + idCommande + ", date=" + orderDate + ", clients=" + client + ", articles=" + articles + "]";
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

    public Clients getClients() {
        return client;
    }

    public void setClients(Clients client) {
        this.client = client;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
