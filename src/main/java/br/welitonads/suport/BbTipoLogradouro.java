package br.welitonads.suport;

import br.welitonads.model.DAO.HibernateDAO;
import br.welitonads.model.DAO.InterfaceDAO;
import br.welitonads.model.entities.TipoLogradouro;
import br.welitonads.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean (name = "bbTipoLogradouro")
@RequestScoped
public class BbTipoLogradouro implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public List<TipoLogradouro> getTipoLogradouros(){
        InterfaceDAO<TipoLogradouro> tipoLogradouroDAO = new HibernateDAO<TipoLogradouro>(TipoLogradouro.class, FacesContextUtil.getRequestSession());
        return tipoLogradouroDAO.getEntities();
    }
}
