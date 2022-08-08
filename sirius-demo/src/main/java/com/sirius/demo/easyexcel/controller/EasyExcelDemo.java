package com.sirius.demo.easyexcel.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.sirius.demo.easyexcel.entity.DownloadData;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author huangjingcheng
 * @version 1.0.0
 * @ClassName EasyExcelDemo.java
 * @Description TODO
 * @createTime 2022年08月08日 15:11:00
 */
@RestController
@RequestMapping("/easyExcel")
public class EasyExcelDemo {
    /**
     * 文件下载（失败了会返回一个有部分数据的Excel）
     * <p>
     * 1. 创建excel对应的实体对象 参照{@link DownloadData}
     * <p>
     * 2. 设置返回的 参数
     * <p>
     * 3. 直接写，这里注意，finish的时候会自动关闭OutputStream,当然你外面再关闭流问题不大
     */
    @GetMapping("download")
    public void download(HttpServletResponse response) throws IOException {
        long start = System.currentTimeMillis();
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), DownloadData.class).sheet("模板").doWrite(data());
        long end = System.currentTimeMillis();
        System.out.printf("Total Time：%d ms%n", end - start);
    }


    @GetMapping("downloadSheets")
    public void downloadSheets(HttpServletResponse response) throws IOException {
        long start = System.currentTimeMillis();
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        try (ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).build()){
            // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
            List<DownloadData> data = data();
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来。这里最终会写到5个sheet里面
            if (data.size()/1048576 >= 1){
                for (int i = 0; i <= data.size()/1048576+1; i++) {
                    // 每次都要创建writeSheet 这里注意必须指定sheetNo 而且sheetName必须不一样
                    WriteSheet writeSheet = EasyExcel.writerSheet(i, "模板" + i).build();
                    data = data.subList(0,1048);
                    excelWriter.write(data, writeSheet);
                }
            }

        }
        long end = System.currentTimeMillis();
        System.out.printf("Total Time：%d ms%n", end - start);
    }

//    /**
//     * 文件上传
//     * <p>1. 创建excel对应的实体对象 参照{@link UploadData}
//     * <p>2. 由于默认一行行的读取excel，所以需要创建excel一行一行的回调监听器，参照{@link UploadDataListener}
//     * <p>3. 直接读即可
//     */
//    @PostMapping("upload")
//    @ResponseBody
//    public String upload(MultipartFile file) throws IOException {
//        EasyExcel.read(file.getInputStream(), UploadData.class, new UploadDataListener(uploadDAO)).sheet().doRead();
//        return "success";
//    }

//    public List<DownloadData> data(){
//        long start = System.currentTimeMillis();
//        List<DownloadData> list = new ArrayList<>();
//        for (int i = 0;i<2000000;i++
//             ) {
//            DownloadData downloadData = new DownloadData();
//            downloadData.setI(i);
//            list.add(downloadData);
//        }
//        long end = System.currentTimeMillis();
//        System.out.printf("data Total Time：%d ms%n", end - start);
//        return list;
//    }

    private List<DownloadData> data() {
        long start = System.currentTimeMillis();
        List<DownloadData> list = new ArrayList<>();
        for (int i = 0;i<1048578;i++
        ) {
            DownloadData downloadData = new DownloadData();
            downloadData.setI(i);
            list.add(downloadData);
        }
        long end = System.currentTimeMillis();
        System.out.printf("data Total Time：%d ms%n", end - start);
        return list;
    }
    }
