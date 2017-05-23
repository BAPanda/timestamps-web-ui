package timestamps.controllers;


import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import timestamps.dao.EntityDAO;
import timestamps.dao.GroupDAO;

@Controller
public class SensorInfoController {
    @Autowired
    private EntityDAO entityDAOImpl;
    @Autowired
    private GroupDAO groupDAOImpl;
    
    @RequestMapping(method = RequestMethod.GET, path="/info")
    public String getInfo(ModelMap model) {
    	model.addAttribute("entList", entityDAOImpl.getAll());
    	model.addAttribute("groups", groupDAOImpl.getAll());
    	
    	return "index";
    }
    
    @RequestMapping(method = RequestMethod.GET, path="/group")
    public String getInfoForGroup(@RequestParam("idg") BigInteger id, ModelMap model) {
    	model.addAttribute("entList", entityDAOImpl.getByGroup(id));
    	
    	return "index";
    }
}
