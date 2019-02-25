/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Magnus
 */
@Entity
@Table(name = "orders")
@NamedQueries({
    @NamedQuery(name = "OrderClassic.findAll", query = "SELECT o FROM OrderClassic o")
    , @NamedQuery(name = "OrderClassic.findByOrderNumber", query = "SELECT o FROM OrderClassic o WHERE o.orderNumber = :orderNumber")
    , @NamedQuery(name = "OrderClassic.findByOrderDate", query = "SELECT o FROM OrderClassic o WHERE o.orderDate = :orderDate")
    , @NamedQuery(name = "OrderClassic.findByRequiredDate", query = "SELECT o FROM OrderClassic o WHERE o.requiredDate = :requiredDate")
    , @NamedQuery(name = "OrderClassic.findByShippedDate", query = "SELECT o FROM OrderClassic o WHERE o.shippedDate = :shippedDate")
    , @NamedQuery(name = "OrderClassic.findByStatus", query = "SELECT o FROM OrderClassic o WHERE o.status = :status")})
public class OrderClassic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "orderNumber", nullable = false)
    private Integer orderNumber;
    @Basic(optional = false)
    @Column(name = "orderDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @Basic(optional = false)
    @Column(name = "requiredDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date requiredDate;
    @Column(name = "shippedDate")
    @Temporal(TemporalType.DATE)
    private Date shippedDate;
    @Basic(optional = false)
    @Column(name = "status", nullable = false, length = 15)
    private String status;
    @Lob
    @Column(name = "comments", length = 65535)
    private String comments;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderClassic")
    private Collection<Orderdetail> orderdetailCollection;
    @JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber", nullable = false)
    @ManyToOne(optional = false)
    private Customer customer;

    public OrderClassic() {
    }

    public OrderClassic(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public OrderClassic(Integer orderNumber, Date orderDate, Date requiredDate, String status) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.status = status;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Collection<Orderdetail> getOrderdetailCollection() {
        return orderdetailCollection;
    }

    public void setOrderdetailCollection(Collection<Orderdetail> orderdetailCollection) {
        this.orderdetailCollection = orderdetailCollection;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderNumber != null ? orderNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderClassic)) {
            return false;
        }
        OrderClassic other = (OrderClassic) object;
        if ((this.orderNumber == null && other.orderNumber != null) || (this.orderNumber != null && !this.orderNumber.equals(other.orderNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderClassic[ orderNumber=" + orderNumber + " ]";
    }
    
}
