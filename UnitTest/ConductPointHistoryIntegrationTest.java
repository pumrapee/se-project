package se.team11.studentprofile.domain;
import org.junit.Test;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.test.RooIntegrationTest;
import java.util.HashSet; 
import java.util.Set; 
import org.junit.Assert;
import java.util.Date;
import org.junit.Assert;

@RooIntegrationTest(entity = ConductPointHistory.class)
public class ConductPointHistoryIntegrationTest {

    @Test 
  	public void testInputPass() {
    	Student st1 = new Student();
    	st1.setStudentID("7654321");
    	st1.setFirstName("Phumimin");
    	st1.setLastName("Bangbunyuen");
    	st1.setGrade(Grade.valueOf("GRADE_7"));
    	st1.setNumberOfActivity(5);
    	st1.persist();

    	ConductPointHistory ch = new ConductPointHistory();
    	ch.setStudentID(st1);
    	Date date = new Date();
		date.setDate(11);
		date.setMonth(1);
		date.setYear(2017);
		ch.setActionDate(date);
    	ch.setTerm("1/2560");
    	ch.setHistory("not wearing a helmet");
    	ch.setPoint((float)-10);
    	ch.persist();
    	Assert.assertEquals("1/2560", ch.getTerm());
        Assert.assertEquals("not wearing a helmet", ch.getHistory()); 

    }


    @Test 
  	public void testTermOverSize() {
    	Student st1 = new Student();
    	st1.setStudentID("7654321");
    	st1.setFirstName("Phumimin");
    	st1.setLastName("Bangbunyuen");
    	st1.setGrade(Grade.valueOf("GRADE_7"));
    	st1.setNumberOfActivity(5);
    	st1.persist();
    	
    	ConductPointHistory ch = new ConductPointHistory();
    	ch.setStudentID(st1);
    	Date date = new Date();
		date.setDate(11);
		date.setMonth(1);
		date.setYear(2017);
		ch.setActionDate(date);
    	ch.setTerm("001/2560");
    	ch.setHistory("not wearing a helmet");
    	ch.setPoint((float)-10);
    	try{
    		ch.persist();
    		Assert.fail(); 
    	}catch(javax.validation.ConstraintViolationException e){

    	}
    		
    }

    @Test 
  	public void testNoInputHistory() {
    	Student st1 = new Student();
    	st1.setStudentID("7654321");
    	st1.setFirstName("Phumimin");
    	st1.setLastName("Bangbunyuen");
    	st1.setGrade(Grade.valueOf("GRADE_7"));
    	st1.setNumberOfActivity(5);
    	st1.persist();

    	ConductPointHistory ch = new ConductPointHistory();
    	ch.setStudentID(st1);
    	Date date = new Date();
		date.setDate(11);
		date.setMonth(1);
		date.setYear(2017);
		ch.setActionDate(date);
    	ch.setTerm("1/2560");
    	ch.setPoint((float)-10);
    	try{
    		ch.persist();
    		Assert.fail(); 
    	}catch(javax.validation.ConstraintViolationException e){
    		
    	}
    		
    }

    @Test 
  	public void testNoInputStudent() {
    	ConductPointHistory ch = new ConductPointHistory();
    	Date date = new Date();
		date.setDate(11);
		date.setMonth(1);
		date.setYear(2017);
		ch.setActionDate(date);
    	ch.setTerm("1/2560");
    	ch.setHistory("not wearing a helmet");
    	ch.setPoint((float)-10);
    	try{
    		ch.persist();
    		Assert.fail(); 
    	}catch(javax.validation.ConstraintViolationException e){
    		
    	}
    		
    }
}
