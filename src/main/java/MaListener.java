
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Andhika Prameswara <prameswaara@gmail.com>
 */
public class MaListener implements PhaseListener {

    @Override
    public void afterPhase(PhaseEvent event) {
        System.out.println("AFTER PHASE ID:- " + event.getPhaseId().toString());

        FacesContext fc = event.getFacesContext();
        ExternalContext ec = fc.getExternalContext();
        System.out.println("ini calon dia redirect");
        System.out.println(fc.getViewRoot().getViewId());
        System.out.println(fc.getViewRoot().getViewId().contains("index.xhtml"));
        if (!fc.getViewRoot().getViewId().contains("index.xhtml")) {
            HttpSession session = (HttpSession) ec.getSession(true);
            if (session.getAttribute("user-auth") == null) {
                System.out.println("masuk sini");
                String user = (String) session.getAttribute("user-auth");
                if (user == null) {
                    try {
                        System.out.println("ini dia redirect");
                        System.out.println(ec.getRequestContextPath());
                        ec.redirect(ec.getRequestContextPath() + "/index.jsf");
                    } catch (IOException ex) {
                        Logger.getLogger(MaListener.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

    }

    @Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}
