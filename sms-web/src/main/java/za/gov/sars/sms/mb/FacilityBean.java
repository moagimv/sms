/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.mb;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import za.gov.sars.sms.domain.Facility;
import za.gov.sars.sms.service.FacilityServiceLocal;

/**
 *
 * @author S2026987
 */
@ManagedBean
@ViewScoped
public class FacilityBean extends BaseBean {

    @Autowired
    private FacilityServiceLocal facilityService;

    private List<Facility> facilities = new ArrayList<>();

    private Facility facility;

    @PostConstruct
    public void init() {
        this.resetView(false).setList(true);
        facilities = facilityService.listAll();
    }

    public void addOrUpdate(Facility fclty) {
        this.resetView(false).setAdd(true);
        if (fclty != null) {
            fclty.setUpdatedBy(getActiveUser().getIdentifier());
            fclty.setUpdatedDate(new Date());
            facility = fclty;
        } else {
            facility = new Facility();
            facility.setCreatedBy(getActiveUser().getIdentifier());
            facility.setCreatedDate(new Date());

            facilities.add(0, facility);
        }
    }
    
    public void save(Facility fclty) {
        if (fclty.getId() != null) {
            facilityService.update(fclty);
        } else {
            facilityService.save(fclty);
        }
        this.resetView(false).setList(true);
    }
    
    public void delete(Facility fclty) {
        facilityService.deleteById(fclty.getId());
        synchronize(fclty);
        this.resetView(false).setList(true);
    }

    public void synchronize(Facility fclty) {
        Iterator<Facility> facilityList = facilities.iterator();
        while (facilityList.hasNext()) {
            if (facilityList.next().getId().equals(fclty.getId())) {
                facilityList.remove();
            }
        }
    }

    public void cancel(Facility fclty) {
        if (fclty.getId() == null) {
            if (facilities.contains(fclty)) {
                facilities.remove(fclty);
            }
        }
        this.resetView(false).setList(true);
    }
    

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

}
