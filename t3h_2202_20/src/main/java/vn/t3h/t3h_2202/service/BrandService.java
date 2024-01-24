package vn.t3h.t3h_2202.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.t3h.t3h_2202.entity.BrandEntity;
import vn.t3h.t3h_2202.repository.BrandRepository;

import java.util.List;

@Service
public class BrandService {

    @Autowired
    BrandRepository brandRepository;

    public List<BrandEntity> findAll() {
        return brandRepository.findAll();
    };
    public BrandEntity findById(Long id) {
        return brandRepository.findById(id).orElse(null);
    };


}