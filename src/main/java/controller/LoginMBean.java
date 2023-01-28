package controller;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import service.LoginServiceImpl;
import service.LoginServices;

/**
 *
 * @author Andhika Prameswara <prameswaara@gmail.com>
 */
@ManagedBean(name = "loginManagedBean")
@SessionScoped
public class LoginMBean implements Serializable {

    private String username;
    private String password;
    private LoginServices loginServices;

    @PostConstruct
    void init() {
        loginServices = new LoginServiceImpl();
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        System.out.println(context.getRequestContextPath());
    }

    public void doLogin() throws IOException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        String roleUser = loginServices.validatingAccounts(username, password);
        HttpSession session;
        FacesContext ctx = FacesContext.getCurrentInstance();
        System.out.println("do Login");
        switch (roleUser) {
            case "helpdesk":
                ctx = FacesContext.getCurrentInstance();
                session = (HttpSession) ctx.getExternalContext().getSession(false);
                session.setAttribute("user-auth", roleUser);
                context.redirect(context.getRequestContextPath() + "/helpdesk/helpdesk.xhtml");
                break;
            case "client":
                ctx = FacesContext.getCurrentInstance();
                session = (HttpSession) ctx.getExternalContext().getSession(false);
                session.setAttribute("user-auth", roleUser);
                context.redirect(context.getRequestContextPath() + "/client/client_dashboard.xhtml");
                break;
            case "admin":
                ctx = FacesContext.getCurrentInstance();
                session = (HttpSession) ctx.getExternalContext().getSession(false);
                session.setAttribute("user-auth", roleUser);
                context.redirect(context.getRequestContextPath() + "/admin/admin_dashboard");
                break;
            default:
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Informasi", "Login Gagal"));
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
