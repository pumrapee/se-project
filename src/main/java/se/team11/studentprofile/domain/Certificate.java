package se.team11.studentprofile.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Certificate {

    /**
     */
    @ManyToOne
    private Student Student;

    /**
     */
    @NotNull
    private String CertificateID;

    /**
     */
    @NotNull
    private String CertificateName;

    /**
     */
    @ManyToOne
    private HistoryInActivity HistoryInActivity;
}
