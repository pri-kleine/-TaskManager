package ProjetoFinal.Domain;

public class PersonalTask extends BaseTask {
    String tipo;

    public PersonalTask(String nome, String status, Integer prioridade, String tipo) {
        super(nome, status, prioridade);
        this.tipo = tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "PersonalTask{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", status='" + status + '\'' +
                ", prioridade=" + prioridade +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
