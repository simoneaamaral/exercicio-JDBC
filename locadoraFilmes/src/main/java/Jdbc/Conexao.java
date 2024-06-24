package Jdbc;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Conexao {
    private static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String user = "postgres";
    private static String password = "POSTGRES";
    private static Connection conexao;

    public static Connection getConnection() {
        try {
            if(conexao == null || conexao.isClosed()) {
                conexao = DriverManager.getConnection(url, user, password);
                System.out.println("Conectado ao Postgres");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados");
            throw new RuntimeException(e);
        }
        return conexao;
    }

    public static List<Endereco> getAllEndereco(){
        PreparedStatement ps = null; //preparando uma query
        Endereco endereco = new Endereco();
        List<Endereco> enderecos = new ArrayList<Endereco>();
        try {
            ps = conexao.prepareStatement("select * from Endereco order by cod_end");
            ResultSet rs = ps.executeQuery(); //receber os resultados
            while(rs.next()) {
                endereco = new Endereco();
                endereco.setCod_end(rs.getInt("cod_end"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setTipo_log(rs.getString("tipo_log"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setUf(rs.getString("uf"));
                endereco.setCep(rs.getString("cep"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setBairro(rs.getString("bairro"));
                enderecos.add(endereco);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return enderecos;

    }

    public static Endereco getEndereco(int cod_end){
        PreparedStatement ps = null;
        Endereco endereco = null;
        try {
            ps = conexao.prepareStatement("select * from Endereco where cod_end=?");
            ps.setInt(1, cod_end);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                endereco = new Endereco();
                endereco.setCod_end(rs.getInt("cod_end"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setTipo_log(rs.getString("tipo_log"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setUf(rs.getString("uf"));
                endereco.setCep(rs.getString("cep"));
                endereco.setNumero(rs.getString("numero"));
                endereco.setBairro(rs.getString("bairro"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return endereco;
    }

    public static int insertEndereco(Endereco endereco){
        PreparedStatement ps = null;
        try {
            ps = conexao.prepareStatement("INSERT INTO Endereco (cod_end, logradouro, tipo_log, complemento, cidade, uf, cep, numero, bairro) values (?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, endereco.getCod_end());
            ps.setString(2, endereco.getLogradouro());
            ps.setString(3, endereco.getTipo_log());
            ps.setString(4, endereco.getComplemento());
            ps.setString(5, endereco.getCidade());
            ps.setString(6, endereco.getUf());
            ps.setString(7, endereco.getCep());
            ps.setString(8, endereco.getNumero());
            ps.setString(9, endereco.getBairro());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int updateEndereco(Endereco endereco){
        PreparedStatement ps = null;
        try {
            ps = conexao.prepareStatement("UPDATE Endereco SET logradouro=?, tipo_log=?, complemento=?, cidade=?, uf=?, cep=?, numero=?, bairro=? WHERE cod_end=?");
            ps.setString(1, endereco.getLogradouro());
            ps.setString(2, endereco.getTipo_log());
            ps.setString(3, endereco.getComplemento());
            ps.setString(4, endereco.getCidade());
            ps.setString(5, endereco.getUf());
            ps.setString(6, endereco.getCep());
            ps.setString(7, endereco.getNumero());
            ps.setString(8, endereco.getBairro());
            ps.setInt(9, endereco.getCod_end());
            return ps.executeUpdate(); //retorna o valor de linhas afetadas
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int deleteEndereco(int cod_end){
        PreparedStatement ps = null;
        try {
            ps = conexao.prepareStatement("DELETE FROM Endereco WHERE cod_end=?");
            ps.setInt(1, cod_end);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Categoria> getAllCategoria(){
        PreparedStatement ps = null; //preparando uma query
        Categoria categoria = new Categoria();
        List<Categoria> categorias = new ArrayList<Categoria>();
        try {
            ps = conexao.prepareStatement("select * from Categoria order by cod_cat");
            ResultSet rs = ps.executeQuery(); //receber os resultados
            while(rs.next()) {
                categoria = new Categoria();
                categoria.setCod_cat(rs.getInt("cod_cat"));
                categoria.setNome(rs.getString("nome"));

                // Limpar o valor do tipo money antes de convertê-lo
                String moneyValor = rs.getString("valor");
                if (moneyValor != null) { //verifique se moneyValor não é null. Se for, defina o valor da categoria como null*/
                    BigDecimal valor = new BigDecimal(moneyValor.replaceAll("[^\\d,]", "").replace(",", "."));
                    /*expressão regular para substituir todos os caracteres que não são dígitos ou vírgulas por uma string vazia ("")
                    remove todos os caracteres que não são números ou vírgulas da string.
                    Depois de remover os caracteres não numéricos, a vírgula é substituída por um ponto.*/
                    categoria.setValor(valor);
                } else {
                    categoria.setValor(null);
                }
                categorias.add(categoria);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categorias;

    }

    public static Categoria getCategoria(int cod_cat){
        PreparedStatement ps = null;
        Categoria categoria = null;
        try {
            ps = conexao.prepareStatement("select * from Categoria where cod_cat=?");
            ps.setInt(1, cod_cat);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                categoria = new Categoria();
                categoria.setCod_cat(rs.getInt("cod_cat"));
                categoria.setNome(rs.getString("nome"));
                String moneyValor = rs.getString("valor");
                if (moneyValor != null) {
                    BigDecimal valor = new BigDecimal(moneyValor.replaceAll("[^\\d,]", "").replace(",", "."));
                    categoria.setValor(valor);
                } else {
                    categoria.setValor(null);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoria;
    }

    public static int insertCategoria(Categoria categoria){
        PreparedStatement ps = null;
        try {
            ps = conexao.prepareStatement("INSERT INTO Categoria (cod_cat, nome, valor) values (?,?,?)");
            ps.setInt(1, categoria.getCod_cat());
            ps.setString(2, categoria.getNome());
            ps.setBigDecimal(3, categoria.getValor());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int updateCategoria(Categoria categoria){
        PreparedStatement ps = null;
        try {
            ps = conexao.prepareStatement("UPDATE Categoria SET nome=?, valor=? WHERE cod_cat=?");
            ps.setString(1, categoria.getNome());
            ps.setBigDecimal(2, categoria.getValor());
            ps.setInt(3, categoria.getCod_cat());
            return ps.executeUpdate(); //retorna o valor de linhas afetadas
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int deleteCategoria(int cod_cat){
        PreparedStatement ps = null;
        try {
            ps = conexao.prepareStatement("DELETE FROM Categoria WHERE cod_cat=?");
            ps.setInt(1,cod_cat);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Genero> getAllGenero(){
        PreparedStatement ps = null; //preparando uma query
        Genero genero = new Genero();
        List<Genero> generos = new ArrayList<Genero>();
        try {
            ps = conexao.prepareStatement("select * from Genero order by cod_gen");
            ResultSet rs = ps.executeQuery(); //receber os resultados
            while(rs.next()) {
                genero = new Genero();
                genero.setCod_gen(rs.getInt("cod_gen"));
                genero.setNome(rs.getString("nome"));
                generos.add(genero);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return generos;

    }

    public static Genero getGenero(int cod_gen){
        PreparedStatement ps = null;
        Genero genero = null;
        try {
            ps = conexao.prepareStatement("select * from Genero where cod_gen=?");
            ps.setInt(1, cod_gen);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                genero = new Genero();
                genero.setCod_gen(rs.getInt("cod_gen"));
                genero.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return genero;
    }

    public static int insertGenero(Genero genero){
        PreparedStatement ps = null;
        try {
            ps = conexao.prepareStatement("INSERT INTO Genero (cod_gen, nome) values (?,?)");
            ps.setInt(1, genero.getCod_gen());
            ps.setString(2, genero.getNome());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int updateGenero(Genero genero){
        PreparedStatement ps = null;
        try {
            ps = conexao.prepareStatement("UPDATE Genero SET nome=? WHERE cod_gen=?");
            ps.setString(1, genero.getNome());
            ps.setInt(2, genero.getCod_gen());
            return ps.executeUpdate(); //retorna o valor de linhas afetadas
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int deleteGenero(int cod_gen){
        PreparedStatement ps = null;
        try {
            ps = conexao.prepareStatement("DELETE FROM Genero WHERE cod_gen=?");
            ps.setInt(1, cod_gen);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Filmes> getAllFilmes(){
        PreparedStatement ps = null; //preparando uma query
        Filmes filme = new Filmes();
        List<Filmes> filmes = new ArrayList<Filmes>();
        try {
            ps = conexao.prepareStatement("select * from Filmes order by cod_filme");
            ResultSet rs = ps.executeQuery(); //receber os resultados
            while(rs.next()) {
                filme = new Filmes();
                filme.setCod_filme(rs.getInt("cod_filme"));
                filme.setTitulo_original(rs.getString("titulo_original"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setQuantidade(rs.getInt("quantidade"));
                filme.setFkcod_cat(rs.getInt("fkcod_cat"));
                filme.setFkcod_gen(rs.getInt("fkcod_gen"));
                filmes.add(filme);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return filmes;

    }

    public static Filmes getFilme(int cod_filme){
        PreparedStatement ps = null;
        Filmes filme = null;
        try {
            ps = conexao.prepareStatement("select * from Filmes where cod_filme=?");
            ps.setInt(1, cod_filme);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                filme = new Filmes();
                filme.setCod_filme(rs.getInt("cod_filme"));
                filme.setTitulo_original(rs.getString("titulo_original"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setQuantidade(rs.getInt("quantidade"));
                filme.setFkcod_cat(rs.getInt("fkcod_cat"));
                filme.setFkcod_gen(rs.getInt("fkcod_gen"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return filme;
    }

    public static int insertFilmes(Filmes filme){
        PreparedStatement ps = null;
        try {
            ps = conexao.prepareStatement("INSERT INTO Filmes (cod_filme, titulo_original, titulo, quantidade, fkcod_cat, fkcod_gen) values (?,?,?,?,?,?)");
            ps.setInt(1, filme.getCod_filme());
            ps.setString(2, filme.getTitulo_original());
            ps.setString(3, filme.getTitulo());
            ps.setInt(4, filme.getQuantidade());
            ps.setInt(5, filme.getFkcod_cat());
            ps.setInt(6, filme.getFkcod_gen());
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int updateFilmes(Filmes filme){
        PreparedStatement ps = null;
        try {
            ps = conexao.prepareStatement("UPDATE Filmes SET titulo_original=?, titulo=?, quantidade=?, fkcod_cat=?, fkcod_gen=? WHERE cod_filme=?");
            ps.setString(1, filme.getTitulo_original());
            ps.setString(2, filme.getTitulo());
            ps.setInt(3, filme.getQuantidade());
            ps.setInt(4, filme.getFkcod_cat());
            ps.setInt(5, filme.getFkcod_gen());
            ps.setInt(6, filme.getCod_filme());
            return ps.executeUpdate(); //retorna o valor de linhas afetadas
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int deleteFilmes(int cod_filme){
        PreparedStatement ps = null;
        try {
            ps = conexao.prepareStatement("DELETE FROM Filmes WHERE cod_filme=?");
            ps.setInt(1, cod_filme);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection() {
        try {
            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
                System.out.println("Desconectado ao banco de dados");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }






}
