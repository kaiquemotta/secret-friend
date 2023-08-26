package br.com.secret.friend.service;

import br.com.secret.friend.dto.AddUserEvent;
import br.com.secret.friend.dto.EventDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EventService {
    Mono<EventDto> saveEvent(EventDto eventDto);

    Mono<EventDto> getEvent(String eventId);

    Flux<EventDto> getAllEvents();

    Mono<EventDto> updateEvent(EventDto eventDto, String eventId);

    Mono<Void> deleteEvent(String eventId);

    Mono<EventDto> addUserEvent(AddUserEvent addUserEvent);
}
