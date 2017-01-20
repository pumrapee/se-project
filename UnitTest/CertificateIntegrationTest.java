package se.team11.studentprofile.domain;
import org.junit.Test;
import org.junit.Assert;
import java.util.HashSet; 
import java.util.Set; 
import org.springframework.roo.addon.test.RooIntegrationTest;

@RooIntegrationTest(entity = Certificate.class)
public class CertificateIntegrationTest {

    @Test
    public void DatatestInputPass() {
    	Student str = new Student();
    	str.setStudentID("1234567");
    	str.setFirstName("Kittipat");
    	str.setLastName("Sriwong");
    	str.setGrade(Grade.valueOf("GRADE_7")); 
    	str.setNumberOfActivity(10);
		str.persist();

		Activity act = new Activity();
    	act.setActivityID("123456");
    	act.setActivityName("gotosea");
    	act.persist();

    	HistoryInActivity hia = new HistoryInActivity();
    	hia.setStudent(str);
    	hia.setHistoryID("12345678");
    	Set<Activity> acth = new HashSet<Activity>();
    	acth.add(act);
    	hia.setActivity(acth);
    	hia.persist();

    	Certificate c1 = new Certificate();
    	c1.setStudent(str);
    	c1.setCertificateID("C1234567");
    	c1.setCertificateName("Certificate Rank 1");
    	c1.setHistoryInActivity(hia);
    	c1.persist();
    	Assert.assertEquals("C1234567",c1.getCertificateID());
	}
	@Test
    public void DatatestInputCertificateIDMoreThanEight() {
    	Student str = new Student();
    	str.setStudentID("1234567");
    	str.setFirstName("Kittipat");
    	str.setLastName("Sriwong");
    	str.setGrade(Grade.valueOf("GRADE_7")); 
    	str.setNumberOfActivity(10);
		str.persist();

		Activity act = new Activity();
    	act.setActivityID("123456");
    	act.setActivityName("gotosea");
    	act.persist();

    	HistoryInActivity hia = new HistoryInActivity();
    	hia.setStudent(str);
    	hia.setHistoryID("12345678");
    	Set<Activity> acth = new HashSet<Activity>();
    	acth.add(act);
    	hia.setActivity(acth);
    	hia.persist();

    	Certificate c1 = new Certificate();
    	c1.setStudent(str);
    	c1.setCertificateID("C12345678");
    	c1.setCertificateName("Certificate Rank 1");
    	c1.setHistoryInActivity(hia);
    	try{
    	    c1.persist();
    	    Assert.fail();
    	}
    	catch(javax.validation.ConstraintViolationException e){}
    }
	@Test
    public void DatatestInputCertificateIDNULL() {
    	Student str = new Student();
    	str.setStudentID("1234567");
    	str.setFirstName("Kittipat");
    	str.setLastName("Sriwong");
    	str.setGrade(Grade.valueOf("GRADE_7")); 
    	str.setNumberOfActivity(10);
		str.persist();

		Activity act = new Activity();
    	act.setActivityID("123456");
    	act.setActivityName("gotosea");
    	act.persist();

    	HistoryInActivity hia = new HistoryInActivity();
    	hia.setStudent(str);
    	hia.setHistoryID("12345678");
    	Set<Activity> acth = new HashSet<Activity>();
    	acth.add(act);
    	hia.setActivity(acth);
    	hia.persist();

    	Certificate c1 = new Certificate();
    	c1.setStudent(str);
    	
    	c1.setCertificateName("Certificate Rank 1");
    	c1.setHistoryInActivity(hia);
    	try{
    	    c1.persist();
    	    Assert.fail();
    	}
    	catch(javax.validation.ConstraintViolationException e){}
	}
	@Test
    public void DatatestInputCertificateIDUnique() {
    	Student str = new Student();
    	str.setStudentID("1234567");
    	str.setFirstName("Kittipat");
    	str.setLastName("Sriwong");
    	str.setGrade(Grade.valueOf("GRADE_7")); 
    	str.setNumberOfActivity(10);
		str.persist();

		Activity act = new Activity();
    	act.setActivityID("123456");
    	act.setActivityName("gotosea");
    	act.persist();

    	HistoryInActivity hia = new HistoryInActivity();
    	hia.setStudent(str);
    	hia.setHistoryID("12345678");
    	Set<Activity> acth = new HashSet<Activity>();
    	acth.add(act);
    	hia.setActivity(acth);
    	hia.persist();

    	Certificate c1 = new Certificate();
		c1.setStudent(str);
    	c1.setCertificateID("C1234567");
    	c1.setCertificateName("Certificate Rank 1");
    	c1.setHistoryInActivity(hia);
    	c1.persist();
    	c1.flush();
    	try{
    		Certificate c2 = new Certificate();
			c2.setStudent(str);
    		c2.setCertificateID("C1234567");
    		c2.setCertificateName("Certificate Rank 1");
    		c2.setHistoryInActivity(hia);
    		c2.persist();
    	    Assert.fail();
    	}
    	catch(org.springframework.orm.jpa.JpaSystemException e){}
	}
}
