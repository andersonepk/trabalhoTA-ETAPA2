

package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Promocao;
import java.io.Serializable;
import javax.ejb.Stateless;

@Stateless
public class PromocaoDAO<T> extends DAOGenerico<Promocao>implements Serializable {

    public PromocaoDAO(){
        super();
        super.setClassePersistente(Promocao.class);
        super.setOrdem("descricao");// ordem padrão
    }

}
