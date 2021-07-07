/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.gov.sars.sms.domain.SchoolSystemUser;
import za.gov.sars.sms.persistence.SystemUserRepository;

/**
 *
 * @author S2026987
 */
@Service
public class SystemUserService implements SystemUserServiceLocal {

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Override
    public SchoolSystemUser login(String username) {
        return systemUserRepository.searchByUsername(username);
    }
    
    @Override
    public SchoolSystemUser findSystemUserByIdentifier(String identifier){
        return systemUserRepository.findSystemUserByIdentifier(identifier);
    }
    
    @Override
    public SchoolSystemUser save(SchoolSystemUser systemUser) {
        return systemUserRepository.save(systemUser);
    }

    @Override
    public SchoolSystemUser findById(Long id) {
        return systemUserRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                                "The requested id [" + id
                                + "] does not exist."));
    }

    @Override
    public SchoolSystemUser update(SchoolSystemUser systemUser) {
        return systemUserRepository.save(systemUser);
    }

    @Override
    public void deleteAll() {
        systemUserRepository.deleteAll();
    }

    @Override
    public SchoolSystemUser deleteById(Long id) {
        SchoolSystemUser systemUser = findById(id);
        if(systemUser != null){
            systemUserRepository.deleteById(id);
        }
        return systemUser;
    }

    @Override
    public List<SchoolSystemUser> listAll() {
        return systemUserRepository.findAll();
    }

    @Override
    public boolean isExist(SchoolSystemUser systemUser) {
        return systemUserRepository.findById(systemUser.getId()) != null;
    }

    @Override
    public long count() {
        return systemUserRepository.count();
    }

}
