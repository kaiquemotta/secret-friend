package br.com.secret.friend.mapper;


import br.com.secret.friend.dto.EventDto;
import br.com.secret.friend.dto.UserDto;
import br.com.secret.friend.entity.Event;
import br.com.secret.friend.entity.User;

import java.time.LocalDateTime;

public class EventMapper {

    public static EventDto mapToEventDto(Event event) {
        return new EventDto(
                event.getId(),
                event.getDate(),
                event.getDataCreated(),
                event.getDataUpdeted(),
                event.getAdress(),
                event.getUsers());

    }

    public static Event mapToEvent(EventDto eventDto,boolean creat) {
        return new Event(
                eventDto.getId(),
                eventDto.getDate(),
                creat ? LocalDateTime.now().toString():eventDto.getDataUpdated(),
                creat ? LocalDateTime.now().toString():eventDto.getDataCreated(),
                eventDto.getAdress(),
                eventDto.getUsers());

    }
}
