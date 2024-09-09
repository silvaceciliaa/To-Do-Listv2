package br.com.ceciliasilva.todo.todolist.model.dto.task;

import br.com.ceciliasilva.todo.todolist.model.entity.User;
import br.com.ceciliasilva.todo.todolist.model.enums.TipoPrioridade;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreateDTO {

    @NotBlank(message = "Um título deve ser informado")
    private String titulo;

    private String descricao;

    private LocalDateTime iniciarEm;

    private LocalDateTime terminarEm;

    private Timestamp criadoEm;

    private TipoPrioridade prioridade;

    private User user;
}
