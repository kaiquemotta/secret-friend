package br.com.secret.friend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserEvent {

    public String idEvent;
    public String idUser;
}
