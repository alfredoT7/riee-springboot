package com.fredodev.consultorioriee.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class HelloController {
    @Autowired
    private SessionRegistry sessionRegistry;

    @GetMapping("/hello")
    public String greeting() {
        return "Hello World!";
    }

    @GetMapping("/hell")
    public String hollo() {
        return "Hello World!";
    }

    @GetMapping("/session")
    public ResponseEntity<?> getDetailSession(){
        String sesionId = "";
        User userObject = null;
        List<Object>  sessions = sessionRegistry.getAllPrincipals();
        for(Object session : sessions){
            if(session instanceof User){
                userObject= (User) session;
            }
            List<SessionInformation> sessionInformations = sessionRegistry.getAllSessions(session,false);
            for (SessionInformation sessionInformation : sessionInformations){
                sesionId = sessionInformation.getSessionId();
            }
        }
        Map<String,Object> response = new HashMap<>();
        response.put("response","Hello world");
        response.put("sesionId", sesionId);
        response.put("sessionUser", userObject);
        return ResponseEntity.ok(response);
    }


}
