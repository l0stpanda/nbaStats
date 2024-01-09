package com.benzeng.nbastats.controller;

import com.benzeng.nbastats.entity.NbaRecords;
import com.benzeng.nbastats.entity.NbaRecordsID;
import com.benzeng.nbastats.service.NbaRecordsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@RestController
@Slf4j
public class NbaRecordsController {
    private NbaRecordsService service;

    public NbaRecordsController(NbaRecordsService service) {
        this.service = service;
    }

    @GetMapping("/records")
    List<NbaRecords> nbaRecordsList(){
        return this.service.getAllNbaRecords();
    }

    @GetMapping("/team")
    List<NbaRecords> nbaTeamsList(@RequestParam String team){
        return this.service.getNbaRecordsByTeam(team);
    }

    @GetMapping("/teamdate")
    List<NbaRecords> nbaDateAndTeamList(@RequestParam String team, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date date){
        return this.service.getNbaRecordsByDateAndTeam(date, team);
    }

    //change this later
    @PostMapping("/update")
    NbaRecords nbaUpdate(){
        Date date = new GregorianCalendar(2024, Calendar.JANUARY, 8).getTime();
        NbaRecords record = new NbaRecords();
        record.setId(new NbaRecordsID("MIN", date));
        record.setConf("West");
        record.setWins(26);
        record.setLosses(9);
        return this.service.updateNbaRecords(record);
    }

    @PostMapping("/create")
    NbaRecords nbaCreate(@RequestBody NbaRecords record){
        return this.service.create(record);
    }

    @PostMapping("/deletebyid")
    void nbaDelete(@RequestParam String team, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date date){
        NbaRecordsID id = new NbaRecordsID(team, date);
        this.service.deleteByID(id);
    }

}
