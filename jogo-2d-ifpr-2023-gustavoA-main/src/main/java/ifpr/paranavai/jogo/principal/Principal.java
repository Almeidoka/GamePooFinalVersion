package ifpr.paranavai.jogo.principal;

import javax.swing.JFrame;

import ifpr.paranavai.jogo.conexao.HibernateUtil;
import ifpr.paranavai.jogo.modelo.FaseUm;
import ifpr.paranavai.jogo.teste.hibernate.TesteHibernate;

public class Principal extends JFrame {
    public static final int LARGURA_DA_JANELA = 1024;
    public static final int ALTURA_DA_JANELA = 728;
    public TesteHibernate testeHibernate;

    public Principal() {
        FaseUm fase = new FaseUm();
        super.add(fase);
        super.setTitle("Jogo SpaceInvaders G.Almeida");
        super.setSize(LARGURA_DA_JANELA, ALTURA_DA_JANELA);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        super.setVisible(true);
        //testeHibernate.salvarBanco();
    }

    public static void main(String[] args) {
        new Principal();
    }

}