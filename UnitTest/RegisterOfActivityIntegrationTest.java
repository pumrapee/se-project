package se.team11.studentprofile.domain;
import org.junit.Test;
import org.junit.Assert;
import org.springframework.roo.addon.test.RooIntegrationTest;

@RooIntegrationTest(entity = RegisterOfActivity.class)
public class RegisterOfActivityIntegrationTest {

    @Test
    public void DatatestInputPass() {
    	Student str = new Student();
    	str.setStudentID("B234567");
    	str.setFirstName("Kittipat");
    	str.setLastName("Sriwong");
    	str.setGrade(Grade.valueOf("GRADE_7")); 
    	str.setNumberOfActivity(10);
		str.persist();

		AnnouncementOfActivity aoa = new AnnouncementOfActivity();
		aoa.setAnnouncementOfActivityID("A12345");
		aoa.setAnnouncementOfActivityName("Science Camp #1");
		aoa.setAnnouncementOfActivityRemain(50);
		aoa.persist();

		RegisterOfActivity roa = new RegisterOfActivity();
		roa.setStudent(str);
		roa.setRegisterOfActivityID("A12345R0001");
		roa.setAnnouncementOfActivity(aoa);
		roa.setStatus(true);
		roa.persist();
    }
    @Test
    public void DatatestInputRegisterOfActivityIDMoreThanEleven() {
    	Student str = new Student();
    	str.setStudentID("B234567");
    	str.setFirstName("Kittipat");
    	str.setLastName("Sriwong");
    	str.setGrade(Grade.valueOf("GRADE_7")); 
    	str.setNumberOfActivity(10);
		str.persist();

		AnnouncementOfActivity aoa = new AnnouncementOfActivity();
		aoa.setAnnouncementOfActivityID("A12345");
		aoa.setAnnouncementOfActivityName("Science Camp #1");
		aoa.setAnnouncementOfActivityRemain(50);
		aoa.persist();

		RegisterOfActivity roa = new RegisterOfActivity();
		roa.setStudent(str);
		roa.setRegisterOfActivityID("A12345P0001234");
		roa.setAnnouncementOfActivity(aoa);
		roa.setStatus(true);
		
		try{
    	    roa.persist();
    	    Assert.fail();
    	}
    	catch(javax.validation.ConstraintViolationException e){}
    }
    @Test
    public void DatatestInputRegisterOfActivityIDNULL() {
    	Student str = new Student();
    	str.setStudentID("B234567");
    	str.setFirstName("Kittipat");
    	str.setLastName("Sriwong");
    	str.setGrade(Grade.valueOf("GRADE_7")); 
    	str.setNumberOfActivity(10);
		str.persist();

		AnnouncementOfActivity aoa = new AnnouncementOfActivity();
		aoa.setAnnouncementOfActivityID("A12345");
		aoa.setAnnouncementOfActivityName("Science Camp #1");
		aoa.setAnnouncementOfActivityRemain(50);
		aoa.persist();

		RegisterOfActivity roa = new RegisterOfActivity();
		roa.setStudent(str);
		
		roa.setAnnouncementOfActivity(aoa);
		roa.setStatus(true);
		
		try{
    	    roa.persist();
    	    Assert.fail();
    	}
    	catch(javax.validation.ConstraintViolationException e){}
    }
    @Test
    public void DatatestInputRegisterOfActivityNoStudent() {
    	Student str = new Student();
    	str.setStudentID("B234567");
    	str.setFirstName("Kittipat");
    	str.setLastName("Sriwong");
    	str.setGrade(Grade.valueOf("GRADE_7")); 
    	str.setNumberOfActivity(10);
		str.persist();

		AnnouncementOfActivity aoa = new AnnouncementOfActivity();
		aoa.setAnnouncementOfActivityID("A12345");
		aoa.setAnnouncementOfActivityName("Science Camp #1");
		aoa.setAnnouncementOfActivityRemain(50);
		aoa.persist();

		RegisterOfActivity roa = new RegisterOfActivity();
		
		roa.setRegisterOfActivityID("A12345R0001");
		roa.setAnnouncementOfActivity(aoa);
		roa.setStatus(true);
		
		try{
    	    roa.persist();
    	    Assert.fail();
    	}
    	catch(javax.validation.ConstraintViolationException e){}
    }
    @Test
    public void DatatestInputRegisterOfActivityIDLessThanEleven() {
    	Student str = new Student();
    	str.setStudentID("B234567");
    	str.setFirstName("Kittipat");
    	str.setLastName("Sriwong");
    	str.setGrade(Grade.valueOf("GRADE_7")); 
    	str.setNumberOfActivity(10);
		str.persist();

		AnnouncementOfActivity aoa = new AnnouncementOfActivity();
		aoa.setAnnouncementOfActivityID("A12345");
		aoa.setAnnouncementOfActivityName("Science Camp #1");
		aoa.setAnnouncementOfActivityRemain(50);
		aoa.persist();

		RegisterOfActivity roa = new RegisterOfActivity();
		roa.setStudent(str);
		roa.setRegisterOfActivityID("A12345P01");
		roa.setAnnouncementOfActivity(aoa);
		roa.setStatus(true);
		
		try{
    	    roa.persist();
    	  Assert.fail();
    	}
    	catch(javax.validation.ConstraintViolationException e){}
    }
}

