package br.com.ceciliasilva.todo.todolist.model.entity;

import java.security.Timestamp;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer idUsuario;

    private String username;

    private String nome;

    private String senha;

    private Timestamp criadoEm;

}
