package tn.esprit.happyemployee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.happyemployee.domain.enums.Domain;
import tn.esprit.happyemployee.entities.Category;
import tn.esprit.happyemployee.services.CategoryService;
import tn.esprit.happyemployee.services.UserService;

import java.util.List;

@RestController
@EnableWebSecurity
@CrossOrigin
@RequestMapping("/category")
public class categoryController {
    @Autowired
    CategoryService agent;
    @Autowired
    UserService userService;
    @GetMapping("/list")
    public List<Category> list_categories(){
        return agent.getCategories();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Category get_category(@PathVariable("id") long id){
        return agent.getCategoryById(id);
    }

    @PostMapping("/add")
    public String add_category(@RequestBody Category category){
        Category old = agent.getCategoryByDomainAndNom(category.getDomain(), category.getNom());
        if(old == null){
            category.setStatus(true);
            agent.addCategory(category);
            return "ok";
        }
        return "Category exist !";
    }

    @PutMapping("update/{id}")
    @ResponseBody
    public String update_category(@PathVariable("id") long id, @RequestBody Category category){
        Category verif = agent.getCategoryByDomainAndNom(category.getDomain(), category.getNom());
        Category old = agent.getCategoryById(id);

        if(verif != null) {
            if(verif.getId() == category.getId()){
                old.setDomain(category.getDomain());
                old.setNom(category.getNom());
                old.setPercentage(category.getPercentage());
            }else{
                return "Category exist !";
            }
        }else {
            old.setDomain(category.getDomain());
            old.setNom(category.getNom());
            old.setPercentage(category.getPercentage());
        }

        agent.updateCategory(old);
        return "ok";
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public String delete_category(@PathVariable("id") long id){
        //agent.deleteCategory(id);

        Category old =  agent.getCategoryById(id);
        old.setStatus(false);

        agent.updateCategory(old);


        return "ok";
    }

    @GetMapping("/domain/{id}")
    @ResponseBody
    public List<Category>  get_category_by_domain(@PathVariable("id") long id){
        Domain d = userService.getUserById(id).getDomain();
        return agent.getCategoriesByDomain(d);
    }
}
