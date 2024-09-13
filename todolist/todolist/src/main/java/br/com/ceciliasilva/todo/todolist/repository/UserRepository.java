package br.com.ceciliasilva.todo.todolist.repository;

import br.com.ceciliasilva.todo.todolist.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
