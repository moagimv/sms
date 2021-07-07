/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.service;

import java.util.Date;
import za.gov.sars.sms.domain.Facility;
import za.gov.sars.sms.persistence.FacilityRepository;

/**
 *
 * @author S2026987
 */
public class FacilityHelper {
    
    public static void addFacility(FacilityRepository facilityRepository){
        Facility facility1 = new Facility();
        facility1.setCreatedBy("test");
        facility1.setCreatedDate(new Date());
        facility1.setName("Lecture Hall A");
        facility1.setLocation("Block A");
        facilityRepository.save(facility1);
        
        Facility facility2 = new Facility();
        facility2.setCreatedBy("test");
        facility2.setCreatedDate(new Date());
        facility2.setName("Lecture Hall B");
        facility2.setLocation("Block A");
        facilityRepository.save(facility2);
        
        Facility facility3 = new Facility();
        facility3.setCreatedBy("test");
        facility3.setCreatedDate(new Date());
        facility3.setName("Lecture Hall C");
        facility3.setLocation("Block B");
        facilityRepository.save(facility3);
        
        Facility facility4 = new Facility();
        facility4.setCreatedBy("test");
        facility4.setCreatedDate(new Date());
        facility4.setName("Lecture Hall D");
        facility4.setLocation("Block B");
        facilityRepository.save(facility4);
        
        Facility facility5 = new Facility();
        facility5.setCreatedBy("test");
        facility5.setCreatedDate(new Date());
        facility5.setName("Lecture Hall E");
        facility5.setLocation("Block C");
        facilityRepository.save(facility5);
        
        Facility facility6 = new Facility();
        facility6.setCreatedBy("test");
        facility6.setCreatedDate(new Date());
        facility6.setName("Lecture Hall F");
        facility6.setLocation("Block C");
        facilityRepository.save(facility6);
        
        Facility facility7 = new Facility();
        facility7.setCreatedBy("test");
        facility7.setCreatedDate(new Date());
        facility7.setName("Library Hall A");
        facility7.setLocation("Block D");
        facilityRepository.save(facility7);
        
        Facility facility8 = new Facility();
        facility8.setCreatedBy("test");
        facility8.setCreatedDate(new Date());
        facility8.setName("Laboritory Hall A");
        facility8.setLocation("Block E");
        facilityRepository.save(facility8);
        
        Facility facility9 = new Facility();
        facility9.setCreatedBy("test");
        facility9.setCreatedDate(new Date());
        facility9.setName("Staff Room Hall");
        facility9.setLocation("Building 1");
        facilityRepository.save(facility9);
        
        Facility facility10 = new Facility();
        facility10.setCreatedBy("test");
        facility10.setCreatedDate(new Date());
        facility10.setName("Admin Office");
        facility10.setLocation("Building 1");
        facilityRepository.save(facility10);
        
        Facility facility11 = new Facility();
        facility11.setCreatedBy("test");
        facility11.setCreatedDate(new Date());
        facility11.setName("Principal Office");
        facility11.setLocation("Building 1");
        facilityRepository.save(facility11);
        
        Facility facility12 = new Facility();
        facility12.setCreatedBy("test");
        facility12.setCreatedDate(new Date());
        facility12.setName("Conference Hall A");
        facility12.setLocation("Building 2");
        facilityRepository.save(facility12);
        
    }
}
