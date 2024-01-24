package vn.t3h.t3h_2202.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.t3h.t3h_2202.entity.Reviewentity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private Long id;
    private Long idProduct;
    private String name;
    private String email;
    private String comment;

    public Reviewentity convertEntity(){
        Reviewentity reviewEntity = new Reviewentity();
        reviewEntity.setIdproduct(idProduct);
        reviewEntity.setEmail(email);
        reviewEntity.setName(name);
        reviewEntity.setComment(comment);
        return  reviewEntity;
    }
}
