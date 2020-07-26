package com.codeforce.product.restController;

import com.codeforce.product.model.Pack;
import com.codeforce.product.service.PackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*Alimbetov Ruslan*/

@RestController
@RequestMapping("/packs")
public class PackRestController {

    @Autowired
    PackService packService;

    @GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<List<Pack>> getAllPacks() {
        List<Pack> list = packService.getAllPacks();
        return new ResponseEntity<List<Pack>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pack> getPackById(@PathVariable("id") Long id) {
        Pack entity = packService.getPackById(id);
        return new ResponseEntity<Pack>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pack> createOrUpdatePack(Pack pack) {
        Pack updated = packService.createOrUpdatePack(pack);
        return new ResponseEntity<Pack>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deletePackById(@PathVariable("id") Long id) {
        packService.deletePackById(id);
        return HttpStatus.FORBIDDEN;
    }


}