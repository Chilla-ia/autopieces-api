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
@Table(name = "contrat")
@ApiModel("Contrat Entity")
public class Contrat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("contrat_id")
    @Column(name = "contrat_id")
    private Long idContrat;

    @Column(name = "contrat_marge")
    @ApiModelProperty("marge")
    private int marge;

    public Contrat() {
    }

    public Contrat(int marge) {
        this.marge = marge;
    }

    @Override
    public String toString() {
        return "Contrat [id=" + idContrat + ", marge=" + marge + "]";
    }

    public Long getIdContrat() {
        return idContrat;
    }

    public void setIdArticle(Long idContrat) {
        this.idContrat = idContrat;
    }

    public int getMarge() {
        return marge;
    }

    public void setMarge(int marge) {
        this.marge = marge;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
