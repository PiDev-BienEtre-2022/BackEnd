package tn.esprit.happyemployee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.happyemployee.domain.enums.RunSchedule;
import tn.esprit.happyemployee.entities.DemandeTeleTravail;
import tn.esprit.happyemployee.entities.FilterTeletravail;
import tn.esprit.happyemployee.services.IFilterTeletravailService;
import tn.esprit.happyemployee.taskScheduler.TaskDefinition;
import tn.esprit.happyemployee.taskScheduler.TaskDefinitionBean;
import tn.esprit.happyemployee.taskScheduler.TaskSchedulingService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class FilterTeleTravailController {

	@Autowired
	IFilterTeletravailService filterTeleTravailService;
	
    @Autowired
	TaskSchedulingService taskSchedulingService;

    @Autowired
    TaskDefinitionBean taskDefinitionBean;
    
    @Autowired
    TaskDefinition task;

	@PostMapping("/ajouterFilter")
	@ResponseBody
	public FilterTeletravail ajouterFilter(@RequestBody FilterTeletravail filter) {
		filterTeleTravailService.addFilterTeletravail(filter);
		if(filter.getRunSchedule() != RunSchedule.eachDemande) {
			String[] time = filter.getRunAt().split(":");
			
			task.setFilter(filter);
			switch(filter.getRunSchedule()) {
			  case eachMon:
				  task.setCronExpression("0 "+ time[1] +" "+ time[0]+" ? * MON");
				  break;
			  case eachTues:
				  task.setCronExpression("0 "+ time[1] +" "+ time[0]+" ? * TUE");
				  break;
			  case eachWed:
				  task.setCronExpression("0 "+ time[1] +" "+ time[0]+" ? * WED");
				  break;
			  case  eachThur:
				  task.setCronExpression("0 "+ time[1] +" "+ time[0]+" ? * THU");
				  break;
			  case eachFri:
				  task.setCronExpression("0 "+ time[1] +" "+ time[0]+" ? * FRI");
				  break;
			  case eachSat:
				  task.setCronExpression("0 "+ time[1] +" "+ time[0]+" ? * SAT");
				  break;
			  case eachSun:
				  task.setCronExpression("0 "+ time[1] +" "+ time[0]+" ? * SUN");
				  break;
			  default:
				  task.setCronExpression("0 "+ time[1] +" "+ time[0]+" ? * SUN");
			}
			taskDefinitionBean.setTaskDefinition(task);
	        taskSchedulingService.scheduleATask(filter.getId(), taskDefinitionBean, task.getCronExpression());
		}
		return filter;
	}

	@PutMapping("/modifierFilter")
	@ResponseBody
	public FilterTeletravail modifierFilter(@RequestBody FilterTeletravail filter) {
		filterTeleTravailService.modifierFilterTeletravail(filter);
		return filter;
	}

	@DeleteMapping("/supprimerFilter/{filterId}")
	@ResponseBody
	public void supprimerFilter(@PathVariable("filterId") Long filterId) {
		filterTeleTravailService.supprimerFilterTeletravail(filterId);

	}

	@GetMapping("/listeFilter")
	@ResponseBody
	public List<FilterTeletravail> listeFilter() {

		return  filterTeleTravailService.getFilterTeletravails();
	}
	
	@GetMapping("/UserFilter/{userId}")
	@ResponseBody
	public FilterTeletravail UserFilter(@PathVariable("userId") Long userId) {

		return  filterTeleTravailService.getFilterTeletravailByUserId(userId);
	}
	
	@GetMapping("/executeFilter/{filterId}")
	@ResponseBody
	public List<DemandeTeleTravail> executeFilter(@PathVariable("filterId") Long filterId) {
		//TaskDefinition task = new TaskDefinition();
		FilterTeletravail filter = filterTeleTravailService.getFilterTeletravailById(filterId);
		task.setFilter(filter);
		return task.execute(true);
	}
	
	@GetMapping("/getFilter/{filterId}")
	@ResponseBody
	public FilterTeletravail getFilter(@PathVariable("filterId") Long filterId) {
		taskSchedulingService.removeScheduledTask(filterId);
		return  filterTeleTravailService.getFilterTeletravailById(filterId);
	}
	
	@PutMapping("/affecterFiltreAEquipe/{filterId}/{equipeId}")
	@ResponseBody
	public String affecterFiltreAEquipe(@PathVariable("filterId")  Long filterId, @PathVariable("equipeId") Long equipeId) {
		filterTeleTravailService.affecterFiltreAEquipe(filterId, equipeId);
		return "filter affecté correctement";
	}
	
	@PutMapping("/affecterFiltreADepartement/{filterId}/{departementId}")
	@ResponseBody
	public String affecterFiltreADepartement(@PathVariable("filterId")  Long filterId, @PathVariable("departementId") Long departementId) {
		filterTeleTravailService.affecterFiltreADepartement(filterId, departementId);
		return "filter affecté correctement";
	}
}

