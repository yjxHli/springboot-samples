package com.xjy.week04.utils;

import com.xjy.week04.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.UUID;

/**
 * @author yjx
 * @date 2026/3/27
 * @description
 */

@Slf4j
public class FileUploadUtil  {
    private static final String UPLOAD_DIR = getUploadDir();

    static {
        File dir = new File(UPLOAD_DIR);
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                throw new RuntimeException("创建上传目录失败: " + UPLOAD_DIR);
            }
        }
    }


    private static final Set<String> ALLOWED_EXTENSIONS = Set.of(
            // 图片
            ".jpg", ".jpeg", ".png", ".gif", ".bmp", ".webp",
            // 文档
            ".pdf", ".doc", ".docx", ".xls", ".xlsx", ".ppt", ".pptx",
            // 文本
            ".txt", ".md", ".csv",
            // 压缩包
            ".zip", ".rar", ".7z",
            // 其他
            ".json", ".xml"
    );


    private static String getUploadDir() {
        try {
            // 获取项目根目录
            String baseDir = ResourceUtils.getURL("classpath:").getPath();
            // 在Windows系统上，路径可能以/开头，需要去除
            if (baseDir.startsWith("/") && baseDir.charAt(2) == ':') {
                baseDir = baseDir.substring(1);
            }
            // 创建上传目录
            Path uploadPath = Paths.get(baseDir, "static/upload/");
            Files.createDirectories(uploadPath);
            String uploadDir = uploadPath.toAbsolutePath().toString() + File.separator;
            log.info("上传目录: {}", uploadDir);
            return uploadDir;
        } catch (IOException e) {
            throw new RuntimeException("创建上传目录失败", e);
        }
    }

    public static String upload(MultipartFile file) throws IOException {

        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || originalFilename.isEmpty()) {
            throw new BusinessException(400, "文件名不能为空");
        }

        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();

        // 文件类型校验
        if (!ALLOWED_EXTENSIONS.contains(suffix)) {
            throw new BusinessException(400, "不支持的文件类型: " + suffix);
        }

        // 拼接新文件名，并创建新文件
        String fileName = UUID.randomUUID() + suffix;
        File dest = new File(UPLOAD_DIR + File.separator + fileName);
        // 保存新文件到上传目录（上传）
        file.transferTo(dest);
        return fileName;
    }


}
