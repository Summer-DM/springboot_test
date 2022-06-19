package com.summer.easyExcel.excelModel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Student {

        @ExcelProperty(value = "学号" ,index = 0)
        private Long id;
        @ExcelProperty(value = "名称" ,index = 1)
        private String name;
        @ExcelProperty(value = "专业" ,index = 2)
        private String specialty;
        @ExcelProperty(value = "班级" ,index = 3)
        private String className;
        @ExcelProperty(value = "学院" ,index = 4)
        private String institute;
        @ExcelProperty(value = "学校" ,index = 5)
        private String school;

}
