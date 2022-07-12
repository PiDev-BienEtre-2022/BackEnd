package tn.esprit.happyemployee.domain.comparator;

import java.util.Comparator;

import tn.esprit.happyemployee.domain.enums.DemandeUrgency;
import tn.esprit.happyemployee.entities.DemandeTeleTravail;

public class UrgencyComparator implements Comparator<DemandeTeleTravail> {
    @Override
    public int compare(DemandeTeleTravail o1, DemandeTeleTravail o2) {
    	int val1 = 0;
    	if(o1.getUrgency() == DemandeUrgency.notUrgent) {val1 = 0;};
    	if(o1.getUrgency() == DemandeUrgency.urgent) {val1 = 1;};
    	if(o1.getUrgency() == DemandeUrgency.veryUrgent) {val1 = 2;};
    	
    	int val2 = 0;
    	if(o2.getUrgency() == DemandeUrgency.notUrgent) {val2 = 0;};
    	if(o2.getUrgency() == DemandeUrgency.urgent) {val2 = 1;};
    	if(o2.getUrgency() == DemandeUrgency.veryUrgent) {val2 = 2;};
    	
        return val1 - val2;
    }
}
