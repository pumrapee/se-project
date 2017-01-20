package se.team11.studentprofile.domain;
import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;
import java.util.HashSet; 
import java.util.Set; 
import java.util.Calendar;
import org.junit.Assert;
import java.util.Date;

@RooIntegrationTest(entity = HealthCareHistory.class)
public class HealthCareHistoryIntegrationTest {

    @Test
    public void HealthCareHistoryPass() {
    	Student st = new Student();
    	st.setStudentID("0123456");
    	st.setFirstName("Suriyapon");
    	st.setLastName("Sasivimollit");
    	st.setGrade(Grade.valueOf("GRADE_8"));
    	st.setNumberOfActivity(3);
    	st.persist();
    	
    	HealthCareHistory hch = new HealthCareHistory();
    	hch.setStudent(st);
    	hch.setInfo("Get cut by cutter");
    	Date d = new Date();
    	d.setDate(1);
    	d.setMonth(2);
    	d.setYear(2017);
    	hch.setCureDate(d);
    	hch.persist();

    }

    @Test
    public void HealthCareHistoryNoStudent() {
    	HealthCareHistory hch = new HealthCareHistory();
    	hch.setInfo("Get cut by cutter");
    	Date d = new Date();
    	d.setDate(1);
    	d.setMonth(2);
    	d.setYear(2017);
    	hch.setCureDate(d);

    	try{

    	hch.persist();
    	Assert.fail();

    	}catch (javax.validation.ConstraintViolationException e){

    	}
    }

    @Test
    public void HealthCareHistoryInFoNotCorrect() {
    	Student st = new Student();
    	st.setStudentID("0123456");
    	st.setFirstName("Suriyapon");
    	st.setLastName("Sasivimollit");
    	st.setGrade(Grade.valueOf("GRADE_8"));
    	st.setNumberOfActivity(3);
    	st.persist();

    	HealthCareHistory hch = new HealthCareHistory();
    	hch.setStudent(st);
    	hch.setInfo("Got");
    	Date d = new Date();
    	d.setDate(1);
    	d.setMonth(2);
    	d.setYear(2017);
    	hch.setCureDate(d);

    	try{

    	hch.persist();
    	Assert.fail();

    	}catch (javax.validation.ConstraintViolationException e){

    	}
    }

    @Test
    public void HealthCareHistoryNoDate() {
    	Student st = new Student();
    	st.setStudentID("0123456");
    	st.setFirstName("Suriyapon");
    	st.setLastName("Sasivimollit");
    	st.setGrade(Grade.valueOf("GRADE_8"));
    	st.setNumberOfActivity(3);
    	st.persist();

    	HealthCareHistory hch = new HealthCareHistory();
    	hch.setStudent(st);
    	hch.setInfo("Got cut by Cutter");
    	

    	try{

    	hch.persist();
    	Assert.fail();

    	}catch (javax.validation.ConstraintViolationException e){

    	}
    }
}
