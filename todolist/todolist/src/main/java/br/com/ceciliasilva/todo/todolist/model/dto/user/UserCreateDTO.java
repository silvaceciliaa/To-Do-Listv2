package br.com.ceciliasilva.todo.todolist.model.dto.user;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDTO {

    @NotBlank(message = "Username deve ser informado")
    private String username;

    @NotBlank(message = "Nome deve ser informado")
    private String nome;

    @ToString.Exclude
    @NotBlank(message = "Senha deve ser informada")
    private String senha;
}