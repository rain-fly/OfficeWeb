package cn.rainfly.controller;


import cn.rainfly.pojo.Message;
import cn.rainfly.pojo.WebOffice;
import cn.rainfly.service.WebOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Controller
@RequestMapping("")
public class WebOfficeController {

    private String contentPath = "D:\\webOffice";

	@Autowired
	WebOfficeService webOfficeService;


    @RequestMapping("downLoad")
    @ResponseBody
    public void downLoad(){

    }


	@RequestMapping("saveWebOffice")
    @ResponseBody
	public Message saveWebOffice(@RequestParam(value = "excelFile") MultipartFile file, HttpServletRequest request, HttpServletResponse response, WebOffice webOffice) throws Exception{
        if(file != null) {
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try {
                String originalFileName = file.getOriginalFilename();

                inputStream = file.getInputStream();
                // 文件更名
                String fileName = "123.doc";

                String  filePath = "E:\\123\\" + fileName;

                outputStream = new FileOutputStream(filePath);
                int readBytes = 0;
                byte[] buffer = new byte[10000];
                while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
                    outputStream.write(buffer, 0, readBytes);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        }
	    return Message.CreateMessage(true,"上传成功！");
	}

}
