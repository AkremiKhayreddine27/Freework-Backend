package com.freework.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "companies")
@DiscriminatorValue("COMPANY")
public class Company extends Freelancer{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    private Date establishedOn;

    public Date getEstablishedOn() {
        return establishedOn;
    }

    public void setEstablishedOn(Date establishedOn) {
        this.establishedOn = establishedOn;
    }
}
