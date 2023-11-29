package ifpr.paranavai.jogo.modelo;

import java.awt.Image;
import java.awt.Rectangle;

import java.awt.Image;
import java.awt.Rectangle;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.GenerationType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "elementos_graficos")
public abstract class ElementoGrafico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_elementos_graficos")
    protected int idElementosGraficos;

    @Column(name = "posicao_X")
    private int posicaoEmX;

    @Column(name = "posicao_Y")
    private int posicaoEmY;

    @Transient
    private Image imagem;

    @Column(name = "largura_imagem")
    private int larguraImagem;

    @Column(name = "altura_imagem")
    private int alturaImagem;

    @Column(name = "ehVisivel")
    private boolean ehVisivel = true;

    public abstract void carregar();

    public abstract void atualizar();

    public Rectangle getRectangle() {
        return new Rectangle(posicaoEmX, posicaoEmY, larguraImagem, alturaImagem);
    }

    public int getPosicaoEmX() {
        return this.posicaoEmX;
    }

    public void setPosicaoEmX(int posicaoEmX) {
        this.posicaoEmX = posicaoEmX;
    }

    public int getPosicaoEmY() {
        return this.posicaoEmY;
    }

    public void setPosicaoEmY(int posicaoEmY) {
        this.posicaoEmY = posicaoEmY;
    }

    public Image getImagem() {
        return this.imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;

        this.larguraImagem = this.imagem.getWidth(null);
        this.alturaImagem = this.imagem.getHeight(null);
    }

    public int getLarguraImagem() {
        return this.larguraImagem;
    }

    public void setLarguraImagem(int larguraImagem) {
        this.larguraImagem = larguraImagem;
    }

    public int getAlturaImagem() {
        return this.alturaImagem;
    }

    public void setAlturaImagem(int alturaImagem) {
        this.alturaImagem = alturaImagem;
    }

    public boolean isEhVisivel() {
        return this.ehVisivel;
    }

    public boolean getEhVisivel() {
        return this.ehVisivel;
    }

    public void setEhVisivel(boolean ehVisivel) {
        this.ehVisivel = ehVisivel;
    }

    public int getIdElementosGraficos() {
        return this.idElementosGraficos;
    }

    public void setIdElementosGraficos(int idElementosGraficos) {
        this.idElementosGraficos = idElementosGraficos;
    }
    

}