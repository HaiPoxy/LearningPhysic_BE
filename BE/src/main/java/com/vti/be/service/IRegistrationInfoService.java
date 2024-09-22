package com.vti.be.service;

import java.util.List;

import com.vti.be.dto.CourseDTO;
import com.vti.be.dto.RegistrationInfoDTO;

public interface IRegistrationInfoService {

  List<RegistrationInfoDTO> getAllRegistrationInfos();

  RegistrationInfoDTO getRegistrationInfoById(Integer id);

  RegistrationInfoDTO createRegistrationInfo(RegistrationInfoDTO registrationInfoDTO);

  CourseDTO updateRegistrationInfo(Integer id, RegistrationInfoDTO registrationInfoDTO);

  void deleteRegistrationInfo(Integer id);
}
