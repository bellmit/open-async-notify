package com.zlikun.open.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author zlikun
 * @date 2018-09-26 15:48
 */
@Slf4j
@RestController
public class NotifyController {

    private AtomicLong counter = new AtomicLong();

    /**
     * 微信异步回调
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/weixin/notify", method = {GET, POST})
    public String weixinNotify(HttpServletRequest request) {
        long number = this.counter.incrementAndGet();
        log.info(String.format("[begin] receive weixin notify - %04d", number));
        Map<String, String[]> map = request.getParameterMap();
        if (CollectionUtils.isEmpty(map)) {
            log.info("no parameters .");
        } else {
            map.forEach((k, v) -> {
                if (v != null && v.length > 0) {
                    log.info("key = {}, value = {}", k, Arrays.toString(v));
                }
            });
        }
        log.info(String.format("[-end-] receive weixin notify - %04d", number));
        return "success";
    }

}
