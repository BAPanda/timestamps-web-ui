package timestamps.controllers;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import timestamps.dao.EntityDAO;

@Controller
@RequestMapping("/deletesensor")
public class DeleteController {

	@Autowired
	private EntityDAO entityDAOImpl;

	@RequestMapping(method = RequestMethod.GET)
	public String addSensor(@RequestParam("id") BigInteger id, ModelMap model) {
		entityDAOImpl.delete(id);
		model.addAttribute("message","Sensor was expelled");
		
		return "add";
	}
}
