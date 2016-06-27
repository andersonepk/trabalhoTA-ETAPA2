package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Pessoa;
import java.io.Serializable;
import javax.ejb.Stateless;

@Stateless
public class PessoaDAO<T> extends DAOGenerico<Pessoa> implements Serializable {
 
    public PessoaDAO() {
        super();
        super.setClassePersistente(Pessoa.class);
        super.setOrdem("nome");
    }
    
    @Override
    public Pessoa getObjectById(Integer id) throws Exception {
        Pessoa obj = (Pessoa) super.getEm().find(super.getClassePersistente(), id);
        // inicializando a coleção de objetos para não ocorrer lazy exception
        obj.getReservam().size(); 
        
        return obj;
    } 
    
}