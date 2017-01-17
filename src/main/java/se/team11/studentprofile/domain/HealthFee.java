package se.team11.studentprofile.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class HealthFee {

    /**
     */
    @ManyToOne
    @NotNull
    private Student Student;

    /**
     */
    @NotNull
    @Size(min = 5, max = 50)
    private String Type;

    /**
     */
    @NotNull
    private Integer FeeDiscount;
}
