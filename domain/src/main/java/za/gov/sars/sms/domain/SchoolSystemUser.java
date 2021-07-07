/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.envers.Audited;
import za.gov.sars.sms.common.SystemUserStatus;
import za.gov.sars.sms.common.SystemUserType;

/**
 *
 * @author S2026987
 */
@Audited
@Entity
@Table(name = "school_system_user")
public class SchoolSystemUser extends Person{
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "confirm_password")
    private String confirmPassword;
    @Column(name = "identifier")
    private String identifier;
    @Column(name = "change_password")
    private boolean changePassword;
    @Enumerated(EnumType.STRING)
    @Column(name = "system_user_status")
    private SystemUserStatus systemUserStatus;
    @Enumerated(EnumType.STRING)
    @Column(name = "system_user_type")
    private SystemUserType systemUserType;
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private School school;
         
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public boolean isChangePassword() {
        return changePassword;
    }

    public void setChangePassword(boolean changePassword) {
        this.changePassword = changePassword;
    }

    public SystemUserStatus getSystemUserStatus() {
        return systemUserStatus;
    }

    public void setSystemUserStatus(SystemUserStatus systemUserStatus) {
        this.systemUserStatus = systemUserStatus;
    }

    public SystemUserType getSystemUserType() {
        return systemUserType;
    }

    public void setSystemUserType(SystemUserType systemUserType) {
        this.systemUserType = systemUserType;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
