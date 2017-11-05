package com.freework.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "entries")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    private String description;

    private int prize;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("entries")
    private Contest contest;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="freelancer_id")
    @JsonIgnoreProperties("entries")
    private Freelancer freelancer;

    private Date created_at;

    private Date updated_at;

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

    public Contest getContest() {
        return contest;
    }

    public void setContest(Contest contest) {
        this.contest = contest;
    }

    public Freelancer getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(Freelancer freelancer) {
        this.freelancer = freelancer;
    }


    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }


    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
