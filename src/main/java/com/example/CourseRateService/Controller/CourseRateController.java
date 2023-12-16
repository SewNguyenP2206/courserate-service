package com.example.CourseRateService.Controller;


import com.example.CourseRateService.Entity.CourseRate;
import com.example.CourseRateService.Repository.CourseRateRepository;
import com.example.CourseRateService.Service.CourseRateService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseRateController implements ICourseRateController {


    @Autowired
    CourseRateService courseRateService;

    @Override
    public ResponseEntity<Float> avgCourseRate(@RequestParam Integer courseId) {
        try{
            return new ResponseEntity<>(courseRateService.getAvgCourseRateByCourseId(courseId),HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Override
    public ResponseEntity<Integer> countCourseRate(@RequestParam Integer courseId) {
        try{
          return new ResponseEntity<>(courseRateService.getCourseRateCountByCourseId(courseId),HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Override
    public ResponseEntity<List<CourseRate>> showCourseRate(@RequestParam Integer courseId) {
        try{
            return new ResponseEntity<>(courseRateService.getCourseRatesByCourseId(courseId),HttpStatus.OK);

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Override
    public ResponseEntity<String> saveCourseRate(@RequestParam Integer courseId, @RequestParam Integer accountId, @RequestParam Integer rate, @RequestParam String comment) {
        try{

            return new ResponseEntity<>(courseRateService.saveCourseRate(courseId,accountId,rate,comment),HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("There is an error when rating course");
        }
    }

    @Override
    public ResponseEntity<String> RateOfCourse(@RequestParam Integer courseId,@RequestParam Integer accountId,@RequestParam Integer rate,@RequestParam String comment){
        try{

            return new ResponseEntity<>(courseRateService.RateOfCourse(courseId,accountId,rate,comment),HttpStatus.OK);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error when rate course");
        }
    }

    @Override
    public ResponseEntity<List<CourseRate>> getCourseRate(@RequestParam Integer courseId) {
        try {
            return new ResponseEntity<>(courseRateService.getCourseRate(courseId),HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @Override
    public ResponseEntity<String> updateCourseRate(@RequestParam Integer courseId,@RequestParam Integer accountId,@RequestParam Integer rate,@RequestParam String comment){

        return new ResponseEntity<>(courseRateService.updateCourseRate(courseId,accountId,rate,comment),HttpStatus.OK);

    }
    @Override
    public ResponseEntity<CourseRate> updateAnn(@RequestParam String comment,@RequestParam int id) {
        try {
            courseRateService.updateAnn(comment,id);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @Override
    public ResponseEntity<String> DeleteCourseRate(@RequestParam Integer id) {
            return new ResponseEntity<>(courseRateService.DeleteCourseRate(id),HttpStatus.OK);
    }

}
