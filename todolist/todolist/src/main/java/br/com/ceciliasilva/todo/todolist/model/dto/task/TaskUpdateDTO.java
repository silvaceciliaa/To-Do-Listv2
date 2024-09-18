package br.com.ceciliasilva.todo.todolist.model.dto.task;

import br.com.ceciliasilva.todo.todolist.model.enums.TipoPrioridade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskUpdateDTO {

    @NotBlank(message = "Um título deve ser informado")
    private String titulo;

    private String descricao;

    @NotNull(message = "Data de início deve ser informada")
    private LocalDateTime iniciarEm;

    @NotNull(message = "Data final deve ser informada")
    private LocalDateTime terminarEm;

    @NotNull(message = "Prioridade deve ser informada")
    private TipoPrioridade prioridade;

}
