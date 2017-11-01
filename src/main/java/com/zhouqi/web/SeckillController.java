package com.zhouqi.web;

import com.zhouqi.entity.Seckill;
import com.zhouqi.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
