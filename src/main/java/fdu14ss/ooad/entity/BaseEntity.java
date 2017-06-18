package fdu14ss.ooad.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
/**
 * Created by wangziheng on 2017/6/18.
 */
@MappedSuperclass
public abstract class BaseEntity implements Comparable<BaseEntity> {
    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        id = id;
    }
    @Override
    public boolean equals(Object other) {
        if (other == null || other.getClass() != this.getClass())
            return false;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(this.getId(), ((BaseEntity) other).getId());
        return eb.isEquals();
    }
    @Override
    public int compareTo(BaseEntity o) {
        return this.getId().compareTo(o.getId());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).toHashCode();
    }
}
