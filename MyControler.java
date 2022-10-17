package com.secondspring.secondspring;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyControler
{
	@Autowired
	ProductService service;
	@RequestMapping("/")
	public String showHomePage(Model model)
	{
		
		System.out.println("Display is called");
		List<Employee> list= service.displayEmployee();
		for(Employee e: list)
		{
			System.out.println(e.getId()+ " "+e.getName()+" "+e.getSalary());
		}
		model.addAttribute("abc", list);
		return "show";
	}
	@RequestMapping("/addData")
	public String newData(Model model)
	{
		Employee employee= new Employee();
		model.addAttribute("employee", employee);
		return "add_pro";
	}
	@RequestMapping(value =  "/save" , method = RequestMethod.POST)
	public String saveData(@ModelAttribute("employee") Employee employee)
	{
		service.addEmployee(employee);
		return "redirect:/";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView editData(@PathVariable(name = "id") int id)
	{
		ModelAndView view = new ModelAndView("edit_data");
		Employee employee = service.updateEmp(id);
		view.addObject("employee", employee);
		return view;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteData(@PathVariable(name = "id") int id)
	{
		service.deleteEmp(id);
		return "redirect:/";
	}
}


