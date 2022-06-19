package com.summer.easyExcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellExtra;
import com.summer.easyExcel.excelModel.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StudentListener
 * @Description 监听器   用来监听StudentExcel的所有操作
 * @Author Summer_DM
 * @Date 2022/6/19 10:08
 * @Version 1.0
 */
public class StudentListener extends AnalysisEventListener<Student> {

    private static final Logger log = LoggerFactory.getLogger(StudentListener.class);

    private static final int BATCH_COUNT = 5;

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    List<Student> list = new ArrayList<>();

    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        super.onException(exception, context);
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param student
     * @param analysisContext
     */
    @Override
    public void invoke(Student student, AnalysisContext analysisContext) {
        System.out.println("解析到一条数据");
        log.info("解析到一条数据:" + student);
        //降每次解析的数据，保存在list中
        list.add(student);
        //这里可以操作DDL
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }

    }

    @Override
    public void extra(CellExtra extra, AnalysisContext context) {
        super.extra(extra, context);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        log.info("所有数据解析完成！");
    }

    @Override
    public boolean hasNext(AnalysisContext context) {
        return super.hasNext(context);
    }

    // 加入数据库操作
    private void saveData() {
        log.info("{}条数据，开始存储数据库！", list.size());
        System.out.println(list);
//        for (UserData user: list) {
//            // 查询该用户是否已注册
//            if (lsysUserService.selectUserByAccount(user.getAccount())==null){
//                LsysUser lsysUser = new LsysUser();
//                lsysUser.setAccount(user.getAccount());
//                lsysUser.setUsername(user.getUserName());
//                String pwdmd5 = SerialUtil.encoderByMd5(user.getPassword()); // 密码加密
//                lsysUser.setMd5password(pwdmd5);
//                lsysUserService.addOne(lsysUser);
//                LOGGER.info("存储数据库成功！");
//            } else {
//                hasAccountRepeat = true;
//                LOGGER.info("存储数据库失败！");
//            }
//        }
    }


}
