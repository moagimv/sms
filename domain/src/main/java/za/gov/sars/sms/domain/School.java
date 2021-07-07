/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.envers.Audited;

/**
 *
 * @author S2026987
 */
@Audited
@Entity
@Table(name = "school")
public class School extends BaseEntity{
    @Column(name = "school_name")
    private String schoolName;
    @Column(name = "registration_number")
    private String regNo;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private ContactDetail contactDetail;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Address> addresses = new ArrayList<>();

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public ContactDetail getContactDetail() {
        return contactDetail;
    }

    public void setContactDetail(ContactDetail contactDetail) {
        this.contactDetail = contactDetail;
    }

    public List<Address> getAddress() {
        return addresses;
    }

    public void setAddress(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
    
    public void addAddress(Address address){
        this.addresses.add(address);
    }

}
