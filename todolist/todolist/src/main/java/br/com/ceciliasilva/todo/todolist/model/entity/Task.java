package br.com.ceciliasilva.todo.todolist.model.entity;

import br.com.ceciliasilva.todo.todolist.model.enums.TipoPrioridade;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    private String idTarefa;

    private String titulo;

    private String descricao;

    private LocalDateTime iniciarEm;

    private LocalDateTime terminarEm;

    private Timestamp criadoEm;

    private TipoPrioridade prioridade;

    private User user;
}
