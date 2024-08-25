package com.example.jparelationexercise.Service;

import com.example.jparelationexercise.Api.ApiException;
import com.example.jparelationexercise.DTO.AddressDTO;
import com.example.jparelationexercise.Model.Address;
import com.example.jparelationexercise.Model.Teacher;
import com.example.jparelationexercise.Repository.AddressRepository;
import com.example.jparelationexercise.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;


    public List<Address> getAllTAddresses() {
        return addressRepository.findAll();
    }

    //• Add teacher address
    public void addAddressToTeacher (AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if (teacher == null) {
            throw new ApiException("Teacher Not Found");
        }
        Address address = new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
        addressRepository.save(address);
    }

   // Update teacher address
    public void updateAddress(AddressDTO addressDTO) {
        Address address = addressRepository.findAddressById(addressDTO.getTeacher_id());

        if (address == null) {
            throw new ApiException("Address Not Found");
        }
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());

        addressRepository.save(address);
    }

    //Delete teacher address
    public void deleteAddress(Integer id) {
        Address address = addressRepository.findAddressById(id);
        if (address == null) {
            throw new ApiException("Address Not Found");
        }
        addressRepository.delete(address);
    }


}
