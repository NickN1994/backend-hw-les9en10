package nl.hw.hwtechiteasy.controllers;

import nl.hw.hwtechiteasy.Model.Television;
import nl.hw.hwtechiteasy.Repository.TelevisionRepository;
import nl.hw.hwtechiteasy.exceptions.NameNotApprovedException;
import nl.hw.hwtechiteasy.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class TelevisionsController {


    private final TelevisionRepository televisionRepository;

    public TelevisionsController(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;

    }

    private ArrayList<String> tvlist = new ArrayList<>();

    @PostMapping("/addtv")
    public ResponseEntity<Television> addTV(@RequestBody Television television) {
//        if (tv.length() > 20) {
//            throw new NameNotApprovedException("tv naam is groter dan 20 karakters");
//        } else if (tv.length() < 4) {
//            throw new NameNotApprovedException("tv naam is kleiner dan 4 karakters");
//
//        } else {
//
//            this.tvlist.add(tv);

        Television savedTelevision = televisionRepository.save(television);

        return ResponseEntity.created(null).body(television);
    }


    @GetMapping("/showtv/{id}")
    public ResponseEntity<Television> getTelvision(@PathVariable("id") Long id) {
//        if (id < 10) {


        Optional<Television> savedTelevision = televisionRepository.findById(id);
        return ResponseEntity.ok(savedTelevision.get());


//        } else {
//            throw new RecordNotFoundException("Getal is hoger dan 10");
    }

//    }

    @GetMapping("/showtv")
    public ResponseEntity<Object> showTvList() {
        return ResponseEntity.ok("Dit is een lijst met tv's");

    }

    @PutMapping("/changetvlist/{id}")
    public ResponseEntity<Object> tvlist(@PathVariable("id") int id, @RequestBody String name) {
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/deletetv/{id}")
    public ResponseEntity<Object> deleteTv(@PathVariable("id") int id) {
        return ResponseEntity.noContent().build();
    }
}


