package se.team11.studentprofile.domain;
import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;
import java.util.HashSet; 
import java.util.Set; 
import java.util.Calendar; 
import org.junit.Assert;

@RooIntegrationTest(entity = Gpax.class)
public class GpaxIntegrationTest {

   @Test
    public void gpaxTestPassInput() {
    	Student str = new Student();
    	str.setStudentID("1234567");
    	str.setFirstName("Pumrapee");
    	str.setLastName("Poomka");
    	str.setGrade(Grade.valueOf("GRADE_7")); 
    	str.setNumberOfActivity(10);
    	str.persist();

    	Subject sub1 = new Subject();
    	sub1.setSubjectID("123456");
    	sub1.setSubjectName("Software Engineering");
    	sub1.setWeight(4);
    	sub1.persist();

    	Subject sub2 = new Subject();
    	sub2.setSubjectID("654321");
    	sub2.setSubjectName("Data Analysis");
    	sub2.setWeight(4);
    	sub2.persist();

    	Gpa gpa = new Gpa();
    	gpa.setGradeID("123456");
    	gpa.setStudent(str);
    	Set<Subject> subh = new HashSet<Subject>(); 
    	subh.add(sub1);
    	subh.add(sub2);
    	gpa.setSubject(subh);
    	gpa.setSemester(Semester.valueOf("SEMESTER_2")); 
    	Calendar cal = Calendar.getInstance(); 
    	cal.set(Calendar.YEAR, 2017);
    	gpa.setSchoolYear(cal); 
    	gpa.setGpaPoint((float)4.00);
    	gpa.persist();

    	Gpax gpax = new Gpax();
    	gpax.setGpaxID("123456");
    	Set<Gpa> gpah = new HashSet<Gpa>();
    	gpah.add(gpa);
    	gpax.setGpa(gpah);
    	gpax.setGpaxPoint((float)4.00);
    	gpax.persist();

        Assert.assertEquals("123456", gpax.getGpaxID());
        Assert.assertEquals(gpah, gpax.getGpa());
        Float num = new Float(4.00);
        Assert.assertEquals(num, gpax.getGpaxPoint());
    }

    @Test
    public void gpaxTestLongGpaxID() {
    	Student str = new Student();
    	str.setStudentID("1234567");
    	str.setFirstName("Pumrapee");
    	str.setLastName("Poomka");
    	str.setGrade(Grade.valueOf("GRADE_7")); 
    	str.setNumberOfActivity(10);
    	str.persist();

    	Subject sub1 = new Subject();
    	sub1.setSubjectID("123456");
    	sub1.setSubjectName("Software Engineering");
    	sub1.setWeight(4);
    	sub1.persist();

    	Subject sub2 = new Subject();
    	sub2.setSubjectID("654321");
    	sub2.setSubjectName("Data Analysis");
    	sub2.setWeight(4);
    	sub2.persist();

    	Gpa gpa = new Gpa();
    	gpa.setGradeID("123456");
    	gpa.setStudent(str);
    	Set<Subject> subh = new HashSet<Subject>(); 
    	subh.add(sub1);
    	subh.add(sub2);
    	gpa.setSubject(subh);
    	gpa.setSemester(Semester.valueOf("SEMESTER_2")); 
    	Calendar cal = Calendar.getInstance(); 
    	cal.set(Calendar.YEAR, 2017);
    	gpa.setSchoolYear(cal); 
    	gpa.setGpaPoint((float)4.00);
    	gpa.persist();

    	Gpax gpax = new Gpax();
    	gpax.setGpaxID("1234567");
    	Set<Gpa> gpah = new HashSet<Gpa>();
    	gpah.add(gpa);
    	gpax.setGpa(gpah);
    	gpax.setGpaxPoint((float)4.00);
    	try{
    		gpax.persist();
    		Assert.fail();
    	}
    	catch(javax.validation.ConstraintViolationException e){

    	}
    }

    @Test
    public void gpaxTestNoGpaxIDInput() {
    	Student str = new Student();
    	str.setStudentID("1234567");
    	str.setFirstName("Pumrapee");
    	str.setLastName("Poomka");
    	str.setGrade(Grade.valueOf("GRADE_7")); 
    	str.setNumberOfActivity(10);
    	str.persist();

    	Subject sub1 = new Subject();
    	sub1.setSubjectID("123456");
    	sub1.setSubjectName("Software Engineering");
    	sub1.setWeight(4);
    	sub1.persist();

    	Subject sub2 = new Subject();
    	sub2.setSubjectID("654321");
    	sub2.setSubjectName("Data Analysis");
    	sub2.setWeight(4);
    	sub2.persist();

    	Gpa gpa = new Gpa();
    	gpa.setGradeID("123456");
    	gpa.setStudent(str);
    	Set<Subject> subh = new HashSet<Subject>(); 
    	subh.add(sub1);
    	subh.add(sub2);
    	gpa.setSubject(subh);
    	gpa.setSemester(Semester.valueOf("SEMESTER_2")); 
    	Calendar cal = Calendar.getInstance(); 
    	cal.set(Calendar.YEAR, 2017);
    	gpa.setSchoolYear(cal); 
    	gpa.setGpaPoint((float)4.00);
    	gpa.persist();

    	Gpax gpax = new Gpax();
    	Set<Gpa> gpah = new HashSet<Gpa>();
    	gpah.add(gpa);
    	gpax.setGpa(gpah);
    	gpax.setGpaxPoint((float)4.00);
    	try{
    		gpax.persist();
    		Assert.fail();
    	}
    	catch(javax.validation.ConstraintViolationException e){

    	}
    }

    @Test
    public void gpaxTestNoGpaxPointInput() {
    	Student str = new Student();
    	str.setStudentID("1234567");
    	str.setFirstName("Pumrapee");
    	str.setLastName("Poomka");
    	str.setGrade(Grade.valueOf("GRADE_7")); 
    	str.setNumberOfActivity(10);
    	str.persist();

    	Subject sub1 = new Subject();
    	sub1.setSubjectID("123456");
    	sub1.setSubjectName("Software Engineering");
    	sub1.setWeight(4);
    	sub1.persist();

    	Subject sub2 = new Subject();
    	sub2.setSubjectID("654321");
    	sub2.setSubjectName("Data Analysis");
    	sub2.setWeight(4);
    	sub2.persist();

    	Gpa gpa = new Gpa();
    	gpa.setGradeID("123456");
    	gpa.setStudent(str);
    	Set<Subject> subh = new HashSet<Subject>(); 
    	subh.add(sub1);
    	subh.add(sub2);
    	gpa.setSubject(subh);
    	gpa.setSemester(Semester.valueOf("SEMESTER_2")); 
    	Calendar cal = Calendar.getInstance(); 
    	cal.set(Calendar.YEAR, 2017);
    	gpa.setSchoolYear(cal); 
    	gpa.setGpaPoint((float)4.00);
    	gpa.persist();

    	Gpax gpax = new Gpax();
    	gpax.setGpaxID("123456");
    	Set<Gpa> gpah = new HashSet<Gpa>();
    	gpah.add(gpa);
    	gpax.setGpa(gpah);
    	try{
    		gpax.persist();
    		Assert.fail();
    	}
    	catch(javax.validation.ConstraintViolationException e){

    	}
    }
}
