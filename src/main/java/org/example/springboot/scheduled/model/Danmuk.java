package org.example.springboot.scheduled.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class Danmuk {

    /**
     * 主键
     */
    private String id;

    /**
     * 房间号
     */
    private String roomId;

    /**
     * 弹幕数据
     */
    private String danmuk;

    /**
     * 弹幕消息
     */
    private String danmukMsg;

    /**
     * 弹幕类型
     */
    private String danmukType;

    /**
     * 弹幕用户UID
     */
    private String danmukUserId;

    /**
     * 弹幕用户名
     */
    private String danmukUserName;

    /**
     * 弹幕时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime danmukTime;

}
