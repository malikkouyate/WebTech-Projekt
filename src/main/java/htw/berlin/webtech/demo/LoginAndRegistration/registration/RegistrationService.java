package htw.berlin.webtech.demo.LoginAndRegistration.registration;

import htw.berlin.webtech.demo.LoginAndRegistration.appuser.AppUser;
import htw.berlin.webtech.demo.LoginAndRegistration.appuser.AppUserRole;
import htw.berlin.webtech.demo.LoginAndRegistration.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {

        boolean isValidEmail = emailValidator.test(request.getEmail());

        if (!isValidEmail){
            throw new IllegalStateException("email not valid");
        }

        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }
}
