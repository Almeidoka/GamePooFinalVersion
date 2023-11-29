package ifpr.paranavai.jogo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ifpr.paranavai.jogo.conexao.HibernateUtil;
import ifpr.paranavai.jogo.modelo.TiroSuper;

public class TiroSuperDAOImpl implements TiroSuperDAO{
    @Override
    public TiroSuper buscarPorId(int id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(TiroSuper.class, id);
        }
    }

    @Override
    public void deletar(int id) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            TiroSuper superTiro = session.get(TiroSuper.class, id);
            if (superTiro != null) {
                session.delete(superTiro);
            }
            transaction.commit();
        }
    }

    @Override
    public List<TiroSuper> listarTodos() {
        try (Session session = HibernateUtil.getSession()) {
            Query<TiroSuper> query = session.createQuery("FROM SuperTiro", TiroSuper.class);
            return query.list();
        }
    }

    @Override
    public void inserir(TiroSuper SuperTiro) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(SuperTiro);
            transaction.commit();
        }
    }

    @Override
    public void atualizar(TiroSuper SuperTiro) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(SuperTiro);
            transaction.commit();
        }
    }
}