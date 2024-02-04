package ProjetoFinal.Domain;

public class StudyTask extends BaseTask {
    String assunto;

    public StudyTask(String nome, String status, Integer prioridade, String assunto) {
        super(nome, status, prioridade);
        this.assunto = assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    @Override
    public String toString() {
        return "StudyTask{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", assunto='" + assunto + '\'' +
                ", status='" + status + '\'' +
                ", prioridade=" + prioridade +
                '}';
    }
}
