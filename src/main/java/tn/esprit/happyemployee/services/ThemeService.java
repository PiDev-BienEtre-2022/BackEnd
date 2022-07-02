package tn.esprit.happyemployee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.happyemployee.entities.Theme;
import tn.esprit.happyemployee.repositories.ThemeRepository;

@Service
public class ThemeService implements IThemeService {

	@Autowired
	ThemeRepository themeRepository;

	@Override
	public Long addandmodifyTheme(Theme theme) {
		themeRepository.save(theme);
		return theme.getIdTheme();
	}

	@Override
	public void supprimerTheme(Long themeId) {
		themeRepository.deleteById(themeId);

	}

	@Override
	public List<Theme> listThemes() {
		return themeRepository.findAll();
	}

	
	@Override
	public Theme getThemeById(Long id) {
		
		/*Theme theme =  themeRepository.getOne(id);
	      return theme;
	    */
		
		Optional<Theme> themeResponse = themeRepository.findById(id);
		Theme theme =  themeResponse.get();
		return theme;
	}

	@Override
	public Long nombrePublicationsParTheme() {
		return null;
	}

}
