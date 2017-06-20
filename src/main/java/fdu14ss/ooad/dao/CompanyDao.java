package fdu14ss.ooad.dao;

import fdu14ss.ooad.entity.Company;
import fdu14ss.ooad.entity.CheckTemplateItem;
import fdu14ss.ooad.entity.enums.Category;
import fdu14ss.ooad.entity.enums.Industry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wangziheng on 2017/6/18.
 */
@Repository
public interface CompanyDao extends JpaRepository<Company, Long> {
    List<Company> findCompaniesByName(String name);

}
