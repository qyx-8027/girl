package templates;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloTemplates {

    @RequestMapping(value = "/helloTemplates",method = RequestMethod.GET)
    public String HelloTemplates() {
        return "helloTemplates";
    }
}
