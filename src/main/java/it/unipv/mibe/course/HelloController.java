package it.unipv.mibe.course;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.unipv.mibe.dao.PersonDAO;
import it.unipv.mibe.entity.Person;

@RestController
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
    
    @PostMapping("/addperson")
    public String addPerson(@RequestBody Person p) {
    	
    	System.out.println("Posted person: "+p.getFullName());
    	p = personDAO.save(p);
    	
    	return "{ \"message\": \"Created person "+p.getId()+".\"}";
    }
    
}
