package com.codeforce.product.controllers;


import com.codeforce.product.model.Container;
import com.codeforce.product.model.State;
import com.codeforce.product.service.ContainerService;
import com.codeforce.product.service.StateService;
import com.codeforce.product.utils.Form_UI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
/*Alimbetov Ruslan*/

@Controller
@RequestMapping("/containers/")
public class ContainerControler {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final int ROW_PER_PAGE = 10;

    @Value("${msg.Container_title}")
    private String title;

    @Autowired
    private ContainerService containerService;

 
    @GetMapping(value = "/list")
    public String getContainers_list(Model model,
                              @RequestParam(value = "page", defaultValue = "1") int pageNumber) {
        List<Container> containers = containerService.findAll(pageNumber, ROW_PER_PAGE);

        long count = containerService.count();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;
        model.addAttribute("listcontainers", containers);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);
        return "container_list";
    }
    @GetMapping(value = {"/add"})
    public String showAddContainer(Model model) {
        Container myContainer = new Container();
        model.addAttribute("add", true);
        model.addAttribute("m_container", myContainer);
        model.addAttribute("allCountry", Form_UI.getCountryList());
        return "container-edit";
    }


    @PostMapping(value = "/add")
    public String addContainer(Model model,
                           @ModelAttribute("m_container") @Valid Container container, BindingResult bindingResult) {
        String errorMessage;
        Container newContainer;
        try {

            if (bindingResult.hasErrors()) {
                model.addAttribute("add", true);
                model.addAttribute("allCountry", Form_UI.getCountryList());
                return "container-edit";
            } else {
                newContainer = containerService.save(container);
                return "redirect:/containers/" + String.valueOf(newContainer.getId())+"//edit";
            }


        } catch (Exception ex) {
             errorMessage = ex.getMessage();
            model.addAttribute("errorMessage", errorMessage);

            model.addAttribute("add", true);
            model.addAttribute("allCountry", Form_UI.getCountryList());
            return "container-edit";
        }

    }

    @GetMapping(value = {"/{containerid}/edit"})
    public String showEditContainer(Model model, @PathVariable long containerid) {
        Container container = null;
        try {
            container = containerService.getContainerById(containerid);
            model.addAttribute("add", false);
            model.addAttribute("m_container", container);
            model.addAttribute("allCountry", Form_UI.getCountryList());
        } catch ( Exception ex)
        {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        return "container-edit";
    }

    @PostMapping(value = {"/{containerid}/edit"} )
    public String updateContainer(Model model,
                                @PathVariable long containerid,
                                @ModelAttribute("m_container") Container container) {
        try {
            container.setId(containerid);
            containerService.update(container);
            return "redirect:/containers/" + String.valueOf(container.getId()) +"//edit";
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", false);
            model.addAttribute("allCountry", Form_UI.getCountryList());
            return "container-edit";
        }}

    @GetMapping(value = {"/{containerid}/delete"})
    public String showDeleteContainerById(
            Model model, @PathVariable long containerid) {
        Container container = null;
        try {
            container = containerService.getContainerById(containerid);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", "Contact not found");
        }
        model.addAttribute("allowDelete", true);
        model.addAttribute("m_container", container);
        return "container_form";
    }

    @PostMapping(value = {"/{containerid}/delete"})
    public String deleteContainerById(
            Model model, @PathVariable long containerid) {
        try {
            containerService.deleteContainerById(containerid);
            return "redirect:/containers/list";
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            model.addAttribute("errorMessage", errorMessage);
            return "container_form";
        }
    }


}
