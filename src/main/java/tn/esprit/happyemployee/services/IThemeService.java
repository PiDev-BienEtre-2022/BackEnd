package tn.esprit.happyemployee.services;

import java.util.List;

import tn.esprit.happyemployee.entities.Theme;


public interface IThemeService {

	Long addandmodifyTheme(Theme theme);

	void supprimerTheme(Long themeId);

	List<Theme> listThemes();

	Theme getThemeById(Long id);

	Long nombrePublicationsParTheme();

}
