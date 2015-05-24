package br.welitonads.suport;

import br.welitonads.model.DAO.HibernateDAO;
import br.welitonads.model.DAO.InterfaceDAO;
import br.welitonads.model.entities.TipoEndereco;
import br.welitonads.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean (name = "bbTipoEndereco")
@RequestScoped
public class BbTipoEndereco implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public List<TipoEndereco> getTipoEnderecos(){
        InterfaceDAO<TipoEndereco> tipoEnderecoDAO = new HibernateDAO<TipoEndereco>(TipoEndereco.class, FacesContextUtil.getRequestSession());
        return tipoEnderecoDAO.getEntities();
    }
}
