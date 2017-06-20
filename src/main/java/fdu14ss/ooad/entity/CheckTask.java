package fdu14ss.ooad.entity;

import javax.validation.constraints.NotNull;
import fdu14ss.ooad.entity.enums.TaskStatus;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wangziheng on 2017/6/17.
 */
@Entity
@Table(name = "check_task")
public class CheckTask extends BaseEntity{

    @NotNull
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private CheckPlan checkPlan;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date finish_time;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TaskStatus status = TaskStatus.Checking;

    public CheckTask() {}

    public CheckTask(CheckPlan checkPlan, Date finish_time, TaskStatus status) {

        this.checkPlan = checkPlan;

        this.finish_time = finish_time;

        this.status = status;
    }

    public CheckPlan getCheckPlan() {
        return checkPlan;
    }

    public void setCheckPlan(CheckPlan checkPlan) {
        this.checkPlan = checkPlan;
    }

    public Date getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(Date finish_time) {
        this.finish_time = finish_time;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
    
}
