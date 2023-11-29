package ifpr.paranavai.jogo.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.swing.ImageIcon;

@Entity
@Table(name="tb_inimigos")
public class Inimigo extends ElementoGrafico {

    private static int VELOCIDADE = 2;

    public Inimigo(int xAleatorio, int yAleatorio) {
        this.carregar();
        super.setPosicaoEmX(xAleatorio);
        super.setPosicaoEmY(yAleatorio);
    }

    @Override
    public void carregar() {
        ImageIcon carregando = new ImageIcon(getClass().getResource("/inimigo.png"));
        super.setImagem(carregando.getImage());
    }

    @Override
    public void atualizar() {
        super.setPosicaoEmX(super.getPosicaoEmX() - VELOCIDADE);
    }
}
