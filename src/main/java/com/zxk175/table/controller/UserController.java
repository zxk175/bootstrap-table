package com.zxk175.table.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.StringUtil;
import com.zxk175.table.model.BaseResult;
import com.zxk175.table.model.Pages;
import com.zxk175.table.pojo.User;
import com.zxk175.table.pojo.UserExample;
import com.zxk175.table.pojo.UserExample.Criteria;
import com.zxk175.table.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zxk175 on 16/11/13.
 */

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger log = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * 跳转页面
     *
     * @return 页面名字
     */
    @RequestMapping("/{suffix}")
    public String showUserBySuffix(@PathVariable String suffix, ModelMap modelMap) {
        String suf = suffix.toUpperCase();
        modelMap.addAttribute("page_title", suf + ":用户信息列表");
        modelMap.addAttribute("title", "Hello " + suf + "!!!");
        return "showUser";
    }

    @ResponseBody
    @RequestMapping(value = "/api/initTable/{num}", method = RequestMethod.POST)
    public BaseResult apiInitTable(@PathVariable Integer num) {
        log.debug("初始化成功用户信息");
        boolean success = true;
        String msg = null;

        int count = 0;
        for (int i = 1; i <= num; i++) {
            User u = new User();
            u.setUserName("User No." + i);
            u.setUserSex((short) (i % 2 == 0 ? 1 : 0));
            u.setUserPwd("5470db9b63c354f6c8d628b80ae2f3c3");
            u.setUserEmail("12562346@qq.com");
            u.setUserPhone("1301234567");
            u.setCreateTime(new Date());
            u.setModifyTime(new Date());
            u.setIsDelete((short) 0);
            count += userService.insertUser(u);
            log.debug(i);
        }

        BaseResult result = new BaseResult();
        if (count <= 0) {
            success = false;
            msg = "初始化失败!";
        }

        msg = "成功初始化" + count + "条数据!";
        result.setSuccess(success);
        result.setMsg(msg);

        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/api/addAndUpdateUser/{type}", method = RequestMethod.POST)
    public BaseResult apiAddAndUpdateUser(User user, @PathVariable String type) {
        log.debug("添加一个用户信息");
        boolean success = true;
        String msg = "添加成功!";
        int count = 0;

        if ("add".equals(type)) {
            user.setCreateTime(new Date());
            user.setModifyTime(new Date());
            user.setIsDelete((short) 0);
            count = userService.insertUser(user);
        } else if ("update".equals(type)) {
            user.setModifyTime(new Date());
            count = userService.updateByPrimaryKeySelective(user);
        }

        BaseResult result = new BaseResult();
        if ("add".equals(type) && count <= 0) {
            success = false;
            msg = "添加失败!";
        } else if ("update".equals(type) && count <= 0) {
            success = false;
            msg = "更新失败!";
        } else if ("update".equals(type) && count > 0) {
            success = true;
            msg = "更新成功!";
        }

        result.setSuccess(success);
        result.setMsg(msg);

        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/api/deleteUser/{type}", method = RequestMethod.POST)
    public BaseResult apiDeleteUser(@PathVariable String type, HttpServletRequest request) {
        log.debug("删除一个或多个用户信息");

        boolean success = true;
        String msg = null;
        String ids = request.getParameter("id");
        BaseResult result = new BaseResult();
        UserExample example = null;

        if ("one".equals(type) && null != ids) {
            Long id = Long.parseLong(ids);

            example = new UserExample();
            Criteria criteria = example.createCriteria();
            criteria.andIdEqualTo(id);
        } else if ("batch".equals(type) && null != ids) {
            List<Long> delList = new ArrayList<>();
            String[] id = ids.split(",");
            for (String s : id) {
                delList.add(Long.valueOf(s));
            }

            example = new UserExample();
            Criteria criteria = example.createCriteria();
            criteria.andIdIn(delList);
        } else {
            userService.deleteByExample(example);
            success = true;
            msg = "清空完毕!";
            result.setSuccess(success);
            result.setMsg(msg);
            return result;
        }

        if (example == null) {
            success = false;
            msg = "没有删除条件!";
            result.setSuccess(success);
            result.setMsg(msg);
            return result;
        }

        int count = userService.deleteByExample(example);
        msg = "成功删除" + count + "条数据!";

        if (count <= 0) {
            success = false;
            msg = "删除失败!";
        }

        result.setSuccess(success);
        result.setMsg(msg);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/api/showUser", method = RequestMethod.GET)
    public Pages<User> apiGetShowUser(HttpServletRequest request) {
        return showUser(request, "GET");
    }

    @ResponseBody
    @RequestMapping(value = "/api/showUser", method = RequestMethod.POST)
    public Pages<User> apiPostShowUser(HttpServletRequest request) {
        return showUser(request, "POST");
    }

    public Pages<User> showUser(HttpServletRequest request, String method) {
        log.debug(method + "查询所有用户信息");

        String limit = request.getParameter("limit");
        String nowPage = request.getParameter("nowPage");
        String order = request.getParameter("order");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");

        // 当前页数
        int nowPaged = Integer.parseInt(null == nowPage ? "1" : nowPage);
        // 每页显示页数
        int limitd = Integer.parseInt(null == limit ? "10" : limit);

        Pages<User> pages = new Pages<>();
        // 开始分页,参数1为请求第几页,参数2为请求条数
        PageHelper.startPage(nowPaged, limitd);


        // 查询条件
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(name)) {
            criteria.andUserNameLike("%" + name + "%");
        }
        if (StringUtil.isNotEmpty(sex) && !"-1".equals(sex)) {
            criteria.andUserSexEqualTo(Short.valueOf(sex));
        }
        example.setOrderByClause(order);

        // 查询结果
        List<User> userList = userService.getAllUserByExample(example);

        // 取记录总条数
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        int total = (int) pageInfo.getTotal();

        pages.setSuccess(true);
        pages.setMsg("共查询出" + total + "条数据!");
        pages.setRecords(userList);
        pages.setTotal(total);
        pages.setStatus(0);

        return pages;
    }
}
