package ifpr.paranavai.jogo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ifpr.paranavai.jogo.conexao.HibernateUtil;
import ifpr.paranavai.jogo.modelo.Inimigo;

public class InimigoDAOImpl implements InimigoDAO {

    @Override
    public Inimigo buscarPorId(int id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(Inimigo.class, id);
        }
    }

    @Override
    public void atualizar(Inimigo Inimigo) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(Inimigo);
            transaction.commit();
        }
    }

    @Override
    public List<Inimigo> listarTodos() {
        try (Session session = HibernateUtil.getSession()) {
            Query<Inimigo> query = session.createQuery("FROM Inimigo", Inimigo.class);
            return query.list();
        }
    }

    @Override
    public void inserir(Inimigo Inimigo) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(Inimigo);
            transaction.commit();
        }
    }

    @Override
    public void deletar(int id) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            Inimigo inimigo = session.get(Inimigo.class, id);
            if (inimigo != null) {
                session.delete(inimigo);
            }
            transaction.commit();
        }
    }

}
