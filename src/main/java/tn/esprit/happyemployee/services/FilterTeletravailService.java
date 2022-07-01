package tn.esprit.happyemployee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.happyemployee.repositories.FilterTeletravailRepository;

import tn.esprit.happyemployee.entities.FilterTeletravail;

@Service
public class FilterTeletravailService implements IFilterTeletravailService {

	@Autowired
	FilterTeletravailRepository filterTeletravailRepository;
	
	@Override
	public Long addFilterTeletravail(FilterTeletravail filterTeletravail) {
		filterTeletravailRepository.save(filterTeletravail);
		return filterTeletravail.getId();
	}

	@Override
	public Long modifierFilterTeletravail(FilterTeletravail filterTeletravail) {
		filterTeletravailRepository.save(filterTeletravail);
		return filterTeletravail.getId();
	}

	@Override
	public void supprimerFilterTeletravail(Long filterTeletravailId) {
		filterTeletravailRepository.deleteById(filterTeletravailId);
	}

	@Override
	public List<FilterTeletravail> getFilterTeletravails() {
		return filterTeletravailRepository.findAll();
	}

	@Override
	public FilterTeletravail getFilterTeletravailById(Long filterTeletravailId) {
		return filterTeletravailRepository.findById(filterTeletravailId).get();
	}

}
