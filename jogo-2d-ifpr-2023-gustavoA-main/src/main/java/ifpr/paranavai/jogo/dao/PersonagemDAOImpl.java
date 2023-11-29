package ifpr.paranavai.jogo.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ifpr.paranavai.jogo.conexao.HibernateUtil;
import ifpr.paranavai.jogo.modelo.Personagem;

public class PersonagemDAOImpl implements PersonagemDAO{
    @Override
    public Personagem buscarPorId(int id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(Personagem.class, id);
        }
    }

    @Override
    public void deletar(int id) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            Personagem personagem = session.get(Personagem.class, id);
            if (personagem != null) {
                session.delete(personagem);
            }
            transaction.commit();
        }
    }

    @Override
    public List<Personagem> listarTodos() {
        try (Session session = HibernateUtil.getSession()) {
            Query<Personagem> query = session.createQuery("FROM Personagem", Personagem.class);
            return query.list();
        }
    }

    @Override
    public void inserir(Personagem Personagem) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(Personagem);
            transaction.commit();
        }
    }

    @Override
    public void atualizar(Personagem Personagem) {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(Personagem);
            transaction.commit();
        }
    }
}