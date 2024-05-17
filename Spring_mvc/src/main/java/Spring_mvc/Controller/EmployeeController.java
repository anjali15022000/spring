package Spring_mvc.Controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import Spring_mvc.Dao.EmployeeDao;
import Spring_mvc.Dto.EmployeeDto;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeDao employeedao;

	@RequestMapping("/insert")
	@ResponseBody
	public String insert(@ModelAttribute EmployeeDto employeedto) {
		// System.out.println(employeedto);

		employeedao.insert(employeedto);
		return "data inserted sucessfully";

	}
	
	
	@RequestMapping("/fetchbyid")
	public ModelAndView fetchBypk(@RequestParam int id) {
		
		System.out.println(id);
		EmployeeDto employeedto=employeedao.fetchBypk(id);
		System.out.println(employeedto);
		ModelAndView modelAndview = new ModelAndView("fetch.jsp");
		modelAndview.addObject("obj", employeedto);
		return modelAndview;

		
		

	}

	@RequestMapping("/deletebyid/{a}")
	@ResponseBody
	public String delete(@PathVariable int a) {
		// System.out.println("data deleted");

		
		return employeedao.deletebypk1(a);
	}
	
	@RequestMapping("/fetchall")

	public ModelAndView fetchAll() {
		List<EmployeeDto> dtos = employeedao.fetchAll();
		ModelAndView modelAndview = new ModelAndView("fetchall.jsp");
		modelAndview.addObject("objects", dtos);
		return modelAndview;

	}
	
	@RequestMapping("/deleteall")
	@ResponseBody
	public String deleteAll() {
		return employeedao.deleteAll();

	}
}
