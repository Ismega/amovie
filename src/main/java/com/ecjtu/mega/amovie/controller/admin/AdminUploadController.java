package com.ecjtu.mega.amovie.controller.admin;

import com.ecjtu.mega.amovie.exception.NotFoundException;
import com.ecjtu.mega.amovie.utils.Myproperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mega
 * @date 2019-08-26 20:24
 */
@RestController
@RequestMapping("/api/upload")
@CrossOrigin(value = "*", allowCredentials = "true")

public class AdminUploadController {

    @Autowired
    private Myproperties myproperties;

    @PostMapping
    public ResponseEntity upload(@RequestParam(value = "file") MultipartFile file,
                                 HttpServletRequest request) {
        if (file.isEmpty()) {
            return new ResponseEntity("上传失败，请选择文件", HttpStatus.BAD_REQUEST);
        }
        String fileName = file.getOriginalFilename();
        String filePath = myproperties.getLocation();
        File file1 = new File(filePath);
        Map<String, String> map = new HashMap<>();
        if (!file1.exists()) {
            file1.mkdir();
        }
        File f = new File(filePath + File.separator + fileName);
//        String des = filePath+File.separator+fileName;
        try {
            file.transferTo(f);
            String url = File.separator + "upload" + File.separator + fileName;
            map.put("url", url);
            return new ResponseEntity(map, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new NotFoundException("上传失败");
    }
}
