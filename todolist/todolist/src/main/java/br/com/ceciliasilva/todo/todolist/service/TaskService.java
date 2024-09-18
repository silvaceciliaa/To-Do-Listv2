package br.com.ceciliasilva.todo.todolist.service;

import br.com.ceciliasilva.todo.todolist.exceptions.EntidadeNaoEncontradaException;
import br.com.ceciliasilva.todo.todolist.exceptions.RegraDeNegocioException;
import br.com.ceciliasilva.todo.todolist.model.dto.task.*;
import br.com.ceciliasilva.todo.todolist.model.entity.Task;
import br.com.ceciliasilva.todo.todolist.repository.TaskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ObjectMapper objectMapper;

    public TaskResponseDTO adicionar(TaskCreateDTO taskRequestDTO) throws RegraDeNegocioException {

        validarData(taskRequestDTO.getTerminarEm(), taskRequestDTO.getIniciarEm());
        Task taskEntity = converterDTO(taskRequestDTO);
        taskEntity.setCriadoEm(Timestamp.valueOf(LocalDateTime.now()));

        return retornarDTO(taskRepository.save(taskEntity));
    }

    public List<TaskResponseDTO> listarTodasDoUsuario(Integer idUsuario) throws EntidadeNaoEncontradaException {
        List<Task> taskList = taskRepository.findByIdUser(idUsuario);

        if(taskList.isEmpty()){
            throw new EntidadeNaoEncontradaException("Não há nenhuma tarefa!");
        }

        return taskList.stream()
                .map(this::retornarDTO)
                .toList();

    }

    public TaskResponseDTO atualizar(Integer idTask, TaskUpdateDTO taskUpdateDTO) throws Exception {

        Task taskAtualizar = retornarTask(idTask);

        Optional.ofNullable(taskUpdateDTO.getTitulo()).ifPresent(taskAtualizar::setTitulo);
        Optional.ofNullable(taskUpdateDTO.getDescricao()).ifPresent(taskAtualizar::setDescricao);
        Optional.ofNullable(taskUpdateDTO.getTerminarEm()).ifPresent(taskAtualizar::setTerminarEm);
        Optional.ofNullable(taskUpdateDTO.getIniciarEm()).ifPresent(taskAtualizar::setIniciarEm);
        Optional.ofNullable(taskUpdateDTO.getPrioridade()).ifPresent(taskAtualizar::setPrioridade);

        return retornarDTO(taskRepository.save(taskAtualizar));
    }


    public Task converterDTO(TaskCreateDTO dto){
        return objectMapper.convertValue(dto, Task.class);
    }

    public TaskResponseDTO retornarDTO(Task entity){
        return objectMapper.convertValue(entity, TaskResponseDTO.class);
    }

    public Task retornarTask(Integer idTask) throws Exception{
        return taskRepository.findById(idTask)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Nenhuma tarefa encontrada com o id " + idTask));
    }

    private void validarData(LocalDateTime terminarEm, LocalDateTime iniciarEm) throws RegraDeNegocioException{
        if(iniciarEm.isBefore(LocalDateTime.now())){
            throw new RegraDeNegocioException("Data de início incorreta");
        }
        if(terminarEm.isBefore(LocalDateTime.now())){
            throw new RegraDeNegocioException("Data final incorreta");
        }
        if(terminarEm.isBefore(iniciarEm)) {
            throw new RegraDeNegocioException("Data final não pode ser menor do que a data de início");
        }
    }
}
