package se.team11.studentprofile.domain;
import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;

@RooIntegrationTest(entity = Studentstatuscheck.class)
public class StudentstatuscheckIntegrationTest {

    @Test
    public void testStudentstatuscheckPass() {
    	Studentstatuscheck ssc = new Studentstatuscheck();
    	Student std = new Student();
    	Gpa gpa = new Gpa();
    	Cashier ch = new Cashier();
    	HealthCareHistory hch = new HealthCareHistory();
    	HistoryInActivity hia = new HistoryInActivity();
    	ssc.setStatus("12345");
    	ssc.persist();
    }

    @Test
    public void testSetstatusNull() {
    	Studentstatuscheck ssc = new Studentstatuscheck();
    	Student std = new Student();
    	Gpa gpa = new Gpa();
    	Cashier ch = new Cashier();
    	HealthCareHistory hch = new HealthCareHistory();
    	HistoryInActivity hia = new HistoryInActivity();
    	try{
    	ssc.persist();
    	}catch(javax.validation.ConstraintViolationException e){
    		//pass
    	}
    }
    
    @Test
    public void testSetstatusLessThan2() {
    	Studentstatuscheck ssc = new Studentstatuscheck();
    	Student std = new Student();
    	Gpa gpa = new Gpa();
    	Cashier ch = new Cashier();
    	HealthCareHistory hch = new HealthCareHistory();
    	HistoryInActivity hia = new HistoryInActivity();
    	ssc.setStatus("1");
    	try{
    	ssc.persist();
    	}catch(javax.validation.ConstraintViolationException e){
    		//pass
    	}
    }

    @Test
    public void testSetstatusMoreThan10() {
    	Studentstatuscheck ssc = new Studentstatuscheck();
    	Student std = new Student();
    	Gpa gpa = new Gpa();
    	Cashier ch = new Cashier();
    	HealthCareHistory hch = new HealthCareHistory();
    	HistoryInActivity hia = new HistoryInActivity();
    	ssc.setStatus("01234567891");
    	try{
    	ssc.persist();
    	}catch(javax.validation.ConstraintViolationException e){
    		//pass
    	}
    }

}
