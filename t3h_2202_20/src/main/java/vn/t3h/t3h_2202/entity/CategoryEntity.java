package vn.t3h.t3h_2202.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "category", schema = "2202", catalog = "")
public class CategoryEntity {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Basic
    @Column(name = "description")
    private String  description;

    @Basic
    @Column(name = "name")
    private String  name;
}
