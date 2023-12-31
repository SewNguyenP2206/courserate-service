package com.example.CourseRateService.Client;



import com.example.CourseRateService.DTO.ResponeAccountDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "ACCOUNT-APP", path = "/api/accounts")
public interface AccountClient {
    @GetMapping("/getAccount/{id}")
    public ResponseEntity<ResponeAccountDTO> getAccountInformation(@PathVariable int id);
}
