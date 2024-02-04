package ProjetoFinal.Domain;

public class BaseTask {
    private static Integer serial = 0;
    Integer id;
    String nome;
    String status;
    Integer prioridade;

    public BaseTask(String nome, String status, Integer prioridade) {
        this.nome = nome;
        this.status = status;
        this.prioridade = prioridade;
        this.id = ++serial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", status='" + status + '\'' +
                ", prioridade=" + prioridade +
                '}';
    }
}
