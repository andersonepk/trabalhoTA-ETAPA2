

package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Livros;
import java.io.Serializable;
import javax.ejb.Stateless;

@Stateless
public class LivrosDAO<T> extends DAOGenerico<Livros>implements Serializable {

    public LivrosDAO(){
        super();
        super.setClassePersistente(Livros.class);
        super.setOrdem("titulo");// ordem padrão
    }

}
