package com.jpgough.websocket.server.health;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")

    public ResponseEntity<Void> health() {
        return new ResponseEntity("Service Available", HttpStatus.OK);
    }
}
