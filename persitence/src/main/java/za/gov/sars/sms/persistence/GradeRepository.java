/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.gov.sars.sms.domain.Grade;

/**
 *
 * @author S2026987
 */
@Repository
public interface GradeRepository extends JpaRepository<Grade, Long>{
    
}
