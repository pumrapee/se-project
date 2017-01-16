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
public class Breakage {

    /**
     */
    @ManyToOne
    private Student stdname;

    /**
     */
    @NotNull
    @Size(min = 4, max = 250)
    private String list;

    /**
     */
    @NotNull
    private Float price;

    /**
     */
    private Boolean status;
}
