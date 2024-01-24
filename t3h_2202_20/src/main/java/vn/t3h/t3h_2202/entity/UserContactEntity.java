package vn.t3h.t3h_2202.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "user_contact", schema = "2202", catalog = "")
public class UserContactEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(name = "ADDRESS")
    private String address;
    @Basic
    @Column(name = "USER_ID")
    private Long userId;

}
