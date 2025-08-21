package br.fiap.conexao;

import br.fiap.modelo.Categoria;
import br.fiap.modelo.Despesa;
import br.fiap.modelo.DespesaDAO;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TesteDespesa {
    public static void main(String[] args) {
        DespesaDAO dao = new DespesaDAO();
        DateTimeFormatter mascara = DateTimeFormatter.ofPattern("dd/MM/yyyy");

//        Despesa despesa = new Despesa();
//
//        despesa.setId(103L);
//        despesa.setDescricao("Monster para assistir aula de java");
//        despesa.setValor(55.00);
//        despesa.setCategoria(new Categoria(2L,""));
//        despesa.setData(LocalDate.parse("21/08/2025",mascara));
//        dao.inserir(despesa);

        List<Despesa> listar = dao.listar();
        for(Despesa despesa : listar){
            System.out.println(despesa.getId()+" -- "+despesa.getDescricao()+" -- "+despesa.getValor()+" -- "+despesa.getData()+" -- "+despesa.getCategoria());
        }
    }
}
