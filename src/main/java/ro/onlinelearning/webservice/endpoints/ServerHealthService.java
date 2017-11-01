package ro.onlinelearning.webservice.endpoints;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@Controller
public class ServerHealthService {

    @RequestMapping("/_ah/health")
    public String healthy() {
        // Message body required though ignored
        return "Still surviving.";
    }
}
