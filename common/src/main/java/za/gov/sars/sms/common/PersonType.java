/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.common;

/**
 *
 * @author S2026987
 */
public enum PersonType {
    SYS_USER("Employee"),
    EMPLOYEE("Employee"),
    LEARNER("Learner");
    
    private final String displayName;

    PersonType(final String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }      
}
