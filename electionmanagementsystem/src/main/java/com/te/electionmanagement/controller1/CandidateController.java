package com.te.electionmanagement.controller1;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.electionmanagement.bean.CandidateDetails;
import com.te.electionmanagement.service.CandidateService;


@Controller
public class CandidateController {

	@Autowired
	private CandidateService service;

	@GetMapping("/login")
	public String getData() {
		return "loginform";
	}

	@PostMapping("/login")
	public String authenticate(int id, String password, ModelMap map, HttpServletRequest request) {
		CandidateDetails details = service.authenticate(id, password);
		HttpSession session = request.getSession();
		session.setAttribute("loggedIn", details);
		if (details != null) {
			map.addAttribute("data", details.getName());
			return "welcome";
		} else {
			map.addAttribute("errMsg", "Invalid Credentials");
			return "loginform";
		}

	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

	@GetMapping("/add")
	public String addForm(@SessionAttribute(name = "loggedIn", required = false) CandidateDetails details2,
			ModelMap map) {
		if (details2 != null) {
			return "addForm";
		} else {
			map.addAttribute("errMsg", "Login Again!!");
			return "loginform";
		}
	}

	@PostMapping("/add")
	public String addData(CandidateDetails details, ModelMap map,
			@SessionAttribute(name = "loggedIn", required = false) CandidateDetails details2) {
		if (details2 != null) {
			if (service.addData(details)) {
				map.addAttribute("msg", "Data Inserted Successfully!!");
			} else {
				map.addAttribute("errMsg", "Something Went Wrong!!");
			}

			return "addForm";
		} else {
			map.addAttribute("errMsg", "Login Again!!!");
			return "loginform";
		}
	}

	@GetMapping("/delete")
	public String delete(ModelMap map,
			@SessionAttribute(name = "loggedIn", required = false) CandidateDetails details2) {
		if (details2 != null) {
			return "deleteForm";
		} else {
			map.addAttribute("errMsg", "Login Again!!");
			return "loginform";
		}
	}

	@PostMapping("/delete")
	public String delete(ModelMap map, int id,
			@SessionAttribute(name = "loggedIn", required = false) CandidateDetails details2) {
		if (details2 != null) {
			if (service.deleteData(id)) {
				map.addAttribute("msg", "Data Deleted Successfully!!");
			} else {
				map.addAttribute("errMsg", "Enter Valid ID!!");
			}

			return "deleteForm";
		} else {
			map.addAttribute("errMsg", "Login Again!!!");
			return "loginform";
		}
	}

	@GetMapping("/get")
	public String getForm(@SessionAttribute(name = "loggedIn", required = false) CandidateDetails details2,
			ModelMap map) {
		if (details2 != null) {
			return "getForm";
		} else {
			map.addAttribute("errMsg", "Login Again!!");
			return "loginform";
		}
	}

	@PostMapping("/get")
	public String getData(CandidateDetails details, ModelMap map, int id,
			@SessionAttribute(name = "loggedIn", required = false) CandidateDetails details2) {
		if (details2 != null) {
			CandidateDetails details3 = service.getData(id);
			if (details3 != null) {
				map.addAttribute("data", details3);
			} else {
				map.addAttribute("msg", "Data not found!!");
			}

			return "getForm";
		} else {
			map.addAttribute("errMsg", "Login Again!!!");
			return "loginform";
		}
	}

	@GetMapping("/update")
	public String updateData(@SessionAttribute(name = "loggedIn", required = false) CandidateDetails details2,
			ModelMap map) {
		if (details2 != null) {
			map.addAttribute("data", details2);
			return "updateform";
		} else {
			map.addAttribute("errMsg", "Login Again!!");
			return "loginform";
		}

	}

	@PostMapping("/update")
	public String updateData(CandidateDetails details, ModelMap map,
			@SessionAttribute(name = "loggedIn", required = false) CandidateDetails details2) {
		if(details2!=null) {
			if(service.update(details, details2.getId())) {
				map.addAttribute("data",details2);
				map.addAttribute("msg", "Data Updated Successfully!!");
			}
			else {
				map.addAttribute("errMsg", "Something went wrong!!");
			}
			return "updateform";
		}else {
			map.addAttribute("errMsg","Login Again!!");
		return "loginform";
		}
	}
	
	@GetMapping("/getall")
	public String allData(@SessionAttribute(name = "loggedIn", required = false) CandidateDetails details2,
			ModelMap map) {
		List<CandidateDetails> list=service.getAll();
		if (list != null) {
			map.addAttribute("data", list);
			return "getall";
		} else {
			map.addAttribute("errMsg", "Login Again!!");
			return "loginform";
		}

	}

	@GetMapping("/logout")
	public String logout(ModelMap map, HttpSession session) {
		map.addAttribute("errMsg", "Logged out Successfully");
		session.invalidate();
		return "loginform";
	}

}
