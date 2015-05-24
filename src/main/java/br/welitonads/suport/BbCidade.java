package br.welitonads.suport;

import br.welitonads.model.DAO.HibernateDAO;
import br.welitonads.model.DAO.InterfaceDAO;
import br.welitonads.model.entities.Cidade;
import br.welitonads.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean (name = "bbCidade")
@RequestScoped
public class BbCidade implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public List<Cidade> getCidades(){
        InterfaceDAO<Cidade> cidadeDAO = new HibernateDAO<Cidade>(Cidade.class, FacesContextUtil.getRequestSession());
        return cidadeDAO.getEntities();
    }
}
