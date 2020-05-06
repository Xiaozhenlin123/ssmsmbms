package com.zt.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONArray;
import com.zt.entity.User;
import com.zt.service.UserService;

@Controller
public class UserController {
	//@Resource(name="userService")
	@Autowired
	private UserService userService;

	@RequestMapping(value="loginUser",method=RequestMethod.GET)
	public String login(User user,HttpSession session){
		System.out.println("执行login()方法。。"+user);
		user=userService.loginUser(user);
		//return user!=null?"redirect:user":"index";
		//return user!=null?"success":"index";
		if(user!=null){
			session.setAttribute("us", user);
			return "success";
		}else{
			return "index";
		}
	}


	//RestFul风格url(ajax方式)
	@RequestMapping(value="{a}/{b}/user",method=RequestMethod.GET)
	public void login2(HttpServletResponse response,@PathVariable("a") String userCode2,@PathVariable("b") String userPassword) throws IOException{
		System.out.println("------------------");
		System.out.println("执行login2()方法。。");
		System.out.println("------------------");
		System.out.println("userCode2="+userCode2+",userPassword="+userPassword);
		//return "error";
		//return "redirect:user.html";
		//response.getWriter().print("admin");
		response.getWriter().print("1");
	}

	@RequestMapping(value="user",method=RequestMethod.GET)
	//@ResponseBody
	public void getAllUser(HttpServletResponse response) throws IOException{
		System.out.println("执行getAllUser()方法。。");
		List<User> list=userService.getUsers();
		response.setContentType("text/html;charset=utf-8");
		String str=JSONArray.toJSONString(list);
		response.getWriter().print(str);
		System.out.println(str);
	}

	@RequestMapping(value="user/{id}",method=RequestMethod.GET)
	public String getUserById(@PathVariable("id") int id){
		System.out.println("执行getUserById()方法。。"+id);
		return "success";
	}

	@RequestMapping(value="user/{id}",method=RequestMethod.DELETE)
	public String delUser(@PathVariable("id") int id){
		System.out.println("执行delUser()方法。。"+id);
		return "success";
	}

	//通过表单添加
	@RequestMapping(value="user",method=RequestMethod.POST)
	public String addUser(User user){
		System.out.println("执行addUser()方法。。");
		return "success";
	}

	//异步json格式添加
	/*@RequestMapping(value="user",method=RequestMethod.POST)
	public String addUser2(@RequestBody User user){
		System.out.println("执行addUser()方法。。");
		return "success";
	}*/


	//上传
	@RequestMapping(value="saveUser",method=RequestMethod.POST)
	public String upload(HttpServletRequest request,String uname){
		System.out.println("uname:"+uname);
		MultipartHttpServletRequest req= (MultipartHttpServletRequest) request;
		try {
			//得到上传的文件
			MultipartFile file= req.getFile("myPic");
			//得到文件名
			String fileName= file.getOriginalFilename();
			System.out.println("fileName:"+fileName);
			//上传的目标路径
			String path=request.getRealPath("/images")+"/"+fileName;
			System.out.println("path:"+path);
			//创建目标文件
			File destFile=new File(path);
			//执行上传
			FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);
			System.out.println("上传成功！！");
		} catch (IOException e) {
			System.out.println("上传失败！！");
			e.printStackTrace();
		}
		return "uploadSuccess";
	}
	
	

	/*public void setUserService(UserService userService) {
		this.userService = userService;
	}*/
}
