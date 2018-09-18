package cn.xzit.recar.controller;


import cn.xzit.recar.bean.domain.EmployeesDto;
import cn.xzit.recar.bean.entity.EmployeesEntity;
import cn.xzit.recar.bean.model.ResultModel;
import cn.xzit.recar.controller.common.BaseController;
import cn.xzit.recar.service.CustomerService;
import cn.xzit.recar.service.EmployeesService;
import cn.xzit.recar.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
@Scope("prototype")
public class LoginController extends BaseController {
    @Autowired
    private EmployeesService employeesService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/admin")
    public String login(HttpServletRequest request){
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        Object result = null;
        if("1".equals(role)){
            result = customerService.login(account,password);
        }else {
            result = employeesService.login(account,password,"2".equals(role)?1:0);
        }
        if(result!=null) {
            request.getSession().setAttribute("user",result);
            if("1".equals(role))
                 return "redirect:/customer";
            else if("2".equals(role))
                return "redirect:/employee";
            else  return "redirect:/admin";
        }
        else return "redirect:/login";
    }

    @RequestMapping("/session")
    @ResponseBody
    public ResultModel<Object> getHttpSession(HttpSession httpSession){
        Object user = httpSession.getAttribute("user");
        if(user==null) return error(null);
        return success(user);
    }
    @RequestMapping("/out")
    public String  cearSession(HttpSession httpSession){
       httpSession.setAttribute("user",null);
       httpSession.setAttribute("maintenanceid",null);
        return "redirect:/login";
    }
}
