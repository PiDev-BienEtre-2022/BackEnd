package tn.esprit.happyemployee.taskScheduler;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.support.CronExpression;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import tn.esprit.happyemployee.domain.comparator.DateComparator;
import tn.esprit.happyemployee.domain.comparator.NbDayMonthComparator;
import tn.esprit.happyemployee.domain.comparator.NbDayWeekComparator;
import tn.esprit.happyemployee.domain.comparator.UrgencyComparator;
import tn.esprit.happyemployee.domain.enums.SortLogic;
import tn.esprit.happyemployee.entities.DemandeTeleTravail;
import tn.esprit.happyemployee.entities.FilterTeletravail;
import tn.esprit.happyemployee.repositories.DemandeTeleTravailRepository;
import tn.esprit.happyemployee.repositories.FilterTeletravailRepository;
import tn.esprit.happyemployee.services.DemandeTeleTravailService;

@Component
@Configurable
public class TaskDefinition {
	
	private String cronExpression;
	private FilterTeletravail filter;
	
	@Autowired 
	FilterTeletravailRepository filterRepository;
	
	@Autowired 
	DemandeTeleTravailRepository demandeTeleTravailRepository;
	
	@Autowired
	DemandeTeleTravailService demandeTeleTravailService;
	
	public List<DemandeTeleTravail> execute(boolean isManual) {
		
		List<DemandeTeleTravail> result =  new ArrayList<DemandeTeleTravail>();
		
		System.out.println("Execute Filter ");
		
		List<DemandeTeleTravail> demandes = demandeTeleTravailRepository.getDemandeByFilter(filter);
		
		if(filter.getSortLogic() == SortLogic.byDateCreation)
		{
			demandes.sort(new DateComparator());
		}
		else if (filter.getSortLogic() == SortLogic.byUrgency) 
		{
			demandes.sort(new UrgencyComparator());
		}
		else if (filter.getSortLogic() == SortLogic.lessNbrOfDaysThisMonth) 
		{
			demandes.sort(new NbDayMonthComparator());
		}
		else if (filter.getSortLogic() == SortLogic.lessNbrOfDaysThisWeek) 
		{
			demandes.sort(new NbDayWeekComparator());
		}
		
		demandes.forEach((d) -> {
			System.out.println("process demande:" + d.getId());
			result.add(demandeTeleTravailService.processSystemLogic(d, filter));
		});
			
		
		
		// set Next and Last Run
		LocalDateTime now = LocalDateTime.now();  
		Date lastdt = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
		filter.setLastRun(lastdt);
		if(!isManual) {
			CronExpression cronTrigger = CronExpression.parse(cronExpression);
	        LocalDateTime next = cronTrigger.next(LocalDateTime.now());
	        Date nextdt = Date.from(next.atZone(ZoneId.systemDefault()).toInstant());
	        filter.setNextRun(nextdt);
		}
		filterRepository.save(filter);
		
		return result;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public FilterTeletravail getFilter() {
		return filter;
	}

	public void setFilter(FilterTeletravail filter) {
		this.filter = filter;
	}
}

