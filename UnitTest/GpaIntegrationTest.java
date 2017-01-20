package se.team11.studentprofile.domain;
import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;
import java.util.HashSet; 
import java.util.Set; 
import java.util.Calendar; 
import org.junit.Assert;

@RooIntegrationTest(entity = Gpa.class)
public class GpaIntegrationTest {

    @Test
    public void gpaTestPassInput() {
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

        Assert.assertEquals("123456", gpa.getGradeID());
        Assert.assertEquals(str, gpa.getStudent());
        Assert.assertEquals(subh, gpa.getSubject());
        Assert.assertEquals(Semester.valueOf("SEMESTER_2"), gpa.getSemester());
        Assert.assertEquals(cal, gpa.getSchoolYear());
        Float num = new Float(4.00);
        Assert.assertEquals(num, gpa.getGpaPoint());
    }

    @Test
    public void gpaTestOverGradeInput() {
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
        gpa.setGradeID("12345678");
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
        try{
            gpa.persist();
            Assert.fail();
        }
        catch (javax.validation.ConstraintViolationException e){

        }
    }

    @Test
    public void gpaTestNoSubjectInput() {
        Student str = new Student();
        str.setStudentID("1234567");
        str.setFirstName("Pumrapee");
        str.setLastName("Poomka");
        str.setGrade(Grade.valueOf("GRADE_7")); 
        str.setNumberOfActivity(10);
        str.persist();
        
        Gpa gpa = new Gpa();
        gpa.setGradeID("12345678");
        gpa.setStudent(str);
        gpa.setSemester(Semester.valueOf("SEMESTER_2"));
        Calendar cal = Calendar.getInstance(); 
        cal.set(Calendar.YEAR, 2017);
        gpa.setSchoolYear(cal);
        gpa.setGpaPoint((float)4.00);
        try{
            gpa.persist();
            Assert.fail();
        }
        catch (javax.validation.ConstraintViolationException e){

        }
    }

    @Test
    public void gpaTestNoStudentInput() {
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
        gpa.setGradeID("12345678");
        Set<Subject> subh = new HashSet<Subject>();
        subh.add(sub1);
        subh.add(sub2);
        gpa.setSubject(subh);
        gpa.setSemester(Semester.valueOf("SEMESTER_2"));
        Calendar cal = Calendar.getInstance(); 
        cal.set(Calendar.YEAR, 2017);
        gpa.setSchoolYear(cal);
        gpa.setGpaPoint((float)4.00);
        try{
            gpa.persist();
            Assert.fail();
        }
        catch (javax.validation.ConstraintViolationException e){

        }
    }
}