package ro.onlinelearning.webservice.endpoints;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ro.onlinelearning.webservice.commons.User;
import ro.onlinelearning.webservice.dao.UsersRepository;

@CrossOrigin(origins = "*")
@RestController
@Controller
public class AuthenticationService {

    @RequestMapping(value = "/users/register", produces = {"application/json"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> registerUser(@RequestParam(value = "email", required = true) String email
            , @RequestParam(value = "first-name") String firstName
            , @RequestParam(value = "last-name") String lastName
            , @RequestParam(value = "phone-number") String phoneNumber
            , @RequestParam(value = "password") String password
            , @RequestParam(value = "city") String city
    ) {
        User user = new User();
        user.setEmailAddress(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPhoneNumber(phoneNumber);
        user.setCity(city);
        user.setPassword(password);

        if (UsersRepository.registerUser(user))
            return ResponseEntity.ok("ok");
        else
            return ResponseEntity.ok("nok");
    }

}
