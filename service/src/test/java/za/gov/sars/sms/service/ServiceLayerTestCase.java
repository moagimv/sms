/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import za.gov.sars.sms.common.TestDataSourceConfiguration;
import za.gov.sars.sms.persistence.AssessmentRepository;
import za.gov.sars.sms.persistence.AttendenceRepository;
import za.gov.sars.sms.persistence.EmployeeRepository;
import za.gov.sars.sms.persistence.FacilityRepository;
import za.gov.sars.sms.persistence.GradeRepository;
import za.gov.sars.sms.persistence.SchoolRepository;
import za.gov.sars.sms.persistence.StudentRepository;
import za.gov.sars.sms.persistence.SubjectRepository;
import za.gov.sars.sms.persistence.SystemUserRepository;

/**
 *
 * @author S2026987
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestDataSourceConfiguration.class)
public class ServiceLayerTestCase {
    
    @Autowired
    private AssessmentRepository assessmentRepository;
    @Autowired
    private AttendenceRepository attendenceRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private FacilityRepository facilityRepository;
    @Autowired
    private GradeRepository gradeRepository;
    @Autowired
    private SchoolRepository schoolRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SystemUserRepository systemUserRepository;
    
    public ServiceLayerTestCase() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void TestA() {
        SchoolHelper.addSchool(schoolRepository);
    }
    
    @Test
    public void TestB() {
        GradeHelper.addGrade(gradeRepository, schoolRepository);
    }
    
    @Test
    public void TestC() {
        SubjectHelper.addSubject(subjectRepository, schoolRepository);
    }
    
    @Test
    public void TestD() {
        EmployeeHelper.addEmployee(employeeRepository,gradeRepository,subjectRepository,schoolRepository);
    }
    
    @Test
    public void TestE() {
        StudentHelper.addStudent(studentRepository,gradeRepository,subjectRepository,schoolRepository);
    }
    
    @Test
    public void TestF() {
        SystemUserHelper.addSystemUser(systemUserRepository,employeeRepository, studentRepository);        
    }
    
    @Test
    public void TestG() {
        FacilityHelper.addFacility(facilityRepository, schoolRepository);
    }
    
    @Test
    public void TestH() {
        AttendenceHelper.addAttendence(attendenceRepository, studentRepository, employeeRepository, gradeRepository, subjectRepository);
    }
    
    @Test
    public void TestI() {
        AssessmentHelper.addAssessment(assessmentRepository, employeeRepository, studentRepository);
    }
    
    
}
