package br.fiap.modelo;

import br.fiap.conexao.Conexao;
import sun.security.krb5.internal.crypto.Des;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DespesaDAO {
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;

    public void inserir(Despesa despesa){
        sql ="insert into java_despesa values (seqd.nextval,?,?,?,?)";
        try (Connection connection =Conexao.conectar()){
            ps= connection.prepareStatement(sql);
//            ps.setLong(1,despesa.getId());
            ps.setString(1,despesa.getDescricao());
            ps.setDouble(2, despesa.getValor());
            ps.setDate(3, Date.valueOf((despesa.getData())));
            ps.setLong(4, despesa.getCategoria().getId());
            ps.execute();
        }catch (SQLException e){
            System.out.println("erro ao inserir despesas\n"+e);
        }
    }

    public void atualizar (Despesa despesa){

    }

    public List<Despesa> listar(){
        List<Despesa>lista = new ArrayList<>();
        sql ="select * from java_despesa";
        try(Connection connection = Conexao.conectar()){
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Despesa despesa = new Despesa();
                despesa.setId(rs.getLong("id_despesa"));
                despesa.setDescricao(rs.getString("descricao"));
                despesa.setValor(rs.getDouble("valor"));
                despesa.setCategoria(new Categoria(rs.getLong("id_categoria"),""));
                despesa.setData(rs.getDate("data").toLocalDate());
                lista.add(despesa);

            }
        }catch (SQLException e){
            System.out.println("erro ao listar as despesas\n"+e);
        }
        return lista;
    }

    public void excluir(){

    }

    public List<Despesa> relatorio(){
        List<Despesa>relatorio= new ArrayList<>();
        sql = "SELECT d.descricao, d.valor, d.data, c.categoria \n" +
                "from JAVA_DESPESA d  \n" +
                "inner join java_categoria c\n" +
                "on d.id_categoria = c.id_categoria ";
        try (Connection connection = Conexao.conectar()) {
            ps=connection.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Despesa despesa = new Despesa();
                despesa.setDescricao(rs.getString("Descrição"));
                despesa.setValor(rs.getDouble("valor"));
                despesa.setCategoria(new Categoria(0L,rs.getString("CATEGORIA")));
                relatorio.add(despesa);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao gerar relatorio\n"+e);
        }

        return relatorio;
    }

}






