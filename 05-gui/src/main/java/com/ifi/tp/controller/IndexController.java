package com.ifi.tp.controller;

import com.ifi.tp.entity.Trainerentity;
import com.ifi.tp.listener.Producter;
import com.ifi.tp.repositary.TrainerRepository;
import com.ifi.tp.service.PokemonService;
import com.ifi.tp.repositary.PokemonRepository;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jms.*;
import java.util.Optional;

@Controller
public class IndexController {
    @Autowired
    Producter producter;
    @Autowired
    PokemonService pokemonService;
    @Autowired
    PokemonRepository pokemonRepository;
    @Autowired
    TrainerRepository trainerRepository;


    @GetMapping("/")
    String index() throws JMSException {
       producter.sendMessage("coucou");

        MessageProducer producer = null;
        Connection connection = null;
        ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        connection = factory.createConnection();
        ActiveMQSession session = (ActiveMQSession) connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("myQueue2");
        producer = session.createProducer(queue);
        // Topic topic = session.createTopic("myTopic2");
        // producer = session.createProducer(topic);
        TextMessage textMessage = session.createTextMessage();
        textMessage.setText("Hello AMQ2");
        producer.send(textMessage);
        producer.close();
        connection.close();



        return "index";
    }
//    @GetMapping("/base")
//    void addToBasedeDonnee()
//    {
//        List<PokemonType> pokemonTypeList=pokemonService.listPokemonsTypes();
//        for(PokemonType pokemonType:pokemonTypeList)
//        {
//            Pokemonentity pokemonEntity=new Pokemonentity();
//
//            pokemonEntity.setId(pokemonType.getId());
//            pokemonEntity.setName(pokemonType.getName());
//            pokemonEntity.setWeight(pokemonType.getWeight());
//            pokemonEntity.setBaseExperience(pokemonType.getBaseExperience());
//            pokemonEntity.setHeight(pokemonType.getHeight());
//
//
//            pokemonEntity.setBack_default(pokemonType.getSprites().getBack_default());
//            pokemonEntity.setFront_default(pokemonType.getSprites().getFront_default());
//            pokemonEntity.setSpeed(pokemonType.getStats().getSpeed());
//            pokemonEntity.setSpecialAttack(pokemonEntity.getSpecialAttack());
//            pokemonEntity.setSpecialDefence(pokemonEntity.getSpecialDefence());
//
//
//            pokemonEntity.setDefense(pokemonType.getStats().getDefense());
//            pokemonEntity.setAttack(pokemonType.getStats().getAttack());
//            pokemonEntity.setHp(pokemonType.getStats().getHp());
//
//            pokemonRepository.save(pokemonEntity);
//
//        }
//
//
//
//    }



//    @GetMapping("/base")
//    void addToBasedeDonnee()
//    {
//        List<PokemonType> pokemonTypeList=pokemonService.listPokemonsTypes();
//        for(PokemonType pokemonType:pokemonTypeList)
//        {
//            Pokemonentity pokemonEntity=new Pokemonentity();
//
//            pokemonEntity.setId(pokemonType.getId());
//            pokemonEntity.setName(pokemonType.getName());
//            pokemonEntity.setWeight(pokemonType.getWeight());
//            pokemonEntity.setBaseExperience(pokemonType.getBaseExperience());
//            pokemonEntity.setHeight(pokemonType.getHeight());
//
//
//            pokemonEntity.setBack_default(pokemonType.getSprites().getBack_default());
//            pokemonEntity.setFront_default(pokemonType.getSprites().getFront_default());
//            pokemonEntity.setSpeed(pokemonType.getStats().getSpeed());
//            pokemonEntity.setSpecialAttack(pokemonEntity.getSpecialAttack());
//            pokemonEntity.setSpecialDefence(pokemonEntity.getSpecialDefence());
//
//
//            pokemonEntity.setDefense(pokemonType.getStats().getDefense());
//            pokemonEntity.setAttack(pokemonType.getStats().getAttack());
//            pokemonEntity.setHp(pokemonType.getStats().getHp());
//
//            pokemonRepository.save(pokemonEntity);
//
//        }
//
//
//
//    }


    @PostMapping(value = "/registerTrainer")
    ModelAndView registerNewTrainer(@RequestParam("trainerName")  String trainerName){
        Optional<Trainerentity> trainerentityOptional=trainerRepository.findByName(trainerName);

       if(trainerentityOptional.isEmpty())
       {
           Trainerentity trainerentity=new Trainerentity();
            trainerentity.setName(trainerName);
            trainerRepository.save(trainerentity);
           var modelAndViewsign = new ModelAndView("sign");
           modelAndViewsign.addObject("name", trainerName);
           return modelAndViewsign;

       }

        var modelAndView = new ModelAndView("register");
        modelAndView.addObject("name", trainerName);
        return modelAndView;
    }

    @PostMapping(value = "/signTrainer")
    ModelAndView signNewTrainer(@RequestParam("photo")  String photo,@RequestParam("name")  String name){
        Optional<Trainerentity> trainerentityOptional=trainerRepository.findByName(name);

        if(!trainerentityOptional.isEmpty())
        {
            Trainerentity trainerentity=trainerentityOptional.get();
            trainerentity.setPicture(photo);
            trainerRepository.save(trainerentity);
        }
        var modelAndView = new ModelAndView("register");
        modelAndView.addObject("name", name);
        return modelAndView;
    }



}
