package fdu14ss.ooad.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wangziheng on 2017/6/17.
 */
@Entity
@Table(name = "check_plan")
public class CheckPlan {
    @Id
    @GeneratedValue
    @Column(name = "plan_id")
    private Long id;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "template_id")
    private CheckTemplate template;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date begin_date;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date ddl;

    @NotNull
    private String plan_src;

    public CheckPlan() {
    }

    public CheckPlan(CheckTemplate template, Date begin_date, Date ddl, String plan_src) {
        this.template = template;
        this.begin_date = begin_date;
        this.ddl = ddl;
        this.plan_src = plan_src;
    }

    public Long getId() {
        return id;
    }

    public CheckTemplate getTemplate() {
        return template;
    }

    public Date getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(Date begin_date) {
        this.begin_date = begin_date;
    }

    public Date getDdl() {
        return ddl;
    }

    public void setDdl(Date ddl) {
        this.ddl = ddl;
    }

    public String getPlan_src() {
        return plan_src;
    }

    public void setPlan_src(String plan_src) {
        this.plan_src = plan_src;
    }
}
