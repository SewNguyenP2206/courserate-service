package com.example.CourseRateService.Service;

import com.example.CourseRateService.Entity.CourseRate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ICourseRateService {

    public Float getAvgCourseRateByCourseId(Integer courseId);

    public int getCourseRateCountByCourseId(Integer courseId);

    public List<CourseRate> getCourseRatesByCourseId(Integer courseId);

    public String saveCourseRate(Integer courseId, Integer accountId, Integer rate, String comment);

    public String RateOfCourse( Integer courseId, Integer accountId, Integer rate, String comment);

    public List<CourseRate> getCourseRate(Integer courseId);

    public String updateCourseRate(Integer courseId, Integer accountId, Integer rate, String comment);

    public int updateAnn( String comment, int id);

    public String DeleteCourseRate( Integer id);



}
