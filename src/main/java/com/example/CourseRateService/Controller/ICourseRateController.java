package com.example.CourseRateService.Controller;


import com.example.CourseRateService.Entity.CourseRate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/api/rate")
public interface ICourseRateController {
    @PostMapping("/avgCourseRate")
    public ResponseEntity<Float> avgCourseRate(@RequestParam Integer courseId);


    @PostMapping("/countCourseRate")
    public ResponseEntity<Integer> countCourseRate(@RequestParam Integer courseId);


    @PostMapping("/showCourseRate")
    public ResponseEntity<List<CourseRate>> showCourseRate(@RequestParam Integer courseId);


    @PostMapping("/saveCourseRate")
    public ResponseEntity<String> saveCourseRate(@RequestParam Integer courseId, @RequestParam Integer accountId, @RequestParam Integer rate, @RequestParam String comment);

    @PostMapping("/CourseRate")
    public ResponseEntity<String> RateOfCourse(@RequestParam Integer courseId,@RequestParam Integer accountId,@RequestParam Integer rate,@RequestParam String comment);

    @PostMapping("/getCourseRate")
    public ResponseEntity<List<CourseRate>> getCourseRate(@RequestParam Integer courseId);

    @PutMapping("/updateCourseRate")
    public ResponseEntity<String> updateCourseRate(@RequestParam Integer courseId,@RequestParam Integer accountId,@RequestParam Integer rate,@RequestParam String comment);

    @PostMapping("/updateAnn")
    public ResponseEntity<CourseRate> updateAnn(@RequestParam String comment,@RequestParam int id);

    @PostMapping("/deleteCourseRate")
    public ResponseEntity<String> DeleteCourseRate(@RequestParam Integer id);

}
