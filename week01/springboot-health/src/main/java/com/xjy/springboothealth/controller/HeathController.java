package com.xjy.springboothealth.controller;

import com.xjy.springboothealth.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api")
public class HeathController {

    @GetMapping("/health")
    public ResultVO<String> health() {
        // 构建健康检查响应数据
        HealthResponse healthResponse = new HealthResponse();
        healthResponse.setAppName("your-application-name"); // 请替换为实际应用名称
        healthResponse.setVersion("1.0.0"); // 请替换为实际应用版本
        healthResponse.setTime(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        healthResponse.setStatus("UP");

        // 返回成功结果，此处将健康检查对象转为JSON字符串，也可根据需求调整返回数据结构
        return ResultVO.success(healthResponse.toString());
    }

    // 内部静态类，用于封装健康检查响应数据
    private static class HealthResponse {
        private String appName;
        private String version;
        private String time;
        private String status;

        // Getters and Setters
        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        @Override
        public String toString() {
            return "{" +
                    "\"appName\":\"" + appName + "\"," +
                    "\"version\":\"" + version + "\"," +
                    "\"time\":\"" + time + "\"," +
                    "\"status\":\"" + status + "\"" +
                    "}";
        }
    }
}