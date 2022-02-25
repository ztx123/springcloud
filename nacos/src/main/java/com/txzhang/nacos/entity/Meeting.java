package com.txzhang.nacos.entity;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author txzhang
 * @date 2022/2/24 16:55
 */
@Data
@Component
@NacosConfigurationProperties(prefix = "meeting", autoRefreshed = true, dataId = "${spring.application.name}-${spring" +
        ".profiles.active}.${nacos.config.type}", type = ConfigType.YAML)
public class Meeting {

    private String address;
    private String time;
    private String title;

}
