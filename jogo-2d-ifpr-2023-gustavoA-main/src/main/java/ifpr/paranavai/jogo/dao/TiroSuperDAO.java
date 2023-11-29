package ifpr.paranavai.jogo.dao;

import java.util.List;
import ifpr.paranavai.jogo.modelo.TiroSuper;

public interface TiroSuperDAO {
    TiroSuper buscarPorId(int id);
    List<TiroSuper> listarTodos();
    void inserir(TiroSuper SuperTiro);
    void atualizar(TiroSuper SuperTiro);
    void deletar(int id);
}