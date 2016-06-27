

package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Genero;
import java.io.Serializable;
import javax.ejb.Stateless;

@Stateless
public class GeneroDAO<T> extends DAOGenerico<Genero>implements Serializable {

    public GeneroDAO(){
        super();
        super.setClassePersistente(Genero.class);
        super.setOrdem("descricao");// ordem padrão
    }

}
