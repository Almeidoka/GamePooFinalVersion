package ifpr.paranavai.jogo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ifpr.paranavai.jogo.conexao.HibernateUtil;
import ifpr.paranavai.jogo.modelo.Asteroide;

public class AsteroideDAOImpl implements AsteroideDAO{
    
    @Override
    public Asteroide buscarPorId(int id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(Asteroide.class, id);
        }
    }

    @Override
    public List<Asteroide> listarTodos() {
        try (Session session = HibernateUtil.getSession()) {
            Query<Asteroide> query = session.createQuery("FROM Asteroide", Asteroide.class);
            return query.list();
        }
    }

    @Override
    public void inserir(Asteroide Asteroide) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(Asteroide);
            transaction.commit();
        }
    }

    @Override
    public void atualizar(Asteroide Asteroide) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(Asteroide);
            transaction.commit();
        }
    }

    @Override
    public void deletar(int id) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            Asteroide asteroide = session.get(Asteroide.class, id);
            if (asteroide != null) {
                session.delete(asteroide);
            }
            transaction.commit();
        }
    }
}