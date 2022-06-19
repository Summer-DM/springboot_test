package com.summer.easyExcel.service.impl;

import com.alibaba.excel.EasyExcel;
import com.summer.easyExcel.excelModel.Student;
import com.summer.easyExcel.listener.StudentListener;
import com.summer.easyExcel.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Override
    public void downloadStudentTemplete(HttpServletResponse response) {
        try {
            // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("UTF-8");
            // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
            String fileName = URLEncoder.encode("学生 注册表模板","UTF-8");
            // 设置以下载方式打开文件
            response.addHeader("Content-Disposition","attachment;filename*=''" + fileName +".xlsx");
            List<Student> list = new ArrayList<>();
            for (int i=0;i<1000000;i++){
                Student student=new Student();
                student.setId((long) i);
                student.setName("浪哥"+i+"号");
                student.setInstitute("数学学院");
                student.setClassName(i + "班");
                student.setSchool("清华大学");
                student.setSpecialty("数学与应用数学");
                list.add(student);
            }
            log.info("需要下载的数据：" + list.toString());
            // 改用传递
            simpleWrite(response.getOutputStream(),fileName, Student.class,list);

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    @Override
    public String uploadStudentExcle(MultipartFile file) {
        try {
            //调用方法实现读取操作
            System.out.println("要读取的文件：" + file.toString());
            EasyExcel.read(file.getInputStream(), Student.class, new StudentListener()).sheet().doRead();
            return "成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "读取失败";

    }


    // 写
    public static void simpleWrite(OutputStream outputStream, String sheetName, Class<?> clazz, List<?> list) {
        // 写法1
        // String fileName =  "E:\\test2.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(outputStream, clazz).sheet(sheetName).doWrite(list);
    }
    // 流方式写
    public void simpleWrite(String pathFileName, Class<?> clazz, List<?> list) {
        // 写法1
        // String fileName =  "E:\\test2.xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(pathFileName, clazz).sheet("学生模板").doWrite(list);
    }

}
