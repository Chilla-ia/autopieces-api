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
@Table(name = "clients")
@ApiModel("Client Entity")
public class Clients implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("clients_id")
    @Column(name = "clients_id")
    private Long idClients;

    @Column(name = "clients_name")
    @ApiModelProperty("name")
    private String name;

    @Column(name = "contrat_id")
    @JoinColumn(name = "contrat_id")
    @ApiModelProperty("contrat")
    @ManyToOne
    private Long idContrat;

    public Clients() {
    }

    public Clients(String name, Long idContrat) {
        this.name = name;
        this.idContrat = idContrat;
    }

    @Override
    public String toString() {
        return "Clients [id=" + idClients + ", name=" + name + ", contrat=" + idContrat + "]";
    }

    public Long getIdArticle() {
        return idClients;
    }

    public void setIdArticle(Long idClients) {
        this.idClients = idClients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getContrat() {
        return idContrat;
    }

    public void setContrat(Long idContrat) {
        this.idContrat = idContrat;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
