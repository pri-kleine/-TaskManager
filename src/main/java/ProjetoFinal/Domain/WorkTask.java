package ProjetoFinal.Domain;

public class WorkTask extends BaseTask {
    String projeto;

    public WorkTask(String nome, String status, Integer prioridade, String projeto) {
        super(nome, status, prioridade);
        this.projeto = projeto;
    }

    public void setProjeto(String projeto) {
        this.projeto = projeto;
    }

    @Override
    public String toString() {
        return "WorkTask{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", projeto='" + projeto + '\'' +
                ", status='" + status + '\'' +
                ", prioridade=" + prioridade +
                '}';
    }
}

