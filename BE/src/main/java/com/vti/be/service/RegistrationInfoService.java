package com.vti.be.service;

import com.vti.be.dto.CourseDTO;
import com.vti.be.dto.RegistrationInfoDTO;
import com.vti.be.entity.RegistrationInfo;
import com.vti.be.repository.RegistrationInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegistrationInfoService implements IRegistrationInfoService {

  private final RegistrationInfoRepository registrationInfoRepository;
  private final ModelMapper modelMapper;

  public RegistrationInfoService(RegistrationInfoRepository registrationInfoRepository, ModelMapper modelMapper) {
    this.registrationInfoRepository = registrationInfoRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public List<RegistrationInfoDTO> getAllRegistrationInfos() {
    List<RegistrationInfo> registrationInfos = registrationInfoRepository.findAll();
    return registrationInfos.stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());
  }

  @Override
  public RegistrationInfoDTO getRegistrationInfoById(Integer id) {
    Optional<RegistrationInfo> registrationInfoOptional = registrationInfoRepository.findById(id);
    return registrationInfoOptional.map(this::convertToDTO).orElse(null);
  }

  @Override
  public RegistrationInfoDTO createRegistrationInfo(RegistrationInfoDTO registrationInfoDTO) {
    RegistrationInfo registrationInfo = convertToEntity(registrationInfoDTO);
    RegistrationInfo savedRegistrationInfo = registrationInfoRepository.save(registrationInfo);
    return convertToDTO(savedRegistrationInfo);
  }

  @Override
  public CourseDTO updateRegistrationInfo(Integer id, RegistrationInfoDTO registrationInfoDTO) {
    RegistrationInfo existingRegistrationInfo = registrationInfoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("RegistrationInfo not found with id: " + id));
    modelMapper.map(registrationInfoDTO, existingRegistrationInfo);
    RegistrationInfo savedRegistrationInfo = registrationInfoRepository.save(existingRegistrationInfo);
    return convertToCourseDTO(savedRegistrationInfo);
  }

  @Override
  public void deleteRegistrationInfo(Integer id) {
    registrationInfoRepository.deleteById(id);
  }

  private RegistrationInfoDTO convertToDTO(RegistrationInfo registrationInfo) {
    return modelMapper.map(registrationInfo, RegistrationInfoDTO.class);
  }

  private RegistrationInfo convertToEntity(RegistrationInfoDTO registrationInfoDTO) {
    return modelMapper.map(registrationInfoDTO, RegistrationInfo.class);
  }

  private CourseDTO convertToCourseDTO(RegistrationInfo registrationInfo) {
    return modelMapper.map(registrationInfo, CourseDTO.class);
  }
}