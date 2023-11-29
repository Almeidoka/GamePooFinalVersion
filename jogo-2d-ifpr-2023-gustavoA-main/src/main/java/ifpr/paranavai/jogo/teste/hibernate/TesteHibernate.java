package ifpr.paranavai.jogo.teste.hibernate;

import ifpr.paranavai.jogo.conexao.HibernateUtil;
import ifpr.paranavai.jogo.modelo.Jogador;
import ifpr.paranavai.jogo.modelo.Personagem;

import org.hibernate.Session;

public class TesteHibernate {
    public static void main(String[] args) {
        Session sessao = HibernateUtil.getSession();
        sessao.beginTransaction();
        Jogador local = new Jogador("Almeida 4");
        Personagem p = new Personagem();
        sessao.save(p);
        sessao.save(local);
        sessao.getTransaction().commit();
        HibernateUtil.encerraSession();
    }
}