package br.welitonads.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;

public class PhaseListenerUtil implements PhaseListener{

     @Override
    public void beforePhase(PhaseEvent fase) {
        if(fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)){
            System.out.println("Antes da fase: "+ fase.getPhaseId());
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            FacesContextUtil.setRequestSession(session);
        }
    }

    
    @Override
    public void afterPhase(PhaseEvent fase) {
        System.out.println("Depois da fase: "+ fase.getPhaseId());
        if (fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            Session session = FacesContextUtil.getRequestSession();
            try {
                session.getTransaction().commit();
            } catch (Exception e) {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            }finally{
                session.close();
            }
        }
    }
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
}
