package br.com.secret.friend.service.impl;

import br.com.secret.friend.dto.AddUserEvent;
import br.com.secret.friend.dto.EventDto;
import br.com.secret.friend.dto.UserDto;
import br.com.secret.friend.entity.Event;
import br.com.secret.friend.entity.User;
import br.com.secret.friend.entity.UserEvent;
import br.com.secret.friend.mapper.EventMapper;
import br.com.secret.friend.mapper.UserMapper;
import br.com.secret.friend.repository.EventRepository;
import br.com.secret.friend.repository.UserRepository;
import br.com.secret.friend.service.EventService;
import br.com.secret.friend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;

    @Override
    public Mono<EventDto> saveEvent(EventDto eventDto) {
        Event user = EventMapper.mapToEvent(eventDto,true);
        Mono<Event> eventUser = eventRepository.save(user);
        return eventUser.map(EventMapper::mapToEventDto);
    }

    @Override
    public Mono<EventDto> getEvent(String eventId) {
        Mono<Event> userMono = eventRepository.findById(eventId);
        return userMono.map(EventMapper::mapToEventDto);
    }

    @Override
    public Flux<EventDto> getAllEvents() {
        Flux<Event> userFlux = eventRepository.findAll();
        return userFlux.map(EventMapper::mapToEventDto);
    }

    @Override
    public Mono<EventDto> updateEvent(EventDto eventDto, String eventId) {
        Mono<Event> eventMono = eventRepository.findById(eventId);
        return eventMono.flatMap((eventExisting) -> {
            eventExisting.setDate(eventDto.getDate());
            eventExisting.setDataUpdeted(LocalDateTime.now().toString());
            eventExisting.setAdress(eventDto.getAdress());
            eventExisting.setUsers(eventDto.getUsers());
            return eventRepository.save(eventExisting);
        }).map(EventMapper::mapToEventDto);

    }


    @Override
    public Mono<Void> deleteEvent(String eventId) {
        return eventRepository.deleteById(eventId);
    }

    @Override
    public Mono<EventDto> addUserEvent(AddUserEvent addUserEvent) {
        Mono<Event> eventMono = eventRepository.findById(addUserEvent.getIdEvent());
        Event event = eventMono.block();
        event.getUsers().add(UserEvent.builder().id(addUserEvent.getIdUser()).build());
        Mono<Event> eventUser = eventRepository.save(event);
        return eventUser.map(EventMapper::mapToEventDto);
    }

//    public Mono<EventDto> monoToEventDTO(){
//
//    }
}
