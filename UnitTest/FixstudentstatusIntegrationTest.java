package se.team11.studentprofile.domain;
import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;
import org.junit.Assert;

@RooIntegrationTest(entity = Fixstudentstatus.class)
public class FixstudentstatusIntegrationTest {

    @Test
    public void testFixstudentstatusPass() {
    	Fixstudentstatus fss = new Fixstudentstatus();
    	Studentstatuscheck ssc = new Studentstatuscheck();
    	fss.setStudentstatus(ssc);
    	fss.setFixstatusinfo("aaa");
    	fss.persist();
    }

    @Test
    public void testFixstatusinfoIsNull() {
    	Fixstudentstatus fss = new Fixstudentstatus();
    	Studentstatuscheck ssc = new Studentstatuscheck();
    	fss.setStudentstatus(ssc);
    	try{
    	fss.persist();}
    	catch(javax.validation.ConstraintViolationException e){
    		//pass
    	}
    }
    
    @Test
    public void testFixstatusinfoIsLessThan2() {
    	Fixstudentstatus fss = new Fixstudentstatus();
    	Studentstatuscheck ssc = new Studentstatuscheck();
    	fss.setStudentstatus(ssc);
    	fss.setFixstatusinfo("1");
    	try{
    	fss.persist();
    	}catch(javax.validation.ConstraintViolationException e){
    		//pass
    	}
    }

    @Test
    public void testFixstatusinfoIsMoreThan500() {
    	Fixstudentstatus fss = new Fixstudentstatus();
    	Studentstatuscheck ssc = new Studentstatuscheck();
    	fss.setStudentstatus(ssc);
    	fss.setFixstatusinfo("012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789");
    	try{
    	fss.persist();
    	}catch(javax.validation.ConstraintViolationException e){
    		//pass
    	}
    }
    
}
