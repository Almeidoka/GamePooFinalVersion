package ifpr.paranavai.jogo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ifpr.paranavai.jogo.conexao.HibernateUtil;
import ifpr.paranavai.jogo.modelo.Tiro;

public class TiroDAOImpl implements TiroDAO{

    @Override
    public Tiro buscarPorId(int id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(Tiro.class, id);
        }
    }

    @Override
    public void deletar(int id) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            Tiro tiro = session.get(Tiro.class, id);
            if (tiro != null) {
                session.delete(tiro);
            }
            transaction.commit();
        }
    }

    @Override
    public List<Tiro> listarTodos() {
        try (Session session = HibernateUtil.getSession()) {
            Query<Tiro> query = session.createQuery("FROM Tiro", Tiro.class);
            return query.list();
        }
    }

    @Override
    public void inserir(Tiro Tiro) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(Tiro);
            transaction.commit();
        }
    }

    @Override
    public void atualizar(Tiro Tiro) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(Tiro);
            transaction.commit();
        }
    }
}