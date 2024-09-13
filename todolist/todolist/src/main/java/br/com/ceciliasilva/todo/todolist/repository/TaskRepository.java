package br.com.ceciliasilva.todo.todolist.repository;

import br.com.ceciliasilva.todo.todolist.model.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByIdUser (Integer idUser);

    List<Task> findByIdUserAndPrioridadeEquals(Integer idUser, String prioridade);

    List<Task> findByIdUserAndFeitoIsTrue(Integer idUser);

}
