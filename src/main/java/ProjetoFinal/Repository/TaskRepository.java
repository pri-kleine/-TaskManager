package ProjetoFinal.Repository;

import ProjetoFinal.Domain.BaseTask;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository implements RepositoryInterface<BaseTask> {

    List<BaseTask> lista;

    public TaskRepository() {
        this.lista = (new ArrayList<>());
    }

    public void create(BaseTask task) {
        System.out.println("Salvando a tarefa...");
        lista.add(task);
    }

    @Override
    public List<BaseTask> read() {
        return this.lista;
    }

    @Override
    public void update(Integer id, BaseTask task) {
        for (int i = 0; i < this.lista.size(); i++) {
            if (this.lista.get(i).getId().equals(id)) {
                this.lista.set(i, task);
                System.out.println("Atualizando a tarefa...");
                break;
            }
        }
    }

    @Override
    public void delete(Integer id) {
        for (int i = 0; i < this.lista.size(); i++) {
            if (this.lista.get(i).getId().equals(id)) {
                this.lista.remove(i);
                System.out.println("Removendo a tarefa...");
                break;
            }
        }
    }
}
