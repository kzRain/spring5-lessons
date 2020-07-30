package com.codeforce.product.controllers;


import com.codeforce.product.model.Cantainer;
import com.codeforce.product.model.Pack;
import com.codeforce.product.model.State;
import com.codeforce.product.service.ContainerService;
import com.codeforce.product.service.PackService;
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
@RequestMapping("/packs/")
public class PackControler {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final int ROW_PER_PAGE = 10;

    @Value("${msg.Pack_title}")
    private String title;

    @Autowired
    private ContainerService containerService;

    @Autowired
    private StateService stateService;

    @Autowired
    PackService packService;

    @GetMapping(value = "/list")
    public String getPacks_list(Model model,
                                @RequestParam(value = "page", defaultValue = "1") int pageNumber) {
        List<Pack> packs = packService.findAll(pageNumber, ROW_PER_PAGE);

        long count = packService.count();
        boolean hasPrev = pageNumber > 1;
        boolean hasNext = (pageNumber * ROW_PER_PAGE) < count;
        model.addAttribute("listpacks", packs);
        model.addAttribute("hasPrev", hasPrev);
        model.addAttribute("prev", pageNumber - 1);
        model.addAttribute("hasNext", hasNext);
        model.addAttribute("next", pageNumber + 1);
        return "pack_list";
    }

    @GetMapping(value = {"/add"})
    public String showAddPack(Model model) {
        Pack myPack = new Pack();
        State myState = new State("n/d");
        Cantainer myContainer = new Cantainer();


        myContainer.setQnumber("000000000");
        myPack.setState(myState);
        myPack.setCantainer(myContainer);
        myPack.setWeigth(100D);

        List<State> states = stateService.getAllStates();
        List<Cantainer> containers = containerService.getAllContainers();


        model.addAttribute("add", true);
        model.addAttribute("m_pack", myPack);
        model.addAttribute("allStates", states);
        model.addAttribute("allContainers", containers);
        model.addAttribute("allWeigths", Form_UI.getWlist());


        return "pack-edit";
    }


    @PostMapping(value = "/add")
    public String addPack(Model model,
                          @ModelAttribute("m_pack") @Valid Pack pack, BindingResult bindingResult) {
        String errorMessage;
        Pack newPack;
        try {
            if (bindingResult.hasErrors()) {
                List<State> states = stateService.getAllStates();
                List<Cantainer> containers = containerService.getAllContainers();
                model.addAttribute("add", true);
                model.addAttribute("allStates", states);
                model.addAttribute("allContainers", containers);
                model.addAttribute("allWeigths", Form_UI.getWlist());
                return "pack-edit";
            } else {
                State selState = stateService.getStateById(pack.getState().getId());
                pack.setState(selState);
                Cantainer selContainer = containerService.getContainerById(pack.getCantainer().getId());
                pack.setCantainer(selContainer);

                pack.setId(0l);
                newPack = packService.createOrUpdatePack(pack);
                return "redirect:/packs/" + String.valueOf(newPack.getId()) + "//edit";
            }


        } catch (Exception ex) {
            errorMessage = ex.getMessage();
            model.addAttribute("errorMessage", errorMessage);

            model.addAttribute("add", true);
            return "pack-edit";
        }

    }

    @GetMapping(value = {"/{packid}/edit"})
    public String showEditPack(Model model, @PathVariable long packid) {
        Pack pack = null;
        try {

            List<State> states = stateService.getAllStates();
            List<Cantainer> containers = containerService.getAllContainers();

            pack = packService.getPackById(packid);
            model.addAttribute("add", false);
            model.addAttribute("m_pack", pack);

            model.addAttribute("allStates", states);
            model.addAttribute("allContainers", containers);
            model.addAttribute("allWeigths", Form_UI.getWlist());

        } catch (Exception ex) {
            model.addAttribute("errorMessage", ex.getMessage());
        }
        return "pack-edit";
    }

    @PostMapping(value = {"/{packid}/edit"})
    public String updatePack(Model model,
                             @PathVariable long packid,
                             @ModelAttribute("m_pack") Pack pack) {
        try {


            pack.setId(packid);

            State selState = stateService.getStateById(pack.getState().getId());
            pack.setState(selState);
            Cantainer selContainer = containerService.getContainerById(pack.getCantainer().getId());
            pack.setCantainer(selContainer);

            packService.update(pack);
            return "redirect:/packs/" + String.valueOf(pack.getId()) + "//edit";
        } catch (Exception ex) {

            List<State> states = stateService.getAllStates();
            List<Cantainer> containers = containerService.getAllContainers();


            String errorMessage = ex.getMessage();
            model.addAttribute("errorMessage", errorMessage);
            model.addAttribute("add", false);

            model.addAttribute("allStates", states);
            model.addAttribute("allContainers", containers);
            model.addAttribute("allWeigths", Form_UI.getWlist());


            return "pack-edit";
        }
    }

    @GetMapping(value = {"/{packid}/delete"})
    public String showDeletePackById(
            Model model, @PathVariable long packid) {
        Pack pack = null;
        try {
            pack = packService.getPackById(packid);
        } catch (Exception ex) {
            model.addAttribute("errorMessage", "Contact not found");
        }
        model.addAttribute("allowDelete", true);
        model.addAttribute("m_pack", pack);
        return "pack_form";
    }

    @PostMapping(value = {"/{packid}/delete"})
    public String deletePackById(
            Model model, @PathVariable long packid) {
        try {
            packService.deletePackById(packid);
            return "redirect:/packs/list";
        } catch (Exception ex) {
            String errorMessage = ex.getMessage();
            model.addAttribute("errorMessage", errorMessage);
            return "pack_form";
        }
    }


}
