package vn.t3h.t3h_2202.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.t3h.t3h_2202.entity.CategoryEntity;
import vn.t3h.t3h_2202.paging.PagingAndSortObject;
import vn.t3h.t3h_2202.repository.CategoryRepository;

import java.sql.SQLException;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<CategoryEntity> findAll(){
        return categoryRepository.findAll();
    }
    public CategoryEntity findById(Long id) {return categoryRepository.findById(id).orElse(null);};
    public void danhsach(PagingAndSortObject pagingAndSortObject) throws SQLException {
        pagingAndSortObject.findAll(categoryRepository);
    }


}
