/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pablo Rocha
 */
@Entity
@Table(name = "cardapio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cardapio.findAll", query = "SELECT c FROM Cardapio c"),
    @NamedQuery(name = "Cardapio.findByIdCardapio", query = "SELECT c FROM Cardapio c WHERE c.idCardapio = :idCardapio"),
    @NamedQuery(name = "Cardapio.findByProduto", query = "SELECT c FROM Cardapio c WHERE c.produto = :produto"),
    @NamedQuery(name = "Cardapio.findByQuantidade", query = "SELECT c FROM Cardapio c WHERE c.quantidade = :quantidade"),
    @NamedQuery(name = "Cardapio.findByValor", query = "SELECT c FROM Cardapio c WHERE c.valor = :valor")})
public class Cardapio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCardapio")
    private Integer idCardapio;
    @Column(name = "produto")
    private String produto;
    @Column(name = "quantidade")
    private Integer quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Float valor;

    public Cardapio() {
    }

    public Cardapio(Integer idCardapio) {
        this.idCardapio = idCardapio;
    }

    public Integer getIdCardapio() {
        return idCardapio;
    }

    public void setIdCardapio(Integer idCardapio) {
        this.idCardapio = idCardapio;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCardapio != null ? idCardapio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cardapio)) {
            return false;
        }
        Cardapio other = (Cardapio) object;
        if ((this.idCardapio == null && other.idCardapio != null) || (this.idCardapio != null && !this.idCardapio.equals(other.idCardapio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Cardapio[ idCardapio=" + idCardapio + " ]";
    }
    
}
