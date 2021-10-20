package htw.berlin.webtech.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public class HelloWorldController {

    @GetMapping(path = "/")
    public ModelAndView showHelloWorld(){
        return new ModelAndView("helloworld");
    }
}
//jvvhvsx