package com.example.Shop.Config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
@Data
public class storageProperties {
    private String location;
}
