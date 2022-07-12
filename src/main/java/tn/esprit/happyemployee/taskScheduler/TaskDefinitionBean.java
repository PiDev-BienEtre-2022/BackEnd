package tn.esprit.happyemployee.taskScheduler;

import org.springframework.stereotype.Service;

@Service
public class TaskDefinitionBean implements Runnable {

	private TaskDefinition taskDefinition;
	 
	public TaskDefinition getTaskDefinition() {
		return taskDefinition;
	}

	public void setTaskDefinition(TaskDefinition taskDefinition) {
		this.taskDefinition = taskDefinition;
	}

	@Override
	public void run() {
		taskDefinition.execute(false);
	}

}
