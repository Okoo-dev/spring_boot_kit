package edu.bit.kit.common;

import java.io.File;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import edu.bit.kit.vo.ResourceFileVO;
import lombok.extern.slf4j.Slf4j;

// 첨부파일 정보를 가공하고 지정된 위치에 파일을 저장하는 기능을 위한 클래스
// @Component FileUtils 클래스를 스프링의 빈으로 등록
@Slf4j
@Component
public class FileUtils {
    
   

    public List<ResourceFileVO> parseFileInfo(int string, MultipartHttpServletRequest multipartHttpServletRequest)
            throws Exception {
        if (ObjectUtils.isEmpty(multipartHttpServletRequest)) {
            return null;
        }
        
        // File file = new File(path) : 파일이 업로드 될 폴더를 생성, 여기서는 파일이 업로드 될때 마다
        // images 폴더밑에 yyyyMMdd 형식으로 폴더를 생성함. 이때 해당 폴더가 존재하지 않으면 폴더를 생성
        List<ResourceFileVO> fileList = new ArrayList<>();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        ZonedDateTime current = ZonedDateTime.now();
        String path = "src/main/resources/static/images/" /* + current.format(format) */;
        File file = new File(path);
        if (file.exists() == false) {
            file.mkdirs();
        }

        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();

        String newFileName, originalFileExtension, contentType;

        while (iterator.hasNext()) {
            List<MultipartFile> list = multipartHttpServletRequest.getFiles(iterator.next());
            for (MultipartFile multipartFile : list) {
                log.info("여기까지오냐" + list);
                if (multipartFile.isEmpty() == false) {
                    // contentType = multipartFile.getContentType() : 파일 형식을 확인하고
                    // 그에따라 이미지 확장자를 지정, 파일 확장자를 파일 이름에서 가져오는 방식을 간혹 사용하는데, 이렇게
                    // 확장자를 확인하는 방식은 위험함. 왜냐하면 확장자는 쉽게 바꿀 수 있기 때문에 실제 파일 형식과
                    // 확장자가 다를 수 있고, 파일의 위변조를 확인할 수 없기 때문입니다.
                    // 실제 개발을 할 떄에는 nio 패키지를 이용하거나 Apache Tika와 같은 라이브러리를 이용하여 파일 형식을 확인
                    contentType = multipartFile.getContentType();
                    if (ObjectUtils.isEmpty(contentType)) {
                        
                        break;

                    } else {
                        
                        if (contentType.contains("image/jpeg")) {
                            originalFileExtension = ".jpg";

                        } else if (contentType.contains("image/png")) {
                            originalFileExtension = ".png";

                        } else if (contentType.contains("image/gif")) {
                            originalFileExtension = ".gif";

                        } else {
                            break;
                        }

                    }
                    // newFileName = Long.toString(System.nanoTime()) + originalFileExtension : 
                    // 서버에 저장될 파일 이름을 생성합니다. 서버에 같은 이름의 파일이 있다면 업로드된 파일이 정상적으로 저장되지
                    // 않기 때문에, 절대 중복되지 않을 이름으로 바꿔줍니다. 여기서는 파일이 업로드된 나노초를 이용해 
                    // 새로운 파일이름으로 지정
                   
                    // newFileName = Long.toString(System.nanoTime()) + originalFileExtension;
                    ResourceFileVO reFile = new ResourceFileVO();
                    
                    // reFile.setBrdId(boardIdx) : 데이터베이스에 저장할 파일 정보를 앞에서 만든 
                    // ResourceFileVO에 저장합니다. 업로드된 파일을 추후 화면에 표시하기위해 파일의 원래 이름, 파일의 크기
                    // 파일이 저장된 경로를 저장합니다. 또한, 해당 파일이 어떤 게시글에 속해있는지 알 수 있도록 게시글 번호도 같이 저장합니다.
                    reFile.setProdNumber(string);
                    reFile.setFileSize(multipartFile.getSize());
                    reFile.setSrcFileName(multipartFile.getOriginalFilename());
                    reFile.setSrcFilePath(path + "/" + multipartFile.getOriginalFilename());
                    fileList.add(reFile);
                    
                    // multipartFile.transferTo(file) : 업로드된 파일을 새로운 이름으로 바꾸어 지정된 경로에 저장합니다.
                    file = new File(path + "/" + multipartFile.getOriginalFilename());
                    multipartFile.transferTo(file);
                }
            }
        }

        return fileList;
    }
    
    // 게시판 관련 오버로딩
    public List<ResourceFileVO> parseFileInfo(String string, MultipartHttpServletRequest multipartHttpServletRequest)
            throws Exception {
        if (ObjectUtils.isEmpty(multipartHttpServletRequest)) {
            return null;
        }
        
        // File file = new File(path) : 파일이 업로드 될 폴더를 생성, 여기서는 파일이 업로드 될때 마다
        // images 폴더밑에 yyyyMMdd 형식으로 폴더를 생성함. 이때 해당 폴더가 존재하지 않으면 폴더를 생성
        List<ResourceFileVO> fileList = new ArrayList<>();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        ZonedDateTime current = ZonedDateTime.now();
        String path = "src/main/resources/static/images/" /* + current.format(format) */;
        File file = new File(path);
        if (file.exists() == false) {
            file.mkdirs();
        }

        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();

        String newFileName, originalFileExtension, contentType;

        while (iterator.hasNext()) {
            List<MultipartFile> list = multipartHttpServletRequest.getFiles(iterator.next());
            for (MultipartFile multipartFile : list) {
                log.info("여기까지오냐" + list);
                if (multipartFile.isEmpty() == false) {
                    // contentType = multipartFile.getContentType() : 파일 형식을 확인하고
                    // 그에따라 이미지 확장자를 지정, 파일 확장자를 파일 이름에서 가져오는 방식을 간혹 사용하는데, 이렇게
                    // 확장자를 확인하는 방식은 위험함. 왜냐하면 확장자는 쉽게 바꿀 수 있기 때문에 실제 파일 형식과
                    // 확장자가 다를 수 있고, 파일의 위변조를 확인할 수 없기 때문입니다.
                    // 실제 개발을 할 떄에는 nio 패키지를 이용하거나 Apache Tika와 같은 라이브러리를 이용하여 파일 형식을 확인
                    contentType = multipartFile.getContentType();
                    if (ObjectUtils.isEmpty(contentType)) {
                        
                        break;

                    } else {
                        
                        if (contentType.contains("image/jpeg")) {
                            originalFileExtension = ".jpg";

                        } else if (contentType.contains("image/png")) {
                            originalFileExtension = ".png";

                        } else if (contentType.contains("image/gif")) {
                            originalFileExtension = ".gif";

                        } else {
                            break;
                        }

                    }
                    // newFileName = Long.toString(System.nanoTime()) + originalFileExtension : 
                    // 서버에 저장될 파일 이름을 생성합니다. 서버에 같은 이름의 파일이 있다면 업로드된 파일이 정상적으로 저장되지
                    // 않기 때문에, 절대 중복되지 않을 이름으로 바꿔줍니다. 여기서는 파일이 업로드된 나노초를 이용해 
                    // 새로운 파일이름으로 지정
                   
                    // newFileName = Long.toString(System.nanoTime()) + originalFileExtension;
                    ResourceFileVO reFile = new ResourceFileVO();
                    
                    // reFile.setBrdId(boardIdx) : 데이터베이스에 저장할 파일 정보를 앞에서 만든 
                    // ResourceFileVO에 저장합니다. 업로드된 파일을 추후 화면에 표시하기위해 파일의 원래 이름, 파일의 크기
                    // 파일이 저장된 경로를 저장합니다. 또한, 해당 파일이 어떤 게시글에 속해있는지 알 수 있도록 게시글 번호도 같이 저장합니다.
                    reFile.setBrdId(string);
                    reFile.setFileSize(multipartFile.getSize());
                    reFile.setSrcFileName(multipartFile.getOriginalFilename());
                    reFile.setSrcFilePath(path + "/" + multipartFile.getOriginalFilename());
                    fileList.add(reFile);
                    
                    // multipartFile.transferTo(file) : 업로드된 파일을 새로운 이름으로 바꾸어 지정된 경로에 저장합니다.
                    file = new File(path + "/" + multipartFile.getOriginalFilename());
                    multipartFile.transferTo(file);
                }
            }
        }

        return fileList;
    }
}
