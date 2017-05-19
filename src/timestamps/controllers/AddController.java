package timestamps.controllers;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import timestamps.dao.EntityDAO;
import timestamps.models.Entity;

@Controller
@RequestMapping("/addsensor")
public class AddController {

	@Autowired
	private EntityDAO entityDAOImpl;

	@RequestMapping(method = RequestMethod.GET)
	public String addSensor(@RequestParam("name") String name,

			@RequestParam("group") BigInteger group, ModelMap model) {
		Entity entity = new Entity();

		entity.setName(name);
		entity.setGroup(group);

		if (entityDAOImpl.validate(entity)) {
			model.addAttribute("message", "Validation was successful");
			entityDAOImpl.add(entity);
		} else {
			model.addAttribute("message", "Validation was unsuccessful");
		}

		return "add";
	}
}
