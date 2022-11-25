package Pages;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SetRandomDataFoForm {
    Random rand = new Random();
    public String choiceGen(){
        List<String> listDate = Arrays.asList("Male", "Female", "Other");
        String gen = listDate.get(rand.nextInt(listDate.size()));
        return gen;
    }
    public String choiceSubj(){
        List<String> listDate = Arrays.asList("Maths", "Chemistry", "Computer Science", "Commerce", "Economics");
        String subj = listDate.get(rand.nextInt(listDate.size()));
        return subj;
    }
    public String choiceHobb(){
        List<String> listDate = Arrays.asList("Sports", "Reading", "Music");
        String hobb = listDate.get(rand.nextInt(listDate.size()));
        return hobb;
    }
    public String choiceState(){
        List<String> listDate = Arrays.asList("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        String state = listDate.get(rand.nextInt(listDate.size()));
        return state;
    }
    public String choiceCity(String state){
        String city = "";
        if (state == "NCR") {
            List<String> listDate = Arrays.asList("Delhi", "Gurgaon", "Noida");
            city = listDate.get(rand.nextInt(listDate.size()));
        }
        else if (state == "Uttar Pradesh"){
            List<String> listDate = Arrays.asList("Agra", "Lucknow", "Merrut");
            city = listDate.get(rand.nextInt(listDate.size()));
        }
        else if (state == "Haryana"){
            List<String> listDate = Arrays.asList("Karnal", "Panipat");
            city = listDate.get(rand.nextInt(listDate.size()));
        }
        else if (state == "Rajasthan"){
            List<String> listDate = Arrays.asList("Jaipur", "Jaiselmer");
            city = listDate.get(rand.nextInt(listDate.size()));
        }
        return city;
    }
}
