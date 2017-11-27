package com.example.informator.repository;


import com.example.informator.model.Equipment;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URISyntaxException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class Init {

    @Autowired
    EquipmentRepository equipmentRepository;


    @PostConstruct
    public void init() throws IOException {
        Equipment equipment = equipmentRepository.findOne(1);

        if (equipment == null) {



            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/equipmentdata.csv")));
            Equipment equ;
            String n = "";
            String d = "";
            try {
                String textLine = bufferedReader.readLine();
                while (textLine != null && textLine.length() > 0) {
                    int index1 = textLine.indexOf(",");
//                       int index2 = textLine.indexOf(\"");
                    System.out.println(index1);
                    n = textLine.substring(index1 + 1);
//                d = textLine.substring(index2, textLine.length());
//                System.out.println(n);
//               System.out.println(d);

                    equ = new Equipment();
                    equ.setName(n);
//                equ.setDescription(d);


                    equipmentRepository.save(equ);
                    textLine = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }


    }


}





