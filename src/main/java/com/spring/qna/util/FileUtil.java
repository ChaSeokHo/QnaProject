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

    public String save(@RequestParam MultipartFile[] uploadfile, String realPath) throws Exception {

        File fileSavePath = new File(realPath);
        for (MultipartFile file : uploadfile) {
            if (!file.isEmpty()) {
                String sysName = UUID.randomUUID() + "_" + file.getOriginalFilename();
                this.oriNameList.add(file.getOriginalFilename());
                this.sysNameList.add(sysName);
                // 파일 복사
                File newFileName = new File(sysName);
                file.transferTo(new File(fileSavePath + "/" + newFileName));
            }
        }
        return realPath;
    }
}
