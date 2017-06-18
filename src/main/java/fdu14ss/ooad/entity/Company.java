package fdu14ss.ooad.entity;

import javax.validation.constraints.NotNull;
import fdu14ss.ooad.entity.enums.Category;
import fdu14ss.ooad.entity.enums.Industry;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangziheng on 2017/6/17.
 */
@Entity
@Table(name = "companies")
public class Company extends BaseEntity{

    @NotNull
    private String name;


    @Enumerated(EnumType.STRING)
    private Category category = Category.Undefined;//行业大类


    @Enumerated(EnumType.STRING)
    private Industry industry = Industry.Undefined;//所属行业

    private String linkman="";

    private String phone_num="";

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "com_id",referencedColumnName = "id")
    private Set<CheckTask> task_set = new HashSet<CheckTask>();

    public Company() {}

    public Company(String name) {
        this.name = name;
    }

    public Company(String name, Category category, Industry industry) {
        this.name = name;
        this.category = category;
        this.industry = industry;
    }

    public Company(String name, String linkman, String phone_num) {
        this.name = name;
        this.linkman = linkman;
        this.phone_num = phone_num;
    }

    public Company(String name, Category category, Industry industry, String linkman, String phone_num) {
        this.name = name;
        this.category = category;
        this.industry = industry;
        this.linkman = linkman;
        this.phone_num = phone_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndusrty(Industry industry) {
        this.industry = industry;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public Set<CheckTask> getTask_set() {
        return task_set;
    }
}
