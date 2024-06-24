package Jdbc;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Conexao.getConnection();
        System.out.println();

        //Exercício 1
        //Conexao.insertEndereco(new Endereco(13,"Rua Comendador José Garcia","Rua","Comercial","Pouso Alegre","MG","37555-100","561","Centro"));

        //Exercício 2
        //Conexao.insertCategoria(new Categoria(13,"Religiosos",new BigDecimal("11.90")));

        //Exercício 3
        //Conexao.insertGenero(new Genero(11,"Infantil"));

        //Exercício 4
        /*List<Endereco> enderecos = new ArrayList<>();
        enderecos = Conexao.getAllEndereco();
        for (Endereco endereco : enderecos){
            System.out.println(endereco);
        }*/

        //Exercício 5
        /*List<Categoria> categorias = new ArrayList<>();
        categorias = Conexao.getAllCategoria();
        for (Categoria categoria : categorias){
            System.out.println(categoria);
        }*/

        //Exercício 6
        /*List<Genero> generos = new ArrayList<>();
        generos = Conexao.getAllGenero();
        for (Genero genero : generos) {
            System.out.println(genero);
        }*/

        //Exercício 7
        //Conexao.insertFilmes(new Filmes(16,"Seven Pounds","Sete Vidas",10,1,3));

        //Exercício 8
        /*List<Filmes> filmes = new ArrayList<>();
        filmes = Conexao.getAllFilmes();
        for (Filmes filme : filmes) {
            System.out.println(filme);
        }*/

        //Extra
        //Conexao.deleteCategoria(12);
        //Conexao.updateCategoria(new Categoria(5,"Filmes de Cinema Nacional"));
        //System.out.println(Conexao.getCategoria(13));

        //Conexao.closeConnection(); //desconecta conexão









    }
}
