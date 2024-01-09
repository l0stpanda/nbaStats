package com.benzeng.nbastats.repository;

import com.benzeng.nbastats.entity.NbaRecords;
import com.benzeng.nbastats.entity.NbaRecordsID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface NbaRecordsRepository extends JpaRepository<NbaRecords, NbaRecordsID> {
    @Query(value = "SELECT conf, team, wins, losses, date FROM nbaRecords WHERE team = :team", nativeQuery = true)
    public List<NbaRecords> findNbaRecordsByTeam(@Param("team") String team);

    @Query(value = "SELECT conf, team, wins, losses, date FROM nbaRecords WHERE Date = :date AND team = :team", nativeQuery = true)
    public List<NbaRecords> findNbaRecordsByDateAndTeam(@Param("date") Date date, @Param("team") String team);
}