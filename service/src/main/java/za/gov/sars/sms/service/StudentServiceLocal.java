/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.service;

import java.util.List;
import za.gov.sars.sms.domain.Student;

/**
 *
 * @author S2026987
 */
public interface StudentServiceLocal {
    Student save(Student student);

    Student findById(Long id);

    Student update(Student student);

    void deleteAll();

    Student deleteById(Long id);
    
    Student findStudentByStudentNo(String studentNo);

    List<Student> listAll();

    boolean isExist(Student student);

    long count();
}
