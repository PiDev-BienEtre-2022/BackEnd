package tn.esprit.happyemployee.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.happyemployee.entities.Theme;
import tn.esprit.happyemployee.services.IThemeService;


@RestController
public class ThemeRestController {

	@Autowired
	IThemeService themeService;
	
	
	@GetMapping("/Themes")
	@ResponseBody
	public List<Theme> getAllThemes(){
		List<Theme> list = themeService.listThemes();
		return list;
	}
	
	@PostMapping("/ajouterTheme")
	@ResponseBody
	public Theme ajouterTheme(@RequestBody Theme theme) {
		themeService.addandmodifyTheme(theme);
		return theme;
	}
	
	
	@PutMapping("/modifierTheme")
	@ResponseBody
	public Theme modifierTheme(@RequestBody Theme theme) {
		themeService.addandmodifyTheme(theme);
		return theme;
	}
	
	
	
	@DeleteMapping("/supprimerTheme/{themeId}")
	@ResponseBody
	public void supprimerTheme(@PathVariable("themeId") Long themeId) {
		themeService.supprimerTheme(themeId);
	}
	
}
