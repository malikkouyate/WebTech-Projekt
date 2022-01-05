//package htw.berlin.webtech.demo.Mileston2.web;
//
//
//import htw.berlin.webtech.demo.Mileston2.service.ObjectService;
//import htw.berlin.webtech.demo.Mileston2.web.api.Object;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.List;
//
//import static org.mockito.Mockito.doReturn;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(ObjectRestController.class)
//class ObjectRestControllerTest {
//
//    @Autowired
//    private MockMvc mockmvc;
//
//    @MockBean
//    private ObjectService objectService;
//
//    @Test
//    @DisplayName("should return found objects from object service")
//    void should_return_found_objects_from_object_service() throws Exception {
//        // given
//
//        var objects = List.of(
//                new Object(1,"PC",2000,"linktest"),
//                new Object(2,"TV",500,"linktest123")
//        );
//        doReturn(objects).when(objectService).findAll();
//
//        // when
//         mockmvc.perform(get("/api/v1/registration/objects"))
//
//                //then
//                 .andExpect(status().isOk())
//                 .andExpect(jsonPath("$.size()").value(2))
//                 .andExpect(jsonPath("$[0].id").value(1))
//                 .andExpect(jsonPath("$[0].objectname").value("PC"))
//                 .andExpect(jsonPath("$[0].price").value(2000))
//                 .andExpect(jsonPath("$[0].link").value("linktest"))
//                 .andExpect(jsonPath("$[1].id").value(2))
//                 .andExpect(jsonPath("$[1].objectname").value("TV"))
//                 .andExpect(jsonPath("$[1].price").value(500))
//                 .andExpect(jsonPath("$[1].link").value("linktest123"));
//
//    }
//
//}
