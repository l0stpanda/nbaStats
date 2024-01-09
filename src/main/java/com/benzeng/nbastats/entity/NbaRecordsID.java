package com.benzeng.nbastats.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class NbaRecordsID implements Serializable {
    @Column(name = "team")
    private String team;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public NbaRecordsID() {
    }

    public NbaRecordsID(String team, Date date) {
        this.team = team;
        this.date = date;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NbaRecordsID nbaRecordsID = (NbaRecordsID) o;
        return Objects.equals(team, nbaRecordsID.team) && Objects.equals(date, nbaRecordsID.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(team, date);
    }
}
