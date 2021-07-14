/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.service;

import java.util.Date;
import za.gov.sars.sms.common.AddressType;
import za.gov.sars.sms.domain.Address;
import za.gov.sars.sms.domain.ContactDetail;
import za.gov.sars.sms.domain.School;
import za.gov.sars.sms.persistence.SchoolRepository;

/**
 *
 * @author S2026987
 */
public class SchoolHelper {
    
    public static void addSchool(SchoolRepository schoolRepository){
        School school = new School();
        school.setCreatedBy("test");
        school.setCreatedDate(new Date());
        school.setSchoolName("Tumi High School");
        school.setRegNo("sch001hs05");   
        
        ContactDetail contactDetail = new ContactDetail();
        contactDetail.setCreatedBy("test");
        contactDetail.setCreatedDate(new Date());
        contactDetail.setCellphoneNo("0817139852");
        contactDetail.setTelephoneNo("0127139852");
        contactDetail.setEmail("info@school.gov.za");
        
        school.setContactDetail(contactDetail); 
        
        Address ressAddress = new Address();        
        ressAddress.setCreatedBy("test");
        ressAddress.setCreatedDate(new Date());
        ressAddress.setAddressType(AddressType.RESIDENTIAL);
        ressAddress.setAddressLine1("Tumi high School");
        ressAddress.setAddressLine2("School Section");
        ressAddress.setStreet("00 School Street");
        ressAddress.setArea("School");
        ressAddress.setCode("0001"); 
        
        Address postalAddress = new Address();        
        postalAddress.setCreatedBy("test");
        postalAddress.setCreatedDate(new Date());
        postalAddress.setAddressType(AddressType.POSTAL);
        postalAddress.setAddressLine2("P.O Box 000");
        postalAddress.setArea("School");
        postalAddress.setCode("0001");
        
        school.addAddress(ressAddress);
        school.addAddress(postalAddress);
        
        schoolRepository.save(school);
    }
}
