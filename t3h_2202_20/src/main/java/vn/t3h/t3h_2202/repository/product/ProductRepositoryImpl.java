package vn.t3h.t3h_2202.repository.product;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import vn.t3h.t3h_2202.dto.ProductDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public ProductDto detailNative(Long id) {
        String sql = "SELECT p.ID id, p.NAME name, b.name brandName, p.brandId brandId " +
                " FROM product p JOIN brand b ON p.BRAND_ID = b.id where p.ID = " + id;

        List<ProductDto> productDtoList = entityManager.unwrap(Session.class).createNativeQuery(sql)
                .addScalar("id", LongType.INSTANCE)
                .addScalar("name", StringType.INSTANCE)
                .addScalar("brandName", StringType.INSTANCE)
                .addScalar("brandId", LongType.INSTANCE)
                .setResultTransformer(Transformers.aliasToBean(ProductDto.class)).list();
        if (productDtoList != null && productDtoList.size() > 0) return productDtoList.get(0);
        return null;
    }
}
