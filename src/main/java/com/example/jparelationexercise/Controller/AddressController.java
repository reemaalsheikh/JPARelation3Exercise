package com.example.jparelationexercise.Controller;

import com.example.jparelationexercise.DTO.AddressDTO;
import com.example.jparelationexercise.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;


    @GetMapping("/get")
    public ResponseEntity getAllAddresses(){
        return ResponseEntity.status(200).body(addressService.getAllTAddresses());
    }

    @PostMapping("/add")
    public ResponseEntity addAddressToTeacher(@Valid @RequestBody AddressDTO addressDTO){
        addressService.addAddressToTeacher(addressDTO);
        return ResponseEntity.status(200).body("Address added to teacher successfully");
    }

    @PutMapping("/update")
    public ResponseEntity updateCustomerProfile(@Valid @RequestBody AddressDTO addressDTO){
        addressService.updateAddress(addressDTO);
        return ResponseEntity.status(200).body("Teacher address updated successfully!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomerProfile(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body("Teacher address deleted successfully!");
    }
}
