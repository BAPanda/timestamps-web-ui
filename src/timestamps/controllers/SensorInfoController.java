package timestamps.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import timestamps.dao.EntityDAO;

@Controller
@RequestMapping("/info")
public class SensorInfoController {
    @Autowired
    private EntityDAO entityDAOImpl;
    
    @RequestMapping(method = RequestMethod.GET)
    public String getInfo(ModelMap model) {
    	model.addAttribute("entList", entityDAOImpl.getAll());
    	
    	return "index";
    }
    
  
}
