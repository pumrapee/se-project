package se.team11.studentprofile.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@RooJavaBean
@RooToString
@RooJpaActiveRecord
public class Cashier {

    /**
     */
    @ManyToOne
    private Student stdname;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<HealthCareHistory> healhistory = new HashSet<HealthCareHistory>();

    /**
     */
    @NotNull
    private String billid;

    /**
     */
    private Float paytotal;

    /**
     */
    private Boolean status;
}
