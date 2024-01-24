package vn.t3h.t3h_2202.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.t3h.t3h_2202.dto.ReviewDto;
import vn.t3h.t3h_2202.entity.Reviewentity;
import vn.t3h.t3h_2202.repository.ReviewRopository;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    ReviewRopository reviewRopository;

    public ReviewDto saveReview(ReviewDto reviewDto){
        Reviewentity reviewentity = reviewDto.convertEntity();
        reviewRopository.save(reviewentity);
        return  reviewDto;
    }

    public List<Reviewentity> findAllByProductId(Long id){return reviewRopository.findAllByIdproduct(id);};
}
