package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
public class BugController {
	
	

	@RequestMapping("/create1")
	 @ResponseBody
     public String add(@RequestParam("defectid")String de_id,@RequestParam("module")String module,@RequestParam("scenarios")String scenarios,@RequestParam("sublevels")String sublevels,@RequestParam("d_desc")String defect_description,@RequestParam("complexity")String complexity,@RequestParam("e_result")String expected_result,@RequestParam("a_result")String actual_result,@RequestParam("Status_p")String status_p,@RequestParam("severity")String severity,@RequestParam("status")String status,@RequestParam("Assigned_to")String assigned_to,@RequestParam("Assigned_d")String assigned_date,@RequestParam("d_remark")String developer_remarks,@RequestParam("t_obse")String tester_observation ){
	   
		BugModel in=new BugModel(null,de_id,module,scenarios,sublevels,defect_description,complexity,expected_result,actual_result,status_p,severity,status,assigned_to,assigned_date,developer_remarks,tester_observation);
		conn.save(in);
		return "Sucess";
   }
	@RequestMapping("/re")
	@ResponseBody
	public List<BugModel> getAllBugModel(){
		return (List<BugModel>)conn.findAll();
	}
	@RequestMapping("/re/{id}")
	@ResponseBody
	public ResponseEntity<BugModel> getBugModelById(@PathVariable(value = "id") Long Id) {
		BugModel note = conn.findOne(Id);
        if(note == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(note);
    }
	@RequestMapping("/retrive")
	@ResponseBody
	public List<BugModel> getSc() {
	   
	    return (List<BugModel>)conn.getSchoolIdAndName();
	}
	
	@RequestMapping("/up")
	@ResponseBody
    public String update(@RequestParam("sid")Long id,@RequestParam("defectid")String de_id,@RequestParam("module")String module,@RequestParam("scenarios")String scenarios,@RequestParam("sublevels")String sublevels,@RequestParam("d_desc")String defect_description,@RequestParam("complexity")String complexity,@RequestParam("e_result")String expected_result,@RequestParam("a_result")String actual_result,@RequestParam("Status_p")String status_p,@RequestParam("severity")String severity,@RequestParam("status")String status,@RequestParam("Assigned_to")String assigned_to,@RequestParam("Assigned_d")String assigned_date,@RequestParam("d_remark")String developer_remarks,@RequestParam("t_obse")String tester_observation ){
		BugModel u = conn.findOne(id);
		BugModel in=new BugModel(id,de_id,module,scenarios,sublevels,defect_description,complexity,expected_result,actual_result,status_p,severity,status,assigned_to,assigned_date,developer_remarks,tester_observation);
		conn.save(in);
		return "Sucess";
  }
	@RequestMapping("/delete")
	@ResponseBody
	public String de(@RequestParam("delete1")Long id) {
		BugModel dele = conn.findOne(id);
		

		conn.delete(dele);
		return "Sucess";
	}
	@RequestMapping("/vie")
	@ResponseBody
	public List<BugModel> getAllBugview(){
		return (List<BugModel>)conn.findAll();
	}
	
	
	@Autowired
	public BugRepository conn;
}
