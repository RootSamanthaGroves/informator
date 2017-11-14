package com.example.informator.controller;

import com.example.informator.model.Equipment;
import com.example.informator.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    EquipmentRepository equipmentRepository;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<Equipment> List =equipmentRepository.findAll();
        if (List.size()>0)
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(List);
    }



    @GetMapping("/id/{id}")
    public ResponseEntity getById(@PathVariable long id) {
        Equipment equipment =equipmentRepository.findOne(id);
//        if (equipment.equals(null))
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok(equipment);
    }

    @GetMapping("/name/{name}")
    public  ResponseEntity<Equipment> getByName(@PathVariable String name){
        Equipment equipment = equipmentRepository.findByName(name);
        if (!name.isEmpty()){
            return  new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        else
        {
               return new ResponseEntity<Equipment>(equipment, new HttpHeaders(), HttpStatus.OK);

        }

    }





    @Transactional
    @PostMapping("/add")
    public ResponseEntity<Equipment> post(@RequestBody Equipment equipment) {
      equipmentRepository.save(equipment);
        if ((equipment.getId() != -1)) {
            return ResponseEntity.ok(equipment);
        }
        return new ResponseEntity<Equipment>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<Equipment> delete(@PathVariable long id) {
        //   System.out.println("AutoController.deleteAuto");
        if (id != -1) {
            //   System.out.println("AutoController.deleteAuto");
            Equipment e = equipmentRepository.findOne(id);
            equipmentRepository.deleteOne(id);
            if (e != null) {
                System.out.println("AutoController.deleteAuto ok");
                return new ResponseEntity(e, new HttpHeaders(), HttpStatus.OK);
            } else {
                System.out.println("AutoController.deleteAuto 404");
                return new ResponseEntity(new HttpHeaders(), HttpStatus.NOT_FOUND);
            }
        } else {
            System.out.println("AutoController.deleteAuto 400");
            return new ResponseEntity(new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }
    }
}
