package ifpr.paranavai.jogo.modelo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.swing.ImageIcon;
import java.awt.Rectangle;


@Entity
@Table(name = "tb_super_tiro")
public class TiroSuper extends ElementoGrafico {

    @ManyToOne
    @JoinColumn(name = "fk_personagem")
    private Personagem personagem;
    private static int VELOCIDADE = 2;

    public TiroSuper(int posicaoPersonagemEmX, int posicaoPersonagemEmY) {
        this.carregar();
        super.setPosicaoEmX(posicaoPersonagemEmX);
        super.setPosicaoEmY(posicaoPersonagemEmY - (this.getAlturaImagem() / 2));
    }

    @Override
    public void carregar() {
        ImageIcon carregando = new ImageIcon(getClass().getResource("/imagenT.png"));
        super.setImagem(carregando.getImage());
        super.setAlturaImagem(super.getImagem().getWidth(null));
        super.setAlturaImagem(super.getImagem().getHeight(null));
        
    }

    @Override
    public void atualizar() {
        super.setPosicaoEmX(super.getPosicaoEmX() + VELOCIDADE);   
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
}