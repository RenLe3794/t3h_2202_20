package vn.t3h.t3h_2202.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "checkout", schema = "2202", catalog = "")
public class CheckoutEntity {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Basic
    @Column(name = "userId")
    public Integer  userId;

    @Basic
    @Column(name = "name")
    public String name;

    @Basic
    @Column(name = "address")
    public String  address;

    @Basic
    @Column(name = "phone")
    public String  phone;

    @Basic
    @Column(name = "notice")
    public String  notice;

    @Basic
    @Column(name = "money")
    public int  money;

}
