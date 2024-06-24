package Jdbc;

public class Filmes {

    private int cod_filme;
    private String titulo_original;
    private String titulo;
    private int quantidade;
    private int fkcod_cat;
    private int fkcod_gen;

    public Filmes(){

    }

    public Filmes(int cod_filme, String titulo_original, String titulo, int quantidade, int fkcod_cat, int fkcod_gen) {
        this.cod_filme = cod_filme;
        this.titulo_original = titulo_original;
        this.titulo = titulo;
        this.quantidade = quantidade;
        this.fkcod_cat = fkcod_cat;
        this.fkcod_gen = fkcod_gen;
    }

    public int getCod_filme() {
        return cod_filme;
    }

    public void setCod_filme(int cod_filme) {
        this.cod_filme = cod_filme;
    }

    public String getTitulo_original() {
        return titulo_original;
    }

    public void setTitulo_original(String titulo_original) {
        this.titulo_original = titulo_original;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getFkcod_cat() {
        return fkcod_cat;
    }

    public void setFkcod_cat(int fkcod_cat) {
        this.fkcod_cat = fkcod_cat;
    }

    public int getFkcod_gen() {
        return fkcod_gen;
    }

    public void setFkcod_gen(int fkcod_gen) {
        this.fkcod_gen = fkcod_gen;
    }

    @Override
    public String toString() {
        return "Filmes " +
                "Código filme = " + cod_filme +
                ", Título original = " + titulo_original +
                ", Título = " + titulo +
                ", Quantidade = " + quantidade +
                ", FK Código categoria = " + fkcod_cat +
                ", FK Código gênero = " + fkcod_gen;
    }
}
