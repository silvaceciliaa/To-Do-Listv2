package br.com.ceciliasilva.todo.todolist.repository;

import br.com.ceciliasilva.todo.todolist.model.entity.Task;
import br.com.ceciliasilva.todo.todolist.model.enums.TipoPrioridade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByIdUser (Integer idUser);

    List<Task> findByIdUserAndPrioridade(Integer idUser, TipoPrioridade prioridade);

    List<Task> findByIdUserAndFeitoIsTrue(Integer idUser);

}
