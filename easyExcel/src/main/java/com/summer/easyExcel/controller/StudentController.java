package com.summer.easyExcel.controller;

import com.summer.easyExcel.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/studentEasyExcel")
public class StudentController {

        @Autowired
        private StudentService studentService;

        // 下载学生模板
        @GetMapping("/download")
        public void downloadStudentTemplete(HttpServletResponse response) {
            studentService.downloadStudentTemplete(response);
        }

        //上传学生模板
        @PostMapping("/upload")
        public String  uploadStudentExcle(MultipartFile file) {
            System.out.println(file);
            if (file==null) {
                return null;
            }
            return studentService.uploadStudentExcle(file);
    }

}
