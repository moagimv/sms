/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.mb;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.jsf.FacesContextUtils;
import za.gov.sars.sms.common.SystemUserType;

/**
 *
 * @author S2026987
 */
public class BaseBean extends SpringBeanAutowiringSupport implements Serializable {

    @ManagedProperty(value = "#{activeUser}")
    private ActiveUser activeUser;    
    private boolean add;
    private boolean list;
    private boolean visible;
    private boolean visibleTab;
    private List<String> errorCollectionMsg = new ArrayList<>();
    
    public void init(){
        FacesContextUtils
                .getRequiredWebApplicationContext(FacesContext.getCurrentInstance())
                .getAutowireCapableBeanFactory().autowireBean(this);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Cache-Control", "must-revalidate");
        response.setHeader("Expires", "Mon, 8 Aug 2010 10:00:00 GMT");
    }
    
    public boolean isList() {
        return list;
    }

    public void setList(boolean list) {
        this.list = list;
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isVisibleTab() {
        return visibleTab;
    }

    public void setVisibleTab(boolean visibleTab) {
        this.visibleTab = visibleTab;
    }

    public BaseBean resetView(boolean reset) {
        this.setAdd(reset);
        this.setList(reset);
        return this;
    }

    public ActiveUser getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(ActiveUser activeUser) {
        this.activeUser = activeUser;
    }

    public void isUserLoggedIn(String redirectPage) {
        if (!getActiveUser().isUserLoginIndicator()) {
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(redirectPage);
            } catch (IOException ex) {
                Logger.getLogger(BaseBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
    
    public void redirect(String redirectPage) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(redirectPage);
        } catch (IOException ex) {
            Logger.getLogger(BaseBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void invalidateUserSession() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
            //getActiveUser().setUserLoginIndicator(Boolean.FALSE);
        }
    }

    public boolean isUserSessionExpired() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session == null) {
            //getActiveUser().setUserLoginIndicator(Boolean.FALSE);
            return true;
        }
        return false;
    }

    public BaseBean invalidateSession() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return this;
    }

    public boolean isAdminUser() {
        return getActiveUser().getSystemUserType().equals(SystemUserType.SYSTEM_ADMIN);
    }

    public boolean isEmployee() {
        return getActiveUser().getSystemUserType().equals(SystemUserType.EMPLOYEE);
    }

    public boolean isLearner() {
        return getActiveUser().getSystemUserType().equals(SystemUserType.LEARNER);
    }
  
    public void reRoute(String page) {
        try {
            StringBuilder builder = new StringBuilder(page);
            builder.append(".xhtml");
            FacesContext.getCurrentInstance().getExternalContext().redirect(builder.toString());
        } catch (IOException ex) {
            Logger.getLogger(BaseBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void redirecting(String page) {
        try {
            StringBuilder builder = new StringBuilder(page);
            builder.append(".xhtml?faces-redirect=true");
            FacesContext.getCurrentInstance().getExternalContext().redirect(builder.toString());
        } catch (IOException ex) {
            Logger.getLogger(BaseBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addInformationMessage(String... detail) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String message : detail) {
            stringBuilder.append(message);
            stringBuilder.append(" ");
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "", stringBuilder.toString().trim());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addErrorMessage(String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addErrorMessage(String... detail) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String message : detail) {
            stringBuilder.append(message);
            stringBuilder.append(" ");
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", stringBuilder.toString().trim());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addWarningMessage(String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "", detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addWarningMessage(String... detail) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String message : detail) {
            stringBuilder.append(message);
            stringBuilder.append(" ");
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "", stringBuilder.toString().trim());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void addError(String... message) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String error : message) {
            stringBuilder.append(error);
            stringBuilder.append(" ");
        }
        this.getErrorCollectionMsg().add(stringBuilder.toString());
    }

    public void addInfomation(String... message) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String information : message) {
            stringBuilder.append(information);
            stringBuilder.append(" ");
        }
        this.getErrorCollectionMsg().add(stringBuilder.toString());
    }

    public void addWarning(String... message) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String warning : message) {
            stringBuilder.append(warning);
            stringBuilder.append(" ");
        }
        this.getErrorCollectionMsg().add(stringBuilder.toString());
    }
    
    public String defaultRouter(String page) {
        StringBuilder builder = new StringBuilder(page);
        builder.append(".xhtml");
        return builder.toString();
    }

    public String defaultRouting(String page) {
        StringBuilder builder = new StringBuilder(page);
        builder.append(".xhtml");
        return builder.toString();
    }
    
    /**
     * @return the errorCollectionMsg
     */
    public List<String> getErrorCollectionMsg() {
        return errorCollectionMsg;
    }

    /**
     * @param errorCollectionMsg the errorCollectionMsg to set
     */
    public void setErrorCollectionMsg(List<String> errorCollectionMsg) {
        this.errorCollectionMsg = errorCollectionMsg;
    }

    public void addErrorCollectionMsg(String message) {
        errorCollectionMsg.add(message);
    }

    
}
