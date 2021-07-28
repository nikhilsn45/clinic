package com.persistent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.persistent.entities.DoctorInfo;
import com.persistent.entities.User;
import com.persistent.entities.UserInfo;
import com.persistent.service.DoctorService;
import com.persistent.service.UserCreadService;
import com.persistent.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService serv;
	
	@Autowired
	private UserCreadService creadServ;
	
	@Autowired
	private DoctorService docServ;

	@RequestMapping(path="/save_user", method=RequestMethod.POST)
	public String save_user(@ModelAttribute UserInfo uInfo,@ModelAttribute User u,Model model,RedirectAttributes redirectAttributes)
	{
		serv.addUser(uInfo);
		creadServ.addUser(u);
		
		/*model.addAttribute("uInfo",uInfo);
		  redirectAttributes.addFlashAttribute("uInfo", uInfo);*/
        
		return "redirect:/dashboard";//redirected to user dashboard
	}
	
	
	@RequestMapping(path="/dashboard", method=RequestMethod.GET)
	public String user_home(@ModelAttribute UserInfo uInfo,Model model)
	{
		/*Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
        if(flashMap != null){
            UserInfo uInfo =  (UserInfo) flashMap.get("uInfo");
            System.out.println(uInfo);
            model.addAttribute("uInfo", uInfo);
            return "user_home";
        }
        else{
            return "refreshNotAllowed";
        }
		System.out.println(uInfo);
		model.addAttribute("uInfo",uInfo);*/
		
		return "user_home";//"user_home.jsp" called
	}
	
	@RequestMapping(path="/profile", method=RequestMethod.GET)
	public String user_profile(@ModelAttribute UserInfo uInfo)
	{
		System.out.println(uInfo);
		return "user_profile";//"user_home.jsp" called
	}
	
	
	
	@PostMapping("/search")
    public ResponseEntity<?> user_search_results(@RequestParam("type") String type,@RequestParam("state") String state,@RequestParam("city") String city) {

        //getuser filtered list from database
		List<DoctorInfo> users = docServ.findBySpecialityAndStateAndCity(type,state,city);
        //List<DoctorInfo> users = Arrays.asList(new DoctorInfo(),new DoctorInfo());

        return ResponseEntity.ok(users);

    }

}
