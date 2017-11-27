package com.example.informator.repository;


import com.example.informator.model.Equipment;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.*;


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

            int i = 1;
            try {
                String textLine = bufferedReader.readLine();
                while (textLine != null && textLine.length() > 0) {
                    int index1 = textLine.indexOf(",");
                    System.out.println(index1);
                    n = textLine.substring(index1 + 1);

                    equ = new Equipment();
                    equ.setName(n);

                    String everything = "";

                    System.out.println("/descripions/" + i + ".txt");

                    BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/descripions/"+i+".txt")));


                    try {
                        StringBuilder sb = new StringBuilder();
                        String line = br.readLine();

                        while (line != null) {
                            sb.append(line);
                            sb.append(System.lineSeparator());
                            line = br.readLine();
                        }
                        everything = sb.toString();
                        System.out.println(everything);
                    } finally {
                        br.close();
                    }
                    byte[] bytes = everything.getBytes();
                    equ.setDescription(everything);



                    try {
//                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/equipmentdata.csv")));
//                        URL url = getClass().getResource("./image/1.png");
//                        File file = new File();
                        File directory = new File("./");
                        System.out.println(directory.getAbsolutePath());
                        BufferedImage originalImage =
                                ImageIO.read(new File("image/"+i+".png"));

                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        ImageIO.write(originalImage, "png", baos);
                        baos.flush();
                        byte[] imageInByte = baos.toByteArray();
                        equ.setImage(imageInByte);
                        baos.close();

                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                        equ.setDescription(everything);
                    equipmentRepository.save(equ);


                    i++;
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





