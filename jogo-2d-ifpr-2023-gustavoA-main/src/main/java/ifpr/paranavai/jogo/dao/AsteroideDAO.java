package ifpr.paranavai.jogo.dao;

import java.util.List;
import ifpr.paranavai.jogo.modelo.Asteroide;

public interface AsteroideDAO {
    Asteroide buscarPorId(int id);
    List<Asteroide> listarTodos();
    void inserir(Asteroide Asteroide);
    void atualizar(Asteroide Asteroide);
    void deletar(int id);
}