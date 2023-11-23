package nl.hw.hwtechiteasy.controllers;

import nl.hw.hwtechiteasy.exceptions.NameNotApprovedException;
import nl.hw.hwtechiteasy.exceptions.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TelevisionsController {

    private ArrayList<String> tvlist = new ArrayList<>();

    @PostMapping("/addtv")
    public ResponseEntity<Object> addTV(@RequestBody String tv) {
        if (tv.length() > 20) {
            throw new NameNotApprovedException("tv naam is groter dan 20 karakters");
        } else if (tv.length() < 4) {
            throw new NameNotApprovedException("tv naam is kleiner dan 4 karakters");

        } else {

            this.tvlist.add(tv);

        return ResponseEntity.created(null).body(tv + " tv is toegevoegd");
    }

    }

    @GetMapping("/showtv/{id}")
    public ResponseEntity<Object> tv(@PathVariable("id") int id) {
        if (id < 10) {
            return ResponseEntity.ok(id + "Dit is een tv");
        } else {
            throw new RecordNotFoundException("Getal is hoger dan 10");
        }

    }

    @GetMapping("/showtv")
    public ResponseEntity<Object> showTvList() {
        return ResponseEntity.ok("Dit is een lijst met tv's");

    }

    @PutMapping("/changetvlist/{id}")
    public ResponseEntity<Object> tvlist(@PathVariable ("id") int id, @RequestBody String name) {
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping ("/deletetv/{id}")
    public ResponseEntity<Object> deleteTv (@PathVariable ("id") int id) {
        return ResponseEntity.noContent().build();
    }
}


