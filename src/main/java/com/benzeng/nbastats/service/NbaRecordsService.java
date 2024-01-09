package com.benzeng.nbastats.service;

import com.benzeng.nbastats.entity.NbaRecords;
import com.benzeng.nbastats.entity.NbaRecordsID;

import java.util.Date;
import java.util.List;

public interface NbaRecordsService {
    List<NbaRecords> getAllNbaRecords();
    List<NbaRecords> getNbaRecordsByTeam(String team);
    List<NbaRecords> getNbaRecordsByDateAndTeam(Date date, String team);
    NbaRecords getNbaRecordsByID(NbaRecordsID id);
    NbaRecords updateNbaRecords(NbaRecords records);
    void deleteByID(NbaRecordsID id);
    NbaRecords create(NbaRecords records);
}
