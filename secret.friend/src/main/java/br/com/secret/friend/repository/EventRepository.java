package br.com.secret.friend.repository;

import br.com.secret.friend.entity.Event;
import br.com.secret.friend.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EventRepository extends ReactiveCrudRepository<Event, String> {
}
