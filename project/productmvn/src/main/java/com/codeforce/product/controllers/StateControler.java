package com.codeforce.product.controllers;


import com.codeforce.product.model.State;
import com.codeforce.product.service.StateService;
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
@RequestMapping("/states/")
public class StateControler {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final int ROW_PER_PAGE = 10;

    @Value("${msg.Status_title}")
    private String title;

    @Autowired
    private StateService stateService;


    @GetMapping(value = "/list")
    public String getStates_list(Model model,
                                 @RequestParam(value = "page", defaultValue = "1") int pageNumber) {
        List<State> states = stateService.findAll(pageNumber, ROW_PER_PAGE);

        long count = stateService.count();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;
        model.addAttribute("listStates", states);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);
        return "state_list";
    }

    @GetMapping(value = {"/add"})
    public String showAddState(Model model) {
        State myState = new State();
        model.addAttribute("add", true);
        model.addAttribute("m_state", myState);
        return "state-edit";
    }


    @PostMapping(value = "/add")
    public String addState(Model model,
                           @ModelAttribute("m_state") @Valid State state, BindingResult bindingResult) {
        String errorMessage;
        State newState;
        try {

            if (bindingResult.hasErrors()) {
                model.addAttribute("add", true);
                return "state-edit";
            } else {
                newState = stateService.save(state);
                return "redirect:/states/" + String.valueOf(newState.getId()) + "//edit";
            }


        } catch (Exception ex) {
            // log exception first,
            // then show error
            errorMessage = ex.getMessage();
            model.addAttribute("errorMessage", errorMessage);

            model.addAttribute("add", true);
            return "state-edit";
        }

    }

    @GetMapping(value = {"/{stateid}/edit"})
    public String showEditState(Model model, @PathVariable long stateid) {
        State state = null;
        try {
            state = stateService.getStateById(stateid);
            model.addAttribute("add", false);
            model.addAttribute("m_state", state);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        return "state-edit";
    }

    @PostMapping(value = {"/{stateid}/edit"})
    public String updateState(Model model,
                              @PathVariable long stateid,
                              @ModelAttribute("m_state") State state) {
        try {

            logger.info("updateContact " + stateid);
            state.setId(stateid);
            stateService.update(state);
            return "redirect:/states/" + String.valueOf(state.getId()) + "//edit";
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", false);
            return "state-edit";
        }
    }

    @GetMapping(value = {"/{stateid}/delete"})
    public String showDeleteStateById(
            Model model, @PathVariable long stateid) {
        State state = null;
        try {
            state = stateService.getStateById(stateid);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", "Contact not found");
        }
        model.addAttribute("allowDelete", true);
        model.addAttribute("m_state", state);
        return "state_form";
    }

    @PostMapping(value = {"/{stateid}/delete"})
    public String deleteStateById(
            Model model, @PathVariable long stateid) {
        try {
            stateService.deleteStateById(stateid);
            return "redirect:/states/list";
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            model.addAttribute("errorMessage", errorMessage);
            return "state_form";
        }
    }


}
