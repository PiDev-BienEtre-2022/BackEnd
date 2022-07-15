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

	@PostMapping("/ajouterFilter")
	@ResponseBody
	public FilterTeletravail ajouterFilter(@RequestBody FilterTeletravail filter) {
		filterTeleTravailService.addFilterTeletravail(filter);
		if(filter.getRunSchedule() != RunSchedule.eachDemande) {
			String[] time = filter.getRunAt().split(":");
			TaskDefinition taskDefinition = new TaskDefinition();
			taskDefinition.setFilter(filter);
			switch(filter.getRunSchedule()) {
			  case eachMon:
				  taskDefinition.setCronExpression("0 "+ time[1] +" "+ time[0]+" ? * MON");
				  break;
			  case eachTues:
				  taskDefinition.setCronExpression("0 "+ time[1] +" "+ time[0]+" ? * TUE");
				  break;
			  case eachWed:
				  taskDefinition.setCronExpression("0 "+ time[1] +" "+ time[0]+" ? * WED");
				  break;
			  case  eachThur:
				  taskDefinition.setCronExpression("0 "+ time[1] +" "+ time[0]+" ? * THU");
				  break;
			  case eachFri:
				  taskDefinition.setCronExpression("0 "+ time[1] +" "+ time[0]+" ? * FRI");
				  break;
			  case eachSat:
				  taskDefinition.setCronExpression("0 "+ time[1] +" "+ time[0]+" ? * SAT");
				  break;
			  case eachSun:
				  taskDefinition.setCronExpression("0 "+ time[1] +" "+ time[0]+" ? * SUN");
				  break;
			  default:
				  taskDefinition.setCronExpression("0 "+ time[1] +" "+ time[0]+" ? * SUN");
			}
			taskDefinitionBean.setTaskDefinition(taskDefinition);
	        taskSchedulingService.scheduleATask(filter.getId(), taskDefinitionBean, taskDefinition.getCronExpression());
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
	
	@GetMapping("/executeFilter/{filterId}")
	@ResponseBody
	public List<DemandeTeleTravail> executeFilter(@PathVariable("filterId") Long filterId) {
		TaskDefinition task = new TaskDefinition();
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

