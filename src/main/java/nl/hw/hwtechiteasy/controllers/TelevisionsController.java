package nl.hw.hwtechiteasy.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TelevisionsController {

    private ArrayList<String> tvlist = new ArrayList<>();

    @PostMapping("/addtv")
    public void addTV(@RequestParam String tv) {
        this.tvlist.add(tv);

    }

    @GetMapping("/showtv")
    public String tv() {
        if (this.tvlist == null || this.tvlist.isEmpty()) {
            return "no tv found";
        } else {
            return tvlist;
        }

    }

    @GetMapping("/showtvlist")
    public String tvlist(@RequestParam String tv) {
        if (this.tvlist == null || this.tvlist.isEmpty()) {
            return "No list found";
        } else {
            return tvlist;
        }

    }
}

