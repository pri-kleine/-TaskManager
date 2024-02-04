package ProjetoFinal.Repository;


import java.util.List;

public interface RepositoryInterface<T> {
    void create(T t);

    List<T> read();

    void update(Integer id, T task);

    void delete(Integer id);
}
