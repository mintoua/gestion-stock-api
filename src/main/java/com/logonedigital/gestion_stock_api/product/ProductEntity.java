package com.logonedigital.gestion_stock_api.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb-produit")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Integer id;
    @Column(name = "nom-produit",unique=true)
    private String name;
    @Column(name = "description-produit")
    private String description;
    @Column(name = "prix-produit")
    private Integer price;
    @Column(name = "qte-produit")
    private Integer quantity;
    @Column(name = "date-creation")
    @Temporal(TemporalType.DATE)
    private Date createdAt;
    @Column(name = "date-modification")
    @Temporal(TemporalType.DATE)
    private Date updatedAt;
    @Column(name = "supprimer")
    private Boolean isDeleted;

}
