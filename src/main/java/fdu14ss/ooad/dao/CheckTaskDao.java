package fdu14ss.ooad.dao;

import fdu14ss.ooad.entity.CheckTask;
import fdu14ss.ooad.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangziheng on 2017/6/18.
 */
public interface CheckTaskDao extends JpaRepository<CheckTask, Long> {

}
