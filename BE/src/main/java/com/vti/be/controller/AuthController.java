//package com.vti.be.controller;
//
//
//
//import com.vti.be.form.AuthRegisterForm;
//import com.vti.be.form.ChangePasswordForm;
//import com.vti.be.service.IAuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@RequestMapping("/api/v1/auth")
//public class AuthController {
//    private final IAuthService service;
//
//    @Autowired
//    public AuthController(IAuthService service) {
//        this.service = service;
//    }
//
//    @PostMapping("/register")
//    public void create(@RequestBody AuthRegisterForm form) {
//        service.create(form);
//    }
//
//    @GetMapping("/send-to-email")
//    public ResponseEntity<String> sendToEmail(@RequestParam("email") String email) {
//        return service.sendToEmail(email);
//    }
//
//
//
//    @PostMapping("/reset-password")
//    public ResponseEntity<String> resetPassword(@RequestParam("token") String token,@RequestBody ChangePasswordForm form) {
//        try {
//            form.setToken(token);
//            service.resetPassword(form);
//            return ResponseEntity.ok("Change Password successful!");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//        }
//    }
//
////    @PostMapping("/change-password")
////    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordForm form) {
////        try {
////
////            return service.changePassword(form);
////        } catch (Exception e) {
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
////        }
////    }
//}