package br.com.ceciliasilva.todo.todolist.model.dto.task;

import br.com.ceciliasilva.todo.todolist.model.enums.TipoPrioridade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDTO {

    private Integer idTarefa;

    private String titulo;

    private String descricao;

    private LocalDateTime iniciarEm;

    private LocalDateTime terminarEm;

    private Timestamp criadoEm;

    private TipoPrioridade prioridade;

    private Integer user;
}
