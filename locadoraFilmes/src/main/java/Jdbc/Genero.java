package Jdbc;

public class Genero {
    private int cod_gen;
    private String nome;

    public Genero(){

    }

    public Genero(int cod_gen, String nome) {
        this.cod_gen = cod_gen;
        this.nome = nome;
    }

    public int getCod_gen() {
        return cod_gen;
    }

    public void setCod_gen(int cod_gen) {
        this.cod_gen = cod_gen;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Genero " +
                "Código gênero = " + cod_gen +
                " Nome = " + nome;
    }
}
