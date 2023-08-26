package br.com.secret.friend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "event")
public class Event {

    @Id
    private String id;
    private String date;
    private String dataCreated;
    private String dataUpdeted;
    private Adress adress;
    private List<UserEvent> users;

}
