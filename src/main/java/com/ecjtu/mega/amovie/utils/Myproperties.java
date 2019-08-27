package com.ecjtu.mega.amovie.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author mega
 * @date 2019-08-27 09:58
 */
@Component
@Data
public class Myproperties {
    @Value("${uploadLocation}")
    private String location;
}
