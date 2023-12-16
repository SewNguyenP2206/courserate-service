package com.example.CourseRateService.Client;


import com.example.CourseRateService.DTO.ResponeCourseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(name = "COURSE-APP",path = "/api/course")
public interface CourseClient {
    @GetMapping("/GetCourseByCourseID/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponeCourseDTO findCoursesByCourseId(@PathVariable int id);
}
