//package htw.berlin.webtech.demo;
//
//import htw.berlin.webtech.demo.LoginAndRegistration.appuser.AppUser;
//import htw.berlin.webtech.demo.LoginAndRegistration.appuser.AppUserRole;
//import org.junit.jupiter.api.Test;
//
//import static htw.berlin.webtech.demo.LoginAndRegistration.appuser.AppUserRole.USER;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class AppUserTest {
//    @Test
//    void TestToString(){
//        Long id = 4L;
//        String firstname = "Malik";
//        String lastname = "Kouyaté";
//        String email = "bartuinator@gmail.com";
//        String password = "Bartu123";
//        AppUserRole appUserRole = USER;
//
//
//        AppUser appUser = new AppUser(id,firstname,lastname,email,password,appUserRole);
//
//
//
//        String expected = "AppUser{id=4, firstname='Malik', lastname='Kouyaté', email='bartuinator@gmail.com', password='Bartu123', appUserRole=USER}";
//
//        String actual = appUser.toString();
//
//        assertEquals(expected,actual);
//    }
//}
