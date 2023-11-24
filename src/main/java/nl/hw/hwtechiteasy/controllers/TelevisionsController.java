package nl.hw.hwtechiteasy.controllers;

import nl.hw.hwtechiteasy.Model.Television;
import nl.hw.hwtechiteasy.Repository.TelevisionRepository;
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


        Television savedTelevision = televisionRepository.save(television);

        return ResponseEntity.created(null).body(television);
    }


    @GetMapping("/showtv/{id}")
    public ResponseEntity<Television> getTelvision(@PathVariable("id") Long id) {
//        if (id < 10) {


        Optional<Television> savedTelevision = televisionRepository.findById(id);
        return ResponseEntity.ok(savedTelevision.get());



    }


    @GetMapping("/showtvlist")
    public ResponseEntity<String> showTvList() {
        return ResponseEntity.ok(televisionRepository.findAll().toString());

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


