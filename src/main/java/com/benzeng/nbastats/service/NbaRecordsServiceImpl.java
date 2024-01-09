package com.benzeng.nbastats.service;

import com.benzeng.nbastats.entity.NbaRecords;
import com.benzeng.nbastats.entity.NbaRecordsID;
import com.benzeng.nbastats.repository.NbaRecordsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class NbaRecordsServiceImpl implements NbaRecordsService{

    private NbaRecordsRepository repo;
    public NbaRecordsServiceImpl(NbaRecordsRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<NbaRecords> getAllNbaRecords() {
        return this.repo.findAll();
    }

    @Override
    public List<NbaRecords> getNbaRecordsByTeam(String team) {
        return this.repo.findNbaRecordsByTeam(team);
    }

    @Override
    public List<NbaRecords> getNbaRecordsByDateAndTeam(Date date, String team) {
        return this.repo.findNbaRecordsByDateAndTeam(date, team);
    }

    @Override
    public NbaRecords getNbaRecordsByID(NbaRecordsID id) {
        Optional<NbaRecords> opt = this.repo.findById(id);
        return opt.orElse(null);
    }

    @Override
    public NbaRecords updateNbaRecords(NbaRecords records) {
        return this.repo.save(records);
    }

    @Override
    public void deleteByID(NbaRecordsID id) {
        this.repo.deleteById(id);
    }

    @Override
    public NbaRecords create(NbaRecords records){
        return this.repo.save(records);
    }
}
