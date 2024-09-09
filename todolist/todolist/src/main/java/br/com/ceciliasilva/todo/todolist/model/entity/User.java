package br.com.ceciliasilva.todo.todolist.model.entity;

import java.security.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "USER")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USERS")
    @SequenceGenerator(name = "SEQ_USERS", sequenceName = "seq_users", allocationSize = 1)
    @Column(name = "id_user")
    private Integer idUsuario;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String nome;

    @Column(name = "password")
    private String senha;

    @Column(name = "created_on")
    private Timestamp criadoEm;

}
