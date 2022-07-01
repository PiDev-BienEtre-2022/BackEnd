package tn.esprit.happyemployee.services;

import java.util.List;

import tn.esprit.happyemployee.entities.FilterTeletravail;

public interface IFilterTeletravailService {

	Long addFilterTeletravail(FilterTeletravail filterTeletravail);

	Long modifierFilterTeletravail(FilterTeletravail filterTeletravail);

	void supprimerFilterTeletravail(Long filterTeletravailId);
	
	List<FilterTeletravail> getFilterTeletravails();
	
	FilterTeletravail getFilterTeletravailById(Long filterTeletravailId);
}
