package br.welitonads.suport;

import br.welitonads.model.DAO.HibernateDAO;
import br.welitonads.model.DAO.InterfaceDAO;
import br.welitonads.model.entities.Estado;
import br.welitonads.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean (name = "bbEstado")
@RequestScoped
public class BbEstado implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public List<Estado> getEstados(){
        InterfaceDAO<Estado> estadoDAO = new HibernateDAO<Estado>(Estado.class, FacesContextUtil.getRequestSession());
        return estadoDAO.getEntities();
    }
}
