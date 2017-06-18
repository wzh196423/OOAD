package fdu14ss.ooad.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wangziheng on 2017/6/17.
 */
@Entity
@Table(name = "check_task")
public class CheckTask {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne(optional = false,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "plan_id")
    private CheckPlan checkPlan;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date finish_time;


}
