package tn.esprit.happyemployee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.happyemployee.domain.enums.Domain;
import tn.esprit.happyemployee.entities.Category;
import tn.esprit.happyemployee.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{

    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findByStatusTrue();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public List<Category> getCategoriesByDomain(Domain d) {

        return categoryRepository.findByDomain(d);
    }

    @Override
    public Category getCategoryByDomainAndNom(Domain d, String nom) {
        return categoryRepository.findByDomainAndNom(d, nom);
    }
}
