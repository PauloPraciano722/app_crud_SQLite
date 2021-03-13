package br.com.androidsqlitecrud.metodo;

import java.util.List;

import br.com.androidsqlitecrud.model.Crud;

public interface MetodoCrud {
    //metodos que serao implementados de forma automatica no DaoCliente
    //Assim que a classe for implmentada
    public boolean createCrud(Crud create);
    public boolean updateCrud(Crud alterar);
    public boolean deleteCrud(Crud excluir);
    public List<Crud> listarCrud();
}
