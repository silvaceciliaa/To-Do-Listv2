package br.com.ceciliasilva.todo.todolist.model.dto.user;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer idUsuario;

    private String username;

    private String nome;

    private String senha;
}