package vn.t3h.t3h_2202.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.t3h.t3h_2202.dto.ProductDto;
import vn.t3h.t3h_2202.entity.ProductEntity;
import vn.t3h.t3h_2202.paging.PagingAndSortObject;
import vn.t3h.t3h_2202.repository.product.ProductRepository;

import java.sql.SQLException;
import java.util.List;

@Service// tạo ra 1 object được lưu trong spring bean
@Transactional
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<ProductEntity> findCategory(Long categoryId){return productRepository.findAllByCategoryId(categoryId);}

    public ProductDto saveProduct(ProductDto productDto) {
        ProductEntity productEntity = productDto.ConvertEntity();
        productRepository.save(productEntity);
        return productDto;
    }

    public void danhsach(PagingAndSortObject pagingAndSortObject) throws SQLException {
        pagingAndSortObject.findAll(productRepository);
    }



    public List<ProductEntity> findTop10() {
        return productRepository.findTop10();
    }

    public List<ProductEntity> findTop4() {
        return productRepository.findTop4();
    }

    public List<ProductEntity> findBrand(Long brandId) {
        return productRepository.findAllByBrandId(brandId);
    }

    public ProductDto detailNative(Long id) {
        return productRepository.detailNative(id);
    }


    public void deleteById(Long productId) {
        productRepository.deleteById(productId);
    };

    public ProductDto detail(long id) {
        ProductEntity productEntity = productRepository.findById(id).get();
        ProductDto dto = new ProductDto();
        BeanUtils.copyProperties(productEntity, dto);
        return dto;
    }

    public ProductDto editProduct(ProductDto productDto) {
         ProductEntity entity = productRepository.findById(productDto.getId()).get();
        if (entity == null) {
            System.out.println("Không tồn tại user");
            throw new RuntimeException("product không tồn tại");
        }
        ProductEntity productEntity = productDto.ConvertEntity();

        productRepository.save(productEntity);
        return productDto;
    }


}