
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.PessoaJuridica;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 */
@Stateless
public class PessoaJuridicaDAO<T> extends DAOGenerico<PessoaJuridica> implements Serializable {
 
    public PessoaJuridicaDAO() {
        super();
        super.setClassePersistente(PessoaJuridica.class);
        //super.setOrdem("nome");
    }
    
}
