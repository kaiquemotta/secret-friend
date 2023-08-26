package br.com.secret.friend.controller;


import br.com.secret.friend.dto.AddUserEvent;
import br.com.secret.friend.dto.EventDto;
import br.com.secret.friend.dto.UserDto;
import br.com.secret.friend.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/events")
@AllArgsConstructor
public class EventController {

    private EventService eventService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<EventDto> saveEvent(@RequestBody EventDto eventDto) {
        return eventService.saveEvent(eventDto);
    }

    @GetMapping(value = "{id}")
    public Mono<EventDto> getEvent(@PathVariable("id") String eventId) {
        return eventService.getEvent(eventId);
    }

    @GetMapping
    public Flux<EventDto> getAllEmployees() {
        return eventService.getAllEvents();
    }

    @PutMapping(value = "{id}")
    public Mono<EventDto> updateEmployee(@RequestBody EventDto eventDto, @PathVariable("id") String eventId) {
        return eventService.updateEvent(eventDto, eventId);
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteEmployee(@PathVariable("id") String eventId) {
        return eventService.deleteEvent(eventId);
    }

    @PostMapping(value = "/add-user")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<EventDto> addUserEvent(@RequestBody AddUserEvent addUserEvent) {
        return eventService.addUserEvent(addUserEvent);
    }
}
