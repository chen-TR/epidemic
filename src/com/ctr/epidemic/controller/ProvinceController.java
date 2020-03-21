package com.ctr.epidemic.controller;

import com.ctr.epidemic.model.ProvinceInfo;
import com.ctr.epidemic.model.ResultDto;
import com.ctr.epidemic.service.ProvinceService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author 陈天润
 * @version 0.0.1
 * @since 2020/3/21 1:13
 */
@Controller
@RequestMapping("province")
public class ProvinceController {

    private static Logger logger = Logger.getLogger(ProvinceController.class);

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/ajax/noDataList")
    @ResponseBody
    public ResultDto noDataProvinceList(String date){

        logger.debug("date:"+ date);

        List<ProvinceInfo> list = null;
        ResultDto<List<ProvinceInfo>> resultDto = new ResultDto<>();
        if(!StringUtils.isEmpty(date)){
            list = provinceService.findNoDataProvinces(date);
            resultDto.setData(list);
        }else {
            resultDto.setCode(-1);
            resultDto.setMsg("参数为空");
        }
        return resultDto;
    }

}
