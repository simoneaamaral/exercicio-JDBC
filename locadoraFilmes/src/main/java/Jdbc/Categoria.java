package Jdbc;

import java.math.BigDecimal;

public class Categoria {

    private int cod_cat;
    private String nome;
    private BigDecimal valor;

    public Categoria(){

    }

    public Categoria(int cod_cat, String nome, BigDecimal valor) {
        this.cod_cat = cod_cat;
        this.nome = nome;
        this.valor = valor;
    }

    public Categoria(int cod_cat, String nome) {
        this.cod_cat = cod_cat;
        this.nome = nome;
    }

    public int getCod_cat() {
        return cod_cat;
    }

    public void setCod_cat(int cod_cat) {
        this.cod_cat = cod_cat;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Categoria " +
                "Código categoria = " + cod_cat +
                ", Nome = " + nome +
                ", Valor = " + valor;
    }
}
