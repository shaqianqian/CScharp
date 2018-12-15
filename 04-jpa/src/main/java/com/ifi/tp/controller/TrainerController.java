package com.ifi.tp.controller;

import com.ifi.tp.bo.Trainer;
import com.ifi.tp.service.NotificationService;
import com.ifi.tp.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.jms.JMSException;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

    @Autowired
    NotificationService notificationService;

    private final TrainerService trainerService;

    TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("")
    Iterable<Trainer> getAllTrainers() {
        return this.trainerService.getAllTrainers();
    }
    @GetMapping("send")
    void send() throws JMSException {
        this.notificationService.test();
    }

    @GetMapping("/{name}")
    Trainer getTrainer(@PathVariable String name) {
        return this.trainerService.getTrainer(name);
    }

    @PostMapping("")
    Trainer createTrainer(@RequestBody Trainer trainer) {
        return this.trainerService.createTrainer(trainer);
    }

    @PutMapping("/{name}")
    Trainer updateTrainer(@RequestBody Trainer trainer) {
        return this.trainerService.updateTrainer(trainer);
    }

    @DeleteMapping("/{name}")
    void deleteTrainer(@PathVariable String name) {
        this.trainerService.deleteTrainer(name);
    }



}
