package idv.maxy.maxec.biz.product.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import idv.maxy.maxec.biz.product.model.Category;

public interface CategoryDao extends JpaRepository<Category, String> {

}
