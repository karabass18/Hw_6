import Pages.FormPage;
import Pages.SetRandomDataFoForm;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

public class TestsOfForm extends StartsSet {


    @Test
    void fillFormTest() {
        Faker faker = new Faker(new Locale("en"));
        String userName = faker.name().firstName();
        String userLastName = faker.name().lastName();
        String userEmail = faker.internet().emailAddress();
        String userAdd = faker.address().streetAddress();

        SetRandomDataFoForm setRandomDataFoForm = new SetRandomDataFoForm();
        String userGen = setRandomDataFoForm.choiceGen();
        String userSubj = setRandomDataFoForm.choiceSubj();
        String userHobb = setRandomDataFoForm.choiceHobb();
        String userState = setRandomDataFoForm.choiceState();
        String userCity = setRandomDataFoForm.choiceCity(userState);

        String userPhone = RandomStringUtils.random(10, false, true);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        String[] birthday = dateFormat.format(faker.date().birthday()).split(" ");
        String userBDDay = birthday[0];
        String userBDMonth = birthday[1];
        String userBDYear = birthday[2];

        String picPath = "src/test/resources/";
        String picName = "squid-game-anime.jpg";

        FormPage formPage = new FormPage();
        formPage.openForm()
                .setFirstName(userName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGen(userGen)
                .setPhone((userPhone))
                .setBDay(userBDDay, userBDMonth, userBDYear)
                .setSubj(userSubj)
                .setHobby(userHobb)
                .uploadPic(picPath + picName)
                .setAddress(userAdd)
                .setState(userState)
                .setCity(userCity)
                .submitInfo();


        formPage.checkRegistrResultTabAppear()
                .checkRegistrResult("Student Name", userName + " " + userLastName)
                .checkRegistrResult("Student Email", userEmail)
                .checkRegistrResult("Gender", userGen)
                .checkRegistrResult("Mobile", userPhone)
                .checkRegistrResult("Date of Birth", userBDDay + " " + userBDMonth + "," + userBDYear)
                .checkRegistrResult("Subjects", userSubj)
                .checkRegistrResult("Hobbies", userHobb)
                .checkRegistrResult("Picture", picName)
                .checkRegistrResult("Address", userAdd)
                .checkRegistrResult("State and City", userState + " " + userCity);
    }
}