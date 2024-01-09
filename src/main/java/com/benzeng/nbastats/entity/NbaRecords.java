package com.benzeng.nbastats.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "\"nbaRecords\"")
public class NbaRecords {
    public NbaRecordsID getId() {
        return id;
    }

    public void setId(NbaRecordsID id) {
        this.id = id;
    }

    @EmbeddedId
    private NbaRecordsID id;

    public String getConf() {
        return conf;
    }

    public void setConf(String conf) {
        this.conf = conf;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    @Column(name = "conf")
    private String conf;

    @Column
    private int wins;

    @Column
    private int losses;

}
