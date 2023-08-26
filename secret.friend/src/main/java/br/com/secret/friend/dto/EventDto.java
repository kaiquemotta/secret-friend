package br.com.secret.friend.dto;

import br.com.secret.friend.entity.Adress;
import br.com.secret.friend.entity.User;
import br.com.secret.friend.entity.UserEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    private String id;
    private String date;
    private String dataCreated;
    private String dataUpdated;
    private Adress adress;
    private List<UserEvent> users;

}
