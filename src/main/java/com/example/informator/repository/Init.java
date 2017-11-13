package com.example.informator.repository;



        import com.example.informator.model.Equipment;
        import org.springframework.beans.factory.annotation.Autowired;

        import org.springframework.stereotype.Component;

        import javax.annotation.PostConstruct;
        import javax.imageio.ImageIO;

        import java.awt.*;
        import java.awt.image.BufferedImage;
        import java.io.*;
        import java.util.*;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;


@Component
public class Init {

    @Autowired
   EquipmentRepository equipmentRepository;



    @PostConstruct
    public void init() throws IOException {
        Equipment equipment =equipmentRepository.findOne(1);

        if (equipment == null) {
           Equipment equipment1 = new Equipment();
            equipment1.setName("name");
            equipment1.setDescription("Opis");

//            byte[] imageInByte = new byte[0];
//            try {
//
//                BufferedImage originalImage = ImageIO.read(new File(
//                        "C:\\Users\\Dii\\Desktop\\informator\\src\\main\\resources\\static\\image\\computer.png"));
//
//
//                // convert BufferedImage to byte array
//                ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                ImageIO.write(originalImage, "png", baos);
//                baos.flush();
//                imageInByte = baos.toByteArray();
//                baos.close();
//
//                // convert byte array back to BufferedImage
//                InputStream in = new ByteArrayInputStream(imageInByte);
//                BufferedImage bImageFromConvert = ImageIO.read(in);
//
//                ImageIO.write(bImageFromConvert, "png", new File(
//                        "C:\\Users\\Dii\\Desktop\\informator\\src\\main\\resources\\static\\image\\computer.png"));
//
//
//            } catch (IOException e) {
//                System.out.println(e.getMessage());
//            }
//
//
//
//
//            equipment1.setImage(imageInByte);

            equipmentRepository.save(equipment1);
        }












////        if (admin == null) {
//            User user = new User();
//            user.setEmail("admin@o2.pl");
//            user.setFirstName("Dominika");
//            user.setLastName("Sporzyńska");
//            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//            user.setPassword(encoder.encode("admin"));
//            user.setRole(Role.ROLE_ADMIN);
//            userRepository.save(user);
//        }

//
//        Survey s = surveyRepository.findOne(1);
//        if (s == null) {
//            Survey survey = new Survey();
//            survey.setTitle("Negatywne aspekty komputeryzacji w życiu współczesnego człowieka");
//            //survey.setQuestion();
//            surveyRepository.save(survey);


            //File file = new File(getClass().getResourceAsStream("/answers.csv"));
            //Scanner in = new Scanner(file);
//            //FileReader fileReader = new FileReader(file);
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/a.txt")));
//            Answer answer;
//            String q = "";
//            try {
//                String textLine = bufferedReader.readLine();
//                while (textLine != null && textLine.length() > 0) {
//                    int index1 = textLine.indexOf(",");
//                    q = textLine.substring(index1 + 1);
//                    System.out.println(q);
//                    answer = new Answer(q);
//                    answerRepository.save(answer);
//                    textLine = bufferedReader.readLine();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    bufferedReader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//ffffffffffffffffffffffffffffffffffffffff

/*            File file = new File("./src/main/resources/static/data/danedobazy/question.csv");
            Scanner in = new Scanner(file);
            in = new Scanner(file);
            FileReader fileReader = new FileReader(file);
            fileReader = new FileReader(file);*/
//            bufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/q.txt")));
//            Question question;
//            ArrayList<Question> listOfQuestion = new ArrayList<Question>();
//
//            q = "";
//            //   String k="";
//            try {
//                String textLine = bufferedReader.readLine();
//                while (textLine != null && textLine.length() > 0) {
//                    int index1 = textLine.indexOf(",");
//                    int index2 = textLine.lastIndexOf(",");
//                    q = textLine.substring(index1 + 1);
//                    //   k= textLine.substring(index2,textLine.length());
//                    System.out.println(q);
//                    question = new Question(q);
//                    questionRepository.save(question);
//                    listOfQuestion.add(question);
//                    textLine = bufferedReader.readLine();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    bufferedReader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }


//
            // bufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/questionsANDanswers.csv")));

//            Question question1 = new Question();
//            Answer answer1;
//            ArrayList<Answer> listOfAnswer = new ArrayList<Answer>();
//
//            q = "";
//
//            long idq = 0;
//            int id = 0;
//            int nextId = 1;
//            BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/questionsANDanswers.txt")));
//            String line = null;
//            Pattern pattern = Pattern.compile("\\d+");
//            while (true) {
//                line = br.readLine();
//                if (line == null) break;
//                String array[] = line.split(",");
//
//                Matcher matcher = pattern.matcher(array[0]);
//                if (matcher.find()) {
//                    id = Integer.parseInt(matcher.group(0));
//                }
//                idq = Long.parseLong(array[1].trim());
//                answer1 = new Answer();
//                answer1.setId(idq);
//                question1.setAnswers(listOfAnswer);
//                if (id == nextId) {
//                    answer1 = new Answer();
//                    answer1.setId(idq);
//                    question1.setAnswers(listOfAnswer);
//                    listOfAnswer.add(answer1);
////                    questionRepository.update(id, question1);
//                    nextId = id;
//                } else {
//                    listOfAnswer.clear();
//                    listOfAnswer.add(answer1);
////                    questionRepository.update(id, question1);
//                    nextId = id;
//                }
////                System.out.println("id " + id + " id2=" + idq);
//            }
//            br.close();


//            survey.setQuestion(listOfQuestion);
//            surveyRepository.update(1, survey);
//
//        }
//    }
//
//
//    public void listFilesForFolder(final File folder) {
//        for (final File fileEntry : folder.listFiles()) {
//            if (fileEntry.isDirectory()) {
//                listFilesForFolder(fileEntry);
//            } else {
//                System.out.println(fileEntry.getName());
//            }
//        }
   }


}





