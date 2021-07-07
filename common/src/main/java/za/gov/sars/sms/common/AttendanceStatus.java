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
public enum AttendanceStatus {
    AVAILABLE("Available"),
    CANCELLED("Cancelled"),
    POSTPONED("Postponed");
    
    private final String displayName;

    AttendanceStatus(final String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }   
}
