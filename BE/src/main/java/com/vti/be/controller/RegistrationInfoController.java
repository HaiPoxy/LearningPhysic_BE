package com.vti.be.controller;

import com.vti.be.dto.CourseDTO;
import com.vti.be.dto.RegistrationInfoDTO;
import com.vti.be.service.RegistrationInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registrationInfos")
public class RegistrationInfoController {

  private final RegistrationInfoService registrationInfoService;

  public RegistrationInfoController(RegistrationInfoService registrationInfoService) {
    this.registrationInfoService = registrationInfoService;
  }

  @GetMapping
  public ResponseEntity<List<RegistrationInfoDTO>> getAllRegistrationInfos() {
    List<RegistrationInfoDTO> registrationInfos = registrationInfoService.getAllRegistrationInfos();
    return ResponseEntity.ok(registrationInfos);
  }

  @GetMapping("/{id}")
  public ResponseEntity<RegistrationInfoDTO> getRegistrationInfoById(@PathVariable Integer id) {
    RegistrationInfoDTO registrationInfo = registrationInfoService.getRegistrationInfoById(id);
    if (registrationInfo != null) {
      return ResponseEntity.ok(registrationInfo);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping
  public ResponseEntity<RegistrationInfoDTO> createRegistrationInfo(
      @RequestBody RegistrationInfoDTO registrationInfoDTO) {
    RegistrationInfoDTO createdRegistrationInfo = registrationInfoService.createRegistrationInfo(registrationInfoDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdRegistrationInfo);
  }

  @PutMapping("/{id}")
  public ResponseEntity<CourseDTO> updateRegistrationInfo(@PathVariable Integer id,
      @RequestBody RegistrationInfoDTO registrationInfoDTO) {
    CourseDTO updatedCourse = registrationInfoService.updateRegistrationInfo(id, registrationInfoDTO);
    return ResponseEntity.ok(updatedCourse);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteRegistrationInfo(@PathVariable Integer id) {
    registrationInfoService.deleteRegistrationInfo(id);
    return ResponseEntity.noContent().build();
  }
}