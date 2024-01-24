package vn.t3h.t3h_2202.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "cart", schema = "2202", catalog = "")
public class CartEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Basic
    @Column(name = "IDUSER")
    public Long  userId;

    @Basic
    @Column(name = "IDPRODUCT")
    public Long  productId;

    @Basic
    @Column(name = "quantity")
    public Long quantity;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "productId", referencedColumnName = "ID", insertable = false, updatable = false)
//    ProductEntity productEntity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IDPRODUCT", referencedColumnName = "ID",insertable=false,updatable = false)
    public ProductEntity productEntity;
}
