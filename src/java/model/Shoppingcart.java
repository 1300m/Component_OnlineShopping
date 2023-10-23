/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jiapat
 */
@Entity
@Table(name = "SHOPPINGCART")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shoppingcart.findAll", query = "SELECT s FROM Shoppingcart s"),
    @NamedQuery(name = "Shoppingcart.findByCartId", query = "SELECT s FROM Shoppingcart s WHERE s.id = :id"),
    @NamedQuery(name = "Shoppingcart.findByQuantity", query = "SELECT s FROM Shoppingcart s WHERE s.quantity = :quantity")})
public class Shoppingcart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CART_ID")
    private Integer id;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @JoinColumn(name = "MOVIE_ID", referencedColumnName = "ID")
    @OneToOne
    private Products productsFK;

    public Shoppingcart() {
    }

    public Shoppingcart(Integer id) {
        this.id = id;
    }
    
    public Shoppingcart(Integer id, Integer quantity, Products products) {
        this.id = id;
        this.quantity = quantity;
        this.productsFK = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer cartId) {
        this.id = cartId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Products getProducts() {
        return productsFK;
    }

    public void setProducts(Products products) {
        this.productsFK = products;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shoppingcart)) {
            return false;
        }
        Shoppingcart other = (Shoppingcart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Shoppingcart[ shoppingcartPK=" + id + " ]";
    }
    
}