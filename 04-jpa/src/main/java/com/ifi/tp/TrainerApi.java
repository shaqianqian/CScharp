package com.ifi.tp;

import com.ifi.tp.bo.Pokemon;
import com.ifi.tp.bo.Trainer;
import com.ifi.tp.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@SpringBootApplication
public class TrainerApi {

    public static void main(String... args){
        SpringApplication.run(TrainerApi.class, args);
    }




}
