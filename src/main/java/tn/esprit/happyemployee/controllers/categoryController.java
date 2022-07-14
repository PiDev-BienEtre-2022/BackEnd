package tn.esprit.happyemployee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.happyemployee.entities.Category;
import tn.esprit.happyemployee.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class categoryController {
    @Autowired
    CategoryService agent;

    @GetMapping("/list")
    public List<Category> list_categories(){
        return agent.getCategories();
    }

    @GetMapping("/{id}")
    public Category get_category(@PathVariable("id") long id){
        return agent.getCategoryById(id);
    }

    @PostMapping("/add")
    public String add_category(@RequestBody Category category){
        Category old = agent.getCategoryByDomainAndNom(category.getDomain(), category.getNom());
        if(old == null){
            agent.addCategory(category);
            return "ok";
        }
        return "Category exist";
    }

    @PutMapping("update/{id}")
    public String update_category(@PathVariable("id") long id, @RequestBody Category category){
        Category old =  agent.getCategoryById(id);

        old.setDomain(category.getDomain());
        old.setNom(category.getNom());
        old.setPercentage(category.getPercentage());
        old.setStatus(category.getStatus());

        agent.updateCategory(old);
        return "ok";
    }

    @DeleteMapping("/delete/{id}")
    public String delete_category(@PathVariable("id") long id){
        agent.deleteCategory(id);
        return "ok";
    }
}
