package se.team11.studentprofile.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Certificate {

    /**
     */
    @NotNull
    @ManyToOne
    private Student Student;

    /**
     */
    @NotNull
    @Column(unique = true)    
    @Size(min = 8, max = 8)
    private String CertificateID;

    /**
     */
    @NotNull
    private String CertificateName;

    /**
     */
    @NotNull
    @ManyToOne
    private HistoryInActivity HistoryInActivity;
}
