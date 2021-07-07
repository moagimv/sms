/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.mb;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import za.gov.sars.sms.common.PersonType;
import za.gov.sars.sms.common.SystemUserStatus;
import za.gov.sars.sms.common.SystemUserType;

/**
 *
 * @author S2026987
 */
@ManagedBean
@SessionScoped
public class ActiveUser implements Serializable{
    private String username;
    private StringBuilder displayName;
    private boolean menuActivationIndicator = Boolean.TRUE;
    private boolean userLoginIndicator = false;
    private boolean templateUploadIndicator;
    private String userSessionId;
    private String firstName;
    private String lastName;
    private String identifier;
    private String moduleWelcomeMessage;
    private SystemUserStatus activeStatus;
    private boolean learner;
    private boolean officeAdmin;
    private boolean educator;
    private boolean principal;
    private boolean clerk;
    private boolean headOfDepartment;
    private boolean generalWorker;
    private boolean systeAdmin;
    private PersonType personType;
    private SystemUserType systemUserType;
    
     public void resetRole(boolean validity){
        setOfficeAdmin(validity);
        setClerk(validity);
        setEducator(validity);
        setGeneralWorker(validity);
        setHeadOfDepartment(validity);
        setLearner(validity);
        setPrincipal(validity);
        setSysteAdmin(validity);
    }

    public SystemUserStatus getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(SystemUserStatus activeStatus) {
        this.activeStatus = activeStatus;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public StringBuilder getDisplayName() {
        return displayName;
    }

    public void setDisplayName(StringBuilder displayName) {
        this.displayName = displayName;
    }

    public boolean isMenuActivationIndicator() {
        return menuActivationIndicator;
    }

    public void setMenuActivationIndicator(boolean menuActivationIndicator) {
        this.menuActivationIndicator = menuActivationIndicator;
    }

    public boolean isUserLoginIndicator() {
        return userLoginIndicator;
    }

    public void setUserLoginIndicator(boolean userLoginIndicator) {
        this.userLoginIndicator = userLoginIndicator;
    }

    public boolean isTemplateUploadIndicator() {
        return templateUploadIndicator;
    }

    public void setTemplateUploadIndicator(boolean templateUploadIndicator) {
        this.templateUploadIndicator = templateUploadIndicator;
    }

    public String getUserSessionId() {
        return userSessionId;
    }

    public void setUserSessionId(String userSessionId) {
        this.userSessionId = userSessionId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getModuleWelcomeMessage() {
        return moduleWelcomeMessage;
    }

    public void setModuleWelcomeMessage(String moduleWelcomeMessage) {
        this.moduleWelcomeMessage = moduleWelcomeMessage;
    }

    public boolean isLearner() {
        return learner;
    }

    public void setLearner(boolean learner) {
        this.learner = learner;
    }

    public boolean isOfficeAdmin() {
        return officeAdmin;
    }

    public void setOfficeAdmin(boolean officeAdmin) {
        this.officeAdmin = officeAdmin;
    }

    public boolean isSysteAdmin() {
        return systeAdmin;
    }

    public void setSysteAdmin(boolean systeAdmin) {
        this.systeAdmin = systeAdmin;
    }
    
    public boolean isEducator() {
        return educator;
    }

    public void setEducator(boolean educator) {
        this.educator = educator;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    public boolean isClerk() {
        return clerk;
    }

    public void setClerk(boolean clerk) {
        this.clerk = clerk;
    }

    public boolean isHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(boolean headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    public boolean isGeneralWorker() {
        return generalWorker;
    }

    public void setGeneralWorker(boolean generalWorker) {
        this.generalWorker = generalWorker;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public SystemUserType getSystemUserType() {
        return systemUserType;
    }

    public void setSystemUserType(SystemUserType systemUserType) {
        this.systemUserType = systemUserType;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

}
