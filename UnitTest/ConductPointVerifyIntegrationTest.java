package se.team11.studentprofile.domain;
import org.junit.Test;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.test.RooIntegrationTest;
import java.util.HashSet; 
import java.util.Set; 
import org.junit.Assert;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@RooIntegrationTest(entity = ConductPointVerify.class)
public class ConductPointVerifyIntegrationTest {

  	
  	@Test 
  	public void testInputPass() {
    	Student st1 = new Student();
    	st1.setStudentID("7654321");
    	st1.setFirstName("Phumimin");
    	st1.setLastName("Bangbunyuen");
    	st1.setGrade(Grade.valueOf("GRADE_7"));
    	st1.setNumberOfActivity(5);
    	st1.persist();

    	ConductPointVerify cv = new ConductPointVerify();
    	cv.setStudent(st1);
    	cv.setTotalScore((float)100);
    	cv.setInfo("normal");
    	cv.setStatus(true);
    	cv.persist();
    	Float num = new Float(100);
    	Assert.assertEquals(num, cv.getTotalScore());
        Assert.assertEquals("normal", cv.getInfo()); 
        Assert.assertEquals(true, cv.getStatus());

    }

    @Test 
  	public void testNoInputTotalScore() {
    	Student st1 = new Student();
    	st1.setStudentID("7654321");
    	st1.setFirstName("Phumimin");
    	st1.setLastName("Bangbunyuen");
    	st1.setGrade(Grade.valueOf("GRADE_7"));
    	st1.setNumberOfActivity(5);
    	st1.persist();

    	ConductPointVerify cv = new ConductPointVerify();
    	cv.setStudent(st1);
    	cv.setInfo("normal");
    	cv.setStatus(true);
    	try{
    		cv.persist();
    		Assert.fail(); 
    	}catch(javax.validation.ConstraintViolationException e){
    		
    	}
    }


 	@Test 
  	public void testInputInfoShort() {
    	Student st1 = new Student();
    	st1.setStudentID("7654321");
    	st1.setFirstName("Phumimin");
    	st1.setLastName("Bangbunyuen");
    	st1.setGrade(Grade.valueOf("GRADE_7"));
    	st1.setNumberOfActivity(5);
    	st1.persist();

    	ConductPointVerify cv = new ConductPointVerify();
    	cv.setStudent(st1);
    	cv.setInfo("no");
    	cv.setStatus(true);
    	cv.setTotalScore((float)100);
    	try{
    		cv.persist();
    		Assert.fail(); 
    	}catch(javax.validation.ConstraintViolationException e){
    		
    	}
    }

	@Test 
  	public void testNoInputStudent() {
    	ConductPointVerify cv = new ConductPointVerify();
    	cv.setInfo("normal");
    	cv.setStatus(true);
    	cv.setTotalScore((float)100);
    	try{
    		cv.persist();
    		Assert.fail(); 
    	}catch(javax.validation.ConstraintViolationException e){
    		
    	}
    		
    }

}
