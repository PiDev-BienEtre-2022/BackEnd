package tn.esprit.happyemployee.domain.comparator;

import java.util.Comparator;

import tn.esprit.happyemployee.entities.DemandeTeleTravail;

public class DateComparator implements Comparator<DemandeTeleTravail> {
    @Override
    public int compare(DemandeTeleTravail o1, DemandeTeleTravail o2) {
        return o1.getDateCreation().compareTo(o2.getDateCreation());
    }
}
