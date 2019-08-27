package com.ecjtu.mega.amovie.controller.admin;

import com.ecjtu.mega.amovie.constant.CommonCode;
import com.ecjtu.mega.amovie.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author mega
 * @date 2019-08-26 20:24
 */
@RestController
@RequestMapping("/upload")
public class AdminUploadController {

    @PostMapping
    public ResponseEntity upload(@RequestParam(value = "file") MultipartFile file,
                                 HttpServletRequest request) {
        if (file.isEmpty()) {
            return new ResponseEntity("上传失败，请选择文件", HttpStatus.BAD_REQUEST);
        }
        String fileName = file.getOriginalFilename();
        String realPath = request.getSession().getServletContext().getRealPath("/upload");
//        String filePath = "G:\\mega\\amovie\\src\\main\\resources\\static\\images\\upload";
        File dest = new File(realPath + File.separator + fileName);
        try {
            file.transferTo(dest);
            return new ResponseEntity(CommonCode.success(), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new NotFoundException("上传失败");
    }
}
