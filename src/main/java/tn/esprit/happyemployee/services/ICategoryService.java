package tn.esprit.happyemployee.services;

import tn.esprit.happyemployee.domain.enums.Domain;
import tn.esprit.happyemployee.entities.Category;

import java.util.List;

public interface ICategoryService {
    void addCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(Long id);
    List<Category> getCategories();
    Category getCategoryById(Long id);

    List<Category> getCategoriesByDomain(Domain d);

    Category getCategoryByDomainAndNom(Domain d, String nom);
}
