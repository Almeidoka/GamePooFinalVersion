package ifpr.paranavai.jogo.dao;

import java.util.List;
import ifpr.paranavai.jogo.modelo.Inimigo;

public interface InimigoDAO {
    Inimigo buscarPorId(int id);
    List<Inimigo> listarTodos();
    void inserir(Inimigo Inimigo);
    void atualizar(Inimigo Inimigo);
    void deletar(int id);
}
