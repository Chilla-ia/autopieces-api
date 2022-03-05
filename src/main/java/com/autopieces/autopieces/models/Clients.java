package com.autopieces.autopieces.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@DynamicUpdate
@Table(name = "clients")
@ApiModel("Client Entity")
public class Clients implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("clients_id")
    @Column(name = "clients_id")
    private long idClients;

    @Column(name = "clients_name")
    @ApiModelProperty("name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "commande",
            joinColumns = @JoinColumn(name = "clients_id", referencedColumnName = "clients_id"),
            inverseJoinColumns = @JoinColumn(name = "article_id", referencedColumnName = "article_id"))
    private Set<Article> articles = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "contrat_id")
    private Contrat contrat = new Contrat();

    public Clients() {
    }

    public Clients(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Clients [id=" + idClients + ", name=" + name + "]";
    }

    public long getIdClients() {
        return idClients;
    }

    public void setIdClients(long idClients) {
        this.idClients = idClients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

	public long getIdContrat() {
		// TODO Auto-generated method stub
		return this.contrat.getIdContrat();
	}

}
