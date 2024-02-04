package ProjetoFinal.Service;

import ProjetoFinal.Domain.BaseTask;
import ProjetoFinal.Repository.TaskRepository;

import java.util.List;

public class TaskService {
    private final TaskRepository repository;

    public TaskService() {
        this.repository = new TaskRepository();
    }

    public void salvarNovaTask(BaseTask task) {
        repository.create(task);
    }

    public List<BaseTask> listTasks() {
        // Obtenho a lista
        return this.repository.read();
    }

    public BaseTask listOneTask(Integer id) {
        // Obtenho uma tarefa específica
        List<BaseTask> list = this.repository.read();
        for (BaseTask task1 : list) {
            if (task1.getId().equals(id)) {
                return task1;
            }
        }
        return null;
    }

    public void updateTask(Integer id, BaseTask task) {
        this.repository.update(id, task);
    }

    public void deleteTask(Integer id) {
        this.repository.delete(id);
    }
}
