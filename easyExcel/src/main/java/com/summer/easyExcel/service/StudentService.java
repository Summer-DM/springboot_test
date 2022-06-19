package com.summer.easyExcel.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface StudentService {

    void downloadStudentTemplete(HttpServletResponse response);

    String uploadStudentExcle(MultipartFile file);
}
