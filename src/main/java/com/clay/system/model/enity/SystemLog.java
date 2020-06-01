package com.clay.system.model.enity;

import com.clay.system.utils.StaticUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/5/30 21:37
 * @Version 1.0
 */
@Data
@Entity
@AllArgsConstructor
@Table(name = "t_log")
@SuppressWarnings("all")
public class SystemLog
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "logType",columnDefinition = "tinyint default 0")
    private int logType;

    @Column(name = "logBody",columnDefinition = "text",nullable = false)
    private String logBody;

    @DateTimeFormat(pattern = StaticUtils.DATE_PATTERN)
    @Column(name = "createTime",columnDefinition = "timestamp",nullable = false)
    private Date createTime;

    public SystemLog()
    {
        this.createTime=new Date();
    }
}
