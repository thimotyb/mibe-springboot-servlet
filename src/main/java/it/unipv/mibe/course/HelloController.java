package it.unipv.mibe.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unipv.mibe.dao.PersonDAO;
import it.unipv.mibe.entity.Person;

@Controller
public class HelloController {
	
	@Autowired
	PersonDAO personDAO;
	
	
    @RequestMapping("/gethello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }
    
    @ResponseBody
    @RequestMapping("/getpersonlist")
    public String index() {
        Iterable<Person> all = personDAO.findAll();
 
        StringBuilder sb = new StringBuilder();
 
        all.forEach(p -> sb.append(p.getFullName() + "<br>"));
 
        return sb.toString();
    }
    
}
