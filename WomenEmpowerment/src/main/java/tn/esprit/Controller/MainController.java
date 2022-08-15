
package tn.esprit.Controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import tn.esprit.Entity.Event;
import tn.esprit.Entity.Resource;
import tn.esprit.Repository.EventRepository;
import tn.esprit.Repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@RestController
@CrossOrigin(origins="*")
public class MainController {

    @Autowired
    EventRepository er;

    @Autowired
    ResourceRepository rr;

    @RequestMapping("/api")
    @ResponseBody
    String home() {
        return "Welcome!";
    }

    @RequestMapping("/api/resources")
    Iterable<Resource> resources() {
        return rr.findAll();
    }

    @GetMapping("/api/events")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    Iterable<Event> events(@RequestParam("from") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime from, @RequestParam("to") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime to) {
        return er.findBetween(from, to);
    }

    @PostMapping("/api/events/create")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Transactional
    Event createEvent(@RequestBody EventCreateParams params) {

        Resource r = rr.findById(params.resource).get();

        Event e = new Event();
        e.setStart(params.start);
        e.setEnd(params.end);
        e.setText(params.text);
        e.setResource(r);

        er.save(e);

        return e;
    }

    @PostMapping("/api/events/move")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Transactional
    Event moveEvent(@RequestBody EventMoveParams params) {

        Event e = er.findById(params.id).get();
        Resource r = rr.findById(params.resource).get();

        e.setStart(params.start);
        e.setEnd(params.end);
        e.setResource(r);

        er.save(e);

        return e;
    }

    @PostMapping("/api/events/delete")
    @Transactional
    void deleteEvent(@RequestBody EventDeleteParams params) {
        er.deleteById(params.id);
    }

    public static class EventCreateParams {
        public LocalDateTime start;
        public LocalDateTime end;
        public String text;
        public Long resource;
    }

    public static class EventMoveParams {
        public Long id;
        public LocalDateTime start;
        public LocalDateTime end;
        public Long resource;
    }

    public static class EventDeleteParams {
        public Long id;
    }

}