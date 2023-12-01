package nl.hw.hwtechiteasy.controllers;

import nl.hw.hwtechiteasy.Model.Television;
import nl.hw.hwtechiteasy.Repository.TelevisionRepository;
import nl.hw.hwtechiteasy.dto.TelevisionDto;
import nl.hw.hwtechiteasy.exceptions.RecordNotFoundException;

import nl.hw.hwtechiteasy.services.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class TelevisionsController {


    private final TelevisionService televisionService;

    public TelevisionsController(TelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @GetMapping("/televisions")
    public List<Television> getAllTelevisions(@RequestParam (value = "brand", required = false) String brand) {

        List<Television> televisions;

        if (brand == null) {
            televisions = televisionRepository.findAll();
        } else {
            televisions = televisionRepository.findAllTelevisionsByBrandEqualsIgnoreCase(brand);
        }

        return ResponseEntity.ok().body(televisions).getBody();

    }

    @GetMapping("/televisions/{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable("id") Long id) {

        Optional<Television> television = televisionRepository.findById(id);
        if (television.isEmpty()) {
            throw new RecordNotFoundException("No television found with id: " + id);
        } else {
            Television television1 = television.get();
            return ResponseEntity.ok(television1);
        }

    }


    @PostMapping("/addtv")
    public ResponseEntity<TelevisionDto> addTelevision(@RequestBody TelevisionDto televisionDto) {


        TelevisionDto savedTelevision = televisionService.createTelevision(televisionDto);
        URI uri = URI.create(
                ServletUriComponentsBuilder.fromCurrentRequest().path(("/") + savedTelevision.id).toUriString());

        return ResponseEntity.created(uri).body(savedTelevision);
    }

    @DeleteMapping("/deletetv/{id}")
    public ResponseEntity<Object> deleteTelevision (@PathVariable("id") Long id) {

        televisionRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updatetelevision/{id}")
    public ResponseEntity<Television> updateTelevision (@PathVariable("id") Long id, @RequestBody Television newTelevision) {
        Optional<Television> television = televisionRepository.findById(id);
        if (television.isEmpty()) {
            throw new  RecordNotFoundException("No television found with " + id);
        } else {
            Television television1 = television.get();
            television1.setAmbiLight(newTelevision.getAmbiLight());
            television1.setAvailableSize(newTelevision.getAvailableSize());
            television1.setAmbiLight(newTelevision.getAmbiLight());
            television1.setBluetooth(newTelevision.getBluetooth());
            television1.setBrand(newTelevision.getBrand());
            television1.setHdr(newTelevision.getHdr());
            television1.setName(newTelevision.getName());
            television1.setOriginalStock(newTelevision.getOriginalStock());
            television1.setPrice(newTelevision.getPrice());
            television1.setRefreshRate(newTelevision.getRefreshRate());
            television1.setScreenQuality(newTelevision.getScreenQuality());
            television1.setScreenType(newTelevision.getScreenType());
            television1.setSmartTv(newTelevision.getSmartTv());
            television1.setSold(newTelevision.getSold());
            television1.setType(newTelevision.getType());
            television1.setVoiceControl(newTelevision.getVoiceControl());
            television1.setWifi(newTelevision.getWifi());

            Television returnTelevision = televisionRepository.save(television1);
            return ResponseEntity.ok().body(returnTelevision);
        }

    }


}


