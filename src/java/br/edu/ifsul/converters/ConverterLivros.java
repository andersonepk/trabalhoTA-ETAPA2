/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.converters;

import br.edu.ifsul.modelo.Livros;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrador
 */
@FacesConverter(value = "converterLivros")
public class ConverterLivros implements Serializable, Converter{

    @PersistenceContext(unitName = "trabalhoTA-WEBPU")
    private EntityManager em;
    
    //converte da tela para objeto
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
      if(string == null || string.equals("Selecione um registro")){
          return null;
      }
      return em.find(Livros.class, Integer.parseInt(string));
    }
    //converte do objeto para a tela
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if(o == null){
            return null;
        }
        Livros l = (Livros) o;
        return l.getId().toString();
    }
    
    
}
