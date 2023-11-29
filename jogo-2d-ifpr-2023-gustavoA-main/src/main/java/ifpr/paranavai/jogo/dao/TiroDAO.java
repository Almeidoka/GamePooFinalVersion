package ifpr.paranavai.jogo.dao;

import java.util.List;
import ifpr.paranavai.jogo.modelo.Tiro;

public interface TiroDAO {
    Tiro buscarPorId(int id);
    List<Tiro> listarTodos();
    void inserir(Tiro Tiro);
    void atualizar(Tiro Tiro);
    void deletar(int id);
}