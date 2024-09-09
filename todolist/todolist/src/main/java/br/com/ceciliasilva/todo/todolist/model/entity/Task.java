package br.com.ceciliasilva.todo.todolist.model.entity;

import br.com.ceciliasilva.todo.todolist.model.enums.TipoPrioridade;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TASK")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TASK")
    @SequenceGenerator(name = "SEQ_TASK", sequenceName = "seq_task", allocationSize = 1)
    @Column(name = "id_task")
    private String idTarefa;

    @Column(name = "title")
    private String titulo;

    @Column(name = "description")
    private String descricao;

    @Column(name = "start_at")
    private LocalDateTime iniciarEm;

    @Column(name = "end_at")
    private LocalDateTime terminarEm;

    @Column(name = "created_on")
    private Timestamp criadoEm;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "priority")
    private TipoPrioridade prioridade;

    @Column(name = "id_user", insertable = false, updatable = false)
    private Integer idUser;
}
