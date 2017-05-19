package timestamps.controllers;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import timestamps.dao.GroupDAO;
import timestamps.models.Group;

@Controller
@RequestMapping("/groups")
public class GroupInfoController {
    @Autowired
    private GroupDAO groupDAOImpl;
    
    @RequestMapping(method = RequestMethod.GET)
    public String getInfo(ModelMap model) {
    	model.addAttribute("entList", groupDAOImpl.getAll());
    	
    	return "indexgr";
    }
    
    @RequestMapping(path="/add", method = RequestMethod.GET)
    public String addGroup(@RequestParam("address") String address,
    		@RequestParam("name") String name, ModelMap model){
    	
    	if (address == null || address.equals("")) {
    		model.addAttribute("message", "Validation was unsuccessful.");    		
    	} else {
    		model.addAttribute("message", "Validation was successful");
    		
    		Group group = new Group();
    		group.setAddress(address);
    		group.setName(name);
    		
    		groupDAOImpl.add(group);
    	}
    	
    	return "addgr";
    }
    
    @RequestMapping(path="/delete", method = RequestMethod.GET)
    public String deleteGroup(@RequestParam("id") BigInteger id, ModelMap model){
    	
    	groupDAOImpl.delete(id);
    	model.addAttribute("message", "Group was deleted");
    	
    	return "addgr";
    }
  
}
