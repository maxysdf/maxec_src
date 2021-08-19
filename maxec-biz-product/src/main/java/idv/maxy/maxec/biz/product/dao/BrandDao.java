package idv.maxy.maxec.biz.product.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import idv.maxy.maxec.biz.product.model.Brand;

public interface BrandDao extends JpaRepository<Brand, String> {

}
