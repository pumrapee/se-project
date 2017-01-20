package se.team11.studentprofile.domain;
import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;
import org.junit.Assert;

@RooIntegrationTest(entity = HealthFee.class)
public class HealthFeeIntegrationTest {
	


    @Test
    public void HealthFeePass() {
    Student st = new Student();
	st.setStudentID("1234567");
	st.setFirstName("Suriyapon");
	st.setLastName("Sasivimollit");
	st.setGrade(Grade.valueOf("GRADE_7")); 
	st.setNumberOfActivity(10);
    st.persist();

    HealthFee hf = new HealthFee();
    hf.setStudent(st);
    hf.setType("Normal");
    hf.setFeeDiscount(2500);
    hf.persist();

    }

    @Test
    public void HealthFeeNoStudent() {
    Student st = new Student();
	st.setStudentID("1234567");
	st.setFirstName("Suriyapon");
	st.setLastName("Sasivimollit");
	st.setGrade(Grade.valueOf("GRADE_7")); 
	st.setNumberOfActivity(10);
    st.persist();

    HealthFee hf = new HealthFee();
    hf.setType("Normal");
    hf.setFeeDiscount(2500);

    try{
    hf.persist();
    Assert.fail();
	}catch(javax.validation.ConstraintViolationException e){

	}

    }

    @Test
    public void HealthFeeTypeTooShort() {
    Student st = new Student();
	st.setStudentID("1234567");
	st.setFirstName("Suriyapon");
	st.setLastName("Sasivimollit");
	st.setGrade(Grade.valueOf("GRADE_7")); 
	st.setNumberOfActivity(10);
    st.persist();

    HealthFee hf = new HealthFee();
    hf.setStudent(st);
    hf.setType("Norm");
    hf.setFeeDiscount(2500);

    try{
    hf.persist();
    Assert.fail();
	}catch(javax.validation.ConstraintViolationException e){

	}

    }

    @Test
    public void HealthFeeTooLong() {
    Student st = new Student();
	st.setStudentID("1234567");
	st.setFirstName("Suriyapon");
	st.setLastName("Sasivimollit");
	st.setGrade(Grade.valueOf("GRADE_7")); 
	st.setNumberOfActivity(10);
    st.persist();


    HealthFee hf = new HealthFee();
    hf.setStudent(st);
    hf.setType("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
    hf.setFeeDiscount(2500);

    try{
    hf.persist();
    Assert.fail();
	}catch(javax.validation.ConstraintViolationException e){

	}

    }
}
