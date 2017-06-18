package fdu14ss.ooad.dao;

import fdu14ss.ooad.entity.CheckTask;
import fdu14ss.ooad.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by wangziheng on 2017/6/18.
 */
@Repository
public interface CheckTaskDao extends JpaRepository<CheckTask, Long> {

}
