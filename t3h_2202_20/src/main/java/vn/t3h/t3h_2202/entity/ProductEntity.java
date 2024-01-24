package vn.t3h.t3h_2202.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "product", schema = "2202", catalog = "")
public class ProductEntity {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;


    @Basic
    @Column(name = "NAME")
    public String  name;

    @Basic
    @Column(name = "PRICE")
    public Integer price;

     @Basic
     @Column(name = "DESCRIPTION")
    public String  description;

    @Basic
    @Column(name = "IMAGE")
    public String  image;

    @Basic
    @Column(name = "CPU")
    public String cpu;

    @Basic
    @Column(name = "Memory")
    public String  memory;

    @Basic
    @Column(name = "RAM")
    public String ram;

    @Basic
    @Column(name = "VGA")
    public String  vga;

    @Basic
    @Column(name = "Display")
    public String display;


    @Basic
    @Column(name = "LAN")
    public String lan;

    @Basic
    @Column(name = "Batterry")
    public String  batterry;

    @Basic
    @Column(name = "OS")
    public String os;

    @Basic
    @Column(name = "Weight")
    public String  weight;


    @Basic
    @Column(name = "Color")
    public String  color;

    @Basic
    @Column(name = "BRAND_ID")
    public Long brandId;

    @Basic
    @Column(name = "CATEGORY_ID")
    public Long categoryId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BRAND_ID", referencedColumnName = "ID",insertable=false,updatable = false)
    public BrandEntity brandEntity;
}
