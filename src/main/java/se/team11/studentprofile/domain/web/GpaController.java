package se.team11.studentprofile.domain.web;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import se.team11.studentprofile.domain.Gpa;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RequestMapping("/gpas")
@Controller
@RooWebScaffold(path = "gpas", formBackingObject = Gpa.class)
@RooWebFinder
public class GpaController {
}
