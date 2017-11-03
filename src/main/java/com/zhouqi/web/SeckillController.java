package com.zhouqi.web;

import com.zhouqi.dto.ExposerDto;
import com.zhouqi.dto.SeckillExecutionDto;
import com.zhouqi.dto.SeckillResultDto;
import com.zhouqi.entity.Seckill;
import com.zhouqi.enums.SeckillStatEnum;
import com.zhouqi.exception.RepeatKillException;
import com.zhouqi.exception.SeckillCloseException;
import com.zhouqi.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/seckill")//url:模块/资源/{}/细分
public class SeckillController {
    @Autowired
    private SeckillService seckillService;

    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public String list(Model model){
        //list.jsp+mode=ModelAndView
        //获取列表页
        List<Seckill> list = seckillService.getSeckillList();
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping(value = "{seckillId}/detail",method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId,Model model){
        if(seckillId==null){
            return "redirect:/seckillId/list";
        }
        Seckill seckill=seckillService.getById(seckillId);
        if(seckill==null){
            return "forward:/seckillId/list";
        }
        model.addAttribute("seckill",seckill);
        return "detail";
    }

    @RequestMapping(value = "/{seckillId}/exposer",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResultDto<ExposerDto> exposer(@PathVariable("seckillId") Long seckillId){
        SeckillResultDto<ExposerDto> result;
        try {
            ExposerDto exposerDto = seckillService.exportSeckillUrl(seckillId);
            result =  new SeckillResultDto<ExposerDto>(true, exposerDto);
        }catch (Exception e){
            e.printStackTrace();
            result=new SeckillResultDto<ExposerDto>(false,e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/{seckillId}/{md5}/execution",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResultDto<SeckillExecutionDto> execute(@PathVariable("seckillId") Long seckillId,
                                                   @PathVariable("md5") String md5,
                                                   @CookieValue(value = "userPhone",required = false) Long userPhone)
    {
        if (userPhone==null)
        {
            return new SeckillResultDto<SeckillExecutionDto>(false,"未注册");
        }
        SeckillResultDto<SeckillExecutionDto> result;

        try {
            SeckillExecutionDto execution = seckillService.executeSeckill(seckillId, userPhone, md5);
            return new SeckillResultDto<SeckillExecutionDto>(true, execution);
        }catch (RepeatKillException e1)
        {
            SeckillExecutionDto execution=new SeckillExecutionDto(seckillId, SeckillStatEnum.REPEAT);
            return new SeckillResultDto<SeckillExecutionDto>(true,execution);
        }catch (SeckillCloseException e2)
        {
            SeckillExecutionDto execution=new SeckillExecutionDto(seckillId, SeckillStatEnum.END);
            return new SeckillResultDto<SeckillExecutionDto>(true,execution);
        }
        catch (Exception e)
        {
            SeckillExecutionDto execution=new SeckillExecutionDto(seckillId, SeckillStatEnum.INNER_ERROR);
            return new SeckillResultDto<SeckillExecutionDto>(true,execution);
        }

    }

    //获取系统时间
    @RequestMapping(value = "/time/now",method = RequestMethod.GET)
    @ResponseBody
    public SeckillResultDto<Long> time()
    {
        Date now=new Date();
        return new SeckillResultDto<Long>(true,now.getTime());
    }
}
