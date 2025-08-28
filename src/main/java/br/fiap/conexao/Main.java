package br.fiap.conexao;

import br.fiap.modelo.Categoria;
import br.fiap.modelo.CategoriaDAO;
import br.fiap.modelo.Despesa;
import br.fiap.modelo.DespesaDAO;
import sun.security.krb5.internal.crypto.Des;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        CategoriaDAO dao = new CategoriaDAO();
        //Categoria categoria = new Categoria(4L,"moradia");
        //dao.inserir(categoria);

//        List<Categoria> lista = dao.listar();
//        for(Categoria categoria : lista){
//            System.out.println(categoria.getId()+" --> "+categoria.getCategoria());
//        }
        DespesaDAO dao = new DespesaDAO();
        List<Despesa> relatorio =dao.relatorio();
        for(Despesa d :relatorio){
            System.out.println(d.getDescricao());
            System.out.println(d.getValor());
            System.out.println(d.getData());
            System.out.println(d.getCategoria().getId());
        }
    }
}
