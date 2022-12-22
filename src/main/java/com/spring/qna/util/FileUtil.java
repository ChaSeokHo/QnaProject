package com.spring.qna.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ComponentScan(basePackages = {"com.spring.qna.util.FileUtil"})
public class FileUtil {

    List<String> sysNameList = new ArrayList<>();
    List<String> oriNameList = new ArrayList<>();
    String oriName;

    String sysName;

    public void save(@RequestParam MultipartFile[] uploadfile, String realPath,String sysName) throws Exception {
        File fileSavePath = new File(realPath);
        for (MultipartFile file : uploadfile) {
            if (!file.isEmpty()) {
                this.oriNameList.add(file.getOriginalFilename());
                this.sysNameList.add(sysName);
                // 파일 복사
                File newFileName = new File(sysName);
                file.transferTo(new File(fileSavePath + "/" + newFileName));
            }
        }
    }
    public void delete(@RequestParam String realPath , String  sysName) {
        String fileSavePath = realPath;
        System.out.println(" realName : " + realPath);
        System.out.println(" sysName : " + sysName);
        File file = new File(fileSavePath + "/" + sysName);
        if(file.exists()){
            file.delete();
        }
    }
}
