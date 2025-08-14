package br.fiap.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private final static String URL = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private final static String USER = "RM557834";
    private final static String PASSWORD = "270306";

    private Conexao(){}


    public static Connection conectar() {
        try{
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch(SQLException e){
            System.out.println("Erro ao conectar no banco\n"+e);
        }
        return null;
    }


}
