package fdu14ss.ooad.dao;

import fdu14ss.ooad.entity.Company;
import fdu14ss.ooad.entity.CheckTemplateItem;
import fdu14ss.ooad.entity.enums.Category;
import fdu14ss.ooad.entity.enums.Industry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wangziheng on 2017/6/18.
 */
public interface CompanyDao extends JpaRepository<Company, Long> {
    // 根据id查找公司
    public Company findCompanyById(Long id);
    // 根据公司名称模糊查找公司
    public Company findCompanyByNameContaining(String key);
    // 根据行业大类查找所有公司
    public List<Company> findCompaniesByCategory(Category type);
    // 根据具体行业查找所有公司
    public List<Company> findCompaniesByIndustry(Industry type);
    //


}
