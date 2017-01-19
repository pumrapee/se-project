package se.team11.studentprofile.domain;
import org.junit.Test;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.test.RooIntegrationTest;
import java.util.HashSet; 
import java.util.Set; 
import org.junit.Assert;
import java.util.Date;

@RooIntegrationTest(entity = Cashier.class)
public class CashierIntegrationTest {

    @Test
    public void testPass() {
    	Student stu = new Student();
    	stu.setStudentID("1234567");
    	stu.setFirstName("Vechavit");
    	stu.setLastName("Jutangura");
    	stu.setGrade(Grade.valueOf("GRADE_8"));
    	stu.setNumberOfActivity(123);
    	stu.persist();

    	HealthCareHistory hc = new HealthCareHistory();
    	hc.setStudent(stu);
    	hc.setInfo("asdf");
    	Date date = new Date();
    	date.setDate(9);
    	date.setMonth(7);
    	date.setYear(1995);
    	hc.setCureDate(date);
    	hc.persist();

		Cashier cash = new Cashier();
		cash.setStdname(stu);
		Set<HealthCareHistory> hch = new HashSet<HealthCareHistory>();
		hch.add(hc);
		cash.setHealhistory(hch);
		cash.setBillid("12345");
		cash.setPaytotal((float)123.02);
		cash.setStatus(false);
		cash.persist();

        Assert.assertEquals("12345",cash.getBillid());

    }
     @Test //fail 1
    public void testnull() {
    	Student stu = new Student();
    	stu.setStudentID("1234567");
    	stu.setFirstName("Vechavit");
    	stu.setLastName("Jutangura");
    	stu.setGrade(Grade.valueOf("GRADE_8"));
    	stu.setNumberOfActivity(123);
    	stu.persist();

    	HealthCareHistory hc = new HealthCareHistory();
    	hc.setStudent(stu);
    	hc.setInfo("asdf");
    	Date date = new Date();
    	date.setDate(9);
    	date.setMonth(7);
    	date.setYear(1995);
    	hc.setCureDate(date);
    	hc.persist();
    	try{
		Cashier cash = new Cashier();
		cash.setStdname(stu);
		Set<HealthCareHistory> hch = new HashSet<HealthCareHistory>();
		hch.add(hc);
		cash.setHealhistory(hch);
		cash.setPaytotal((float)123.02);
		cash.setStatus(false);
		cash.persist();
		}catch(javax.validation.ConstraintViolationException e){
			//pass
		}
	}
	@Test // fail 2
    public void testbilllessthan5() {
    	Student stu = new Student();
    	stu.setStudentID("1234567");
    	stu.setFirstName("Vechavit");
    	stu.setLastName("Jutangura");
    	stu.setGrade(Grade.valueOf("GRADE_8"));
    	stu.setNumberOfActivity(123);
    	stu.persist();

    	HealthCareHistory hc = new HealthCareHistory();
    	hc.setStudent(stu);
    	hc.setInfo("asdf");
    	Date date = new Date();
    	date.setDate(9);
    	date.setMonth(7);
    	date.setYear(1995);
    	hc.setCureDate(date);
    	hc.persist();
    	try{
		Cashier cash = new Cashier();
		cash.setStdname(stu);
		Set<HealthCareHistory> hch = new HashSet<HealthCareHistory>();
		hch.add(hc);
		cash.setHealhistory(hch);
		cash.setBillid("12");
		cash.setPaytotal((float)123.02);
		cash.setStatus(false);
		cash.persist();
		}catch(javax.validation.ConstraintViolationException e){
			//pass
		}

    }
    @Test //fail 3
    public void testbilllongthan5() {
    	Student stu = new Student();
    	stu.setStudentID("1234567");
    	stu.setFirstName("Vechavit");
    	stu.setLastName("Jutangura");
    	stu.setGrade(Grade.valueOf("GRADE_8"));
    	stu.setNumberOfActivity(123);
    	stu.persist();

    	HealthCareHistory hc = new HealthCareHistory();
    	hc.setStudent(stu);
    	hc.setInfo("asdf");
    	Date date = new Date();
    	date.setDate(9);
    	date.setMonth(7);
    	date.setYear(1995);
    	hc.setCureDate(date);
    	hc.persist();
    	try{
		Cashier cash = new Cashier();
		cash.setStdname(stu);
		Set<HealthCareHistory> hch = new HashSet<HealthCareHistory>();
		hch.add(hc);
		cash.setHealhistory(hch);
		cash.setBillid("123456789");
		cash.setPaytotal((float)123.02);
		cash.setStatus(false);
		cash.persist();
		}catch(javax.validation.ConstraintViolationException e){
			//pass
		}

    }
   
}
