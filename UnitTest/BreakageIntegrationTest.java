package se.team11.studentprofile.domain;
import org.junit.Test;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.test.RooIntegrationTest;
import org.junit.Assert;

@RooIntegrationTest(entity = Breakage.class)
public class BreakageIntegrationTest {

    @Test
    public void TestBreakagePass() {
    	Student std = new Student();
    	std.setStudentID("1234567");
    	std.setFirstName("Vechavit");
    	std.setLastName("Jutangura");
    	std.setGrade(Grade.valueOf("GRADE_8"));
    	std.setNumberOfActivity(123);
    	std.persist();

    	Breakage bk = new Breakage();
    	bk.setStdname(std);
    	bk.setList("chairbroke");
    	bk.setPrice((float)125.00);
    	bk.setStatus(true);
    	bk.persist();

    	Assert.assertEquals("chairbroke",bk.getList());
    }
    @Test //fail 1
    public void Test_List_Less_Than4() {
    	Student std = new Student();
    	std.setStudentID("1234567");
    	std.setFirstName("Vechavit");
    	std.setLastName("Jutangura");
    	std.setGrade(Grade.valueOf("GRADE_8"));
    	std.setNumberOfActivity(123);
    	std.persist();
    	try{
    	Breakage bk = new Breakage();
    	bk.setStdname(std);
    	bk.setList("cha");
    	bk.setPrice((float)125.00);
    	bk.setStatus(true);
    	bk.persist();
    	}catch(javax.validation.ConstraintViolationException e){
    		//pass
    	}

    }
    @Test // fail 2
    public void Test_List_Null() {
    	Student std = new Student();
    	std.setStudentID("1234567");
    	std.setFirstName("Vechavit");
    	std.setLastName("Jutangura");
    	std.setGrade(Grade.valueOf("GRADE_8"));
    	std.setNumberOfActivity(123);
    	std.persist();
    	try{
    	Breakage bk = new Breakage();
    	bk.setStdname(std);
    	bk.setPrice((float)125.00);
    	bk.setStatus(true);
    	bk.persist();
    	}catch(javax.validation.ConstraintViolationException e){
    		//Pass
    	}

    }
     @Test //fail 3
    public void Test_Price_Null() {
    	Student std = new Student();
    	std.setStudentID("1234567");
    	std.setFirstName("Vechavit");
    	std.setLastName("Jutangura");
    	std.setGrade(Grade.valueOf("GRADE_8"));
    	std.setNumberOfActivity(123);
    	std.persist();
    	try{
    	Breakage bk = new Breakage();
    	bk.setStdname(std);
    	bk.setList("chairbroke");
    	bk.setStatus(true);
    	bk.persist();
    	}catch(javax.validation.ConstraintViolationException e){
    		//Pass
    	}

    }
   
}
