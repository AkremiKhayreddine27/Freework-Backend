package com.freework.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "freelancers")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "freelancer_type")
public abstract class Freelancer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String email;

    private String password;

    private String phone;

    private String facebook;

    private String linkedin;

    private String about;

    private String avatar;

    private int address_id;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("freelancer")
    @JoinColumn(name="freelancer_id")
    protected Set<Entry> entries;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("publisher")
    @JoinColumn(name="publisher_id")
    protected Set<Contest> publishedContests;

    @OneToMany(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("winner")
    @JoinColumn(name="winner_id")
    protected Set<Contest> winnedContests;

    private Date created_at;

    private Date updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public void setEntries(Set<Entry> entries){
        this.entries = entries;
    }

    public Set<Entry> getEntries(){
        return entries;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public Set<Contest> getPublishedContests() {
        return publishedContests;
    }

    public void setPublishedContests(Set<Contest> publishedContests) {
        this.publishedContests = publishedContests;
    }

    public Set<Contest> getWinnedContests() {
        return winnedContests;
    }

    public void setWinnedContests(Set<Contest> winnedContests) {
        this.winnedContests = winnedContests;
    }
}
