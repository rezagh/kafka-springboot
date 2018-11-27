package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import hello.MySender;

@RestController
public class HelloController {
    
	@Autowired
	MySender sender ; 
	
    @RequestMapping("/{msg}")
    public String index(@PathVariable String msg) {
    	sender.sendMessage(msg);
        return "Greetings from Spring Boot!";
    }
    
}
