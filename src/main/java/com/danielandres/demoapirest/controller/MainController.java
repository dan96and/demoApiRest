package com.danielandres.demoapirest.controller;

import com.danielandres.demoapirest.domain.User;
import com.danielandres.demoapirest.util.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class MainController {

    //Request GET -> Body response and httpStatus OK
    @GetMapping("/prueba")
    public ResponseEntity<String> hola() {
        return new ResponseEntity<>("HOLA", HttpStatus.OK);
    }

    //Request GET -> Response user and httpStatus OK
    @GetMapping("/prueba2")
    public ResponseEntity<User> hola2() {
        User u = User.builder().name("Daniel").surname("Andres").build();
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    //Request GET, utilizando ExceptionHandler + ResponseUtil
    @GetMapping("/pruebaExcepcion2")
    public ResponseEntity<User> pruebaExcepcion() {
        User u = User.builder().name("Federico").surname("Garcia").build();
        if (true) {
            throw new IllegalArgumentException("Ejemplo de excepcion 1");
        }
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseUtil> handleException(IllegalArgumentException iae) {
        ResponseUtil response = ResponseUtil.builder().
                errorCode(ResponseUtil.NOT_FOUND).message(iae.getMessage()).build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    //Request GET, utilizando un ControllerAdvice + ResponseUtil
    @GetMapping("/pruebaExcepcion3")
    public ResponseEntity<User> pruebaExcepcion2() {
        User u = User.builder().name("Carlos").build();
        if (true) {
            throw new ArithmeticException("Ejemplo de excepcion ASPECTOS");
        }
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    //Request GET, utilizando un ResponseStatusException
    @GetMapping("/greeting")
    public ResponseEntity<ResponseUtil> greeting(@RequestParam(value = "name", required = false) String name) {
        if (name == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El parametro 'name' es obligatorio");
        }
        return new ResponseEntity<>(ResponseUtil.builder().errorCode(ResponseUtil.NO_ERROR).message("Respuesta correcta").build(), HttpStatus.OK);
    }
}
