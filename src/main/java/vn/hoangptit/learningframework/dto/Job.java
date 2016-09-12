package vn.hoangptit.learningframework.dto;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author Hoangptit
 *         12/09/2016
 */
@Entity
public class Job {
    private int id;
    private int targetId;
    private String name;
    private String description;
    private double sumJob;
    private Date timeJob;
    private Target targetByTargetId;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TargetID")
    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "SumJob")
    public double getSumJob() {
        return sumJob;
    }

    public void setSumJob(double sumJob) {
        this.sumJob = sumJob;
    }

    @Basic
    @Column(name = "TimeJob")
    public Date getTimeJob() {
        return timeJob;
    }

    public void setTimeJob(Date timeJob) {
        this.timeJob = timeJob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        if (id != job.id) return false;
        if (targetId != job.targetId) return false;
        if (Double.compare(job.sumJob, sumJob) != 0) return false;
        if (name != null ? !name.equals(job.name) : job.name != null) return false;
        if (description != null ? !description.equals(job.description) : job.description != null) return false;
        if (timeJob != null ? !timeJob.equals(job.timeJob) : job.timeJob != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + targetId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        temp = Double.doubleToLongBits(sumJob);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (timeJob != null ? timeJob.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "TargetID", referencedColumnName = "ID", nullable = false)
    public Target getTargetByTargetId() {
        return targetByTargetId;
    }

    public void setTargetByTargetId(Target targetByTargetId) {
        this.targetByTargetId = targetByTargetId;
    }
}
