package com.vti.be.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class RegistrationInfoDTO {
  private Integer id;
  private String fullName;
  private String phoneNumber;
  private String selectedClass;
  private String additionalRequests;
  private String accountFullName;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

}
