package se.team11.studentprofile.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Fixstudentstatus {

    /**
     */
    @ManyToOne
    private Studentstatuscheck studentstatus;

    /**
     */
    @NotNull
    @Size(min = 2, max = 500)
    private String fixstatusinfo;
}
