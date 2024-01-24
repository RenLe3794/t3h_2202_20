package vn.t3h.t3h_2202.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "review", schema = "2202", catalog = "")
public class Reviewentity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;


    @Basic
    @Column(name = "idproduct")
    public Long idproduct;

    @Basic
    @Column(name = "name")
    public String  name;

    @Basic
    @Column(name = "email")
    public String  email;

    @Basic
    @Column(name = "comment")
    public String comment;


}
