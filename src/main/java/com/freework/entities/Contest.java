package com.freework.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "contests")
public class Contest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    private String description;

    private int prize;

    private int duration;

    private String type;

    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="publisher_id" )
    private Freelancer publisher;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="winner_id" )
    private Freelancer winner;

    @ManyToOne
    private Job job;

    @OneToMany(mappedBy = "contest",fetch = FetchType.EAGER)
    @JsonIgnoreProperties("contest")
    private Set<Entry> entries;

    @Formula("(select count(*) from entries e where e.contest_id = id)")
    private Integer entriesCount;

    public Integer getEntriesCount() {
        return entriesCount;
    }

    public void setEntriesCount(Integer count) {
        this.entriesCount = count;
    }

    @Formula("(select count(distinct e.freelancer_id) from entries e where e.contest_id = id)")
    private Integer freelancersCount;

    public Integer getFreelancersCount() {
        return freelancersCount;
    }

    public void setFreelancersCount(Integer freelancersCount) {
        this.freelancersCount = freelancersCount;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Set<Entry> getEntries() {
        return entries;
    }

    public void setEntries(Set<Entry> entries) {
        this.entries = entries;
    }

    public Freelancer getPublisher() {
        return publisher;
    }

    public void setPublisher(Freelancer publisher) {
        this.publisher = publisher;
    }

    public Freelancer getWinner() {
        return winner;
    }

    public void setWinner(Freelancer winner) {
        this.winner = winner;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date created_at) {
        this.createdAt = created_at;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updated_at) {
        this.updatedAt = updated_at;
    }
}
