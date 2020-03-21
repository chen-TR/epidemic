package com.ctr.epidemic.controller;

import com.ctr.epidemic.model.DailyEpidemicDto;
import com.ctr.epidemic.model.ProvinceInfo;
import com.ctr.epidemic.model.ResultDto;
import com.ctr.epidemic.model.UserInfo;
import com.ctr.epidemic.service.EpidemicService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.xml.ws.soap.Addressing;
import java.util.List;

/**
 * @author 陈天润
 * @version 0.0.1
 * @since 2020/3/21 13:10
 */
@Controller
@RequestMapping("epidemicData")
public class EpidemicController {

    private Logger logger = Logger.getLogger(EpidemicController.class);

    @Autowired
    private EpidemicService epidemicService;

    @PostMapping("/ajax/input")
    @ResponseBody
    public ResultDto inputData(@RequestBody DailyEpidemicDto dailyEpidemicDto, HttpSession session){
        logger.debug(dailyEpidemicDto);
        //获取当前用户
        UserInfo userInfo = (UserInfo)session.getAttribute("loginedUser");
        //保存数据
        ResultDto<Object> resultDto = new ResultDto<>();
        List<ProvinceInfo> list = epidemicService.saveData(dailyEpidemicDto,userInfo.getUserId());
        resultDto.setData(list);

        return resultDto;
    }
}
