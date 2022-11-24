package Pages;

import Pages.components.CalendarComp;
import Pages.components.ResultTab;

import java.io.File;
import java.util.Arrays;
import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class FormPage {
    public FormPage openForm() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public FormPage setFirstName(String name) {
        $("#firstName").setValue(name);
        return this;
    }

    public FormPage setLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    public FormPage setEmail(String email) {
        $("#userEmail").scrollIntoView(true);
        $("#userEmail").setValue(email);
        return this;
    }

    public FormPage setGen(String gen) {
        $("[name = 'gender']" + "[value = " + gen + "]").doubleClick();
        return this;
    }

    public FormPage setPhone(String phone) {
        $("#userNumber").setValue(phone);
        return this;
    }

    public FormPage setBDay(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        new CalendarComp().setDate(day, month, year);
        return this;
    }

    public FormPage setSubj(String subj) {
        $("#subjectsContainer").click();
        $("#subjectsContainer #subjectsInput").setValue(subj).pressEnter();
        ;
        return this;
    }

    public FormPage setHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;
    }

    public FormPage uploadPic(String userPic) {
        $("#uploadPicture").uploadFile(new File(userPic));
        return this;
    }

    public FormPage setAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    public FormPage setState(String state) {
        $("#submit").scrollIntoView(true);
        $("#state ").click();
        $(byText(state)).click();
        return this;
    }

    public FormPage setCity(String city) {
        $("#city ").click();
        $(byText(city)).click();
        return this;
    }

    public FormPage submitInfo() {
        $("#submit").click();
        return this;
    }

    public FormPage checkRegistrResultTabAppear() {
        new ResultTab().checkResultTabAppear();
        return this;
    }

    public FormPage checkRegistrResult(String key, String value) {
        new ResultTab().checkResultTab(key, value);
        return this;
    }

   /* public void
    var rand = new Random();
    var list = Arrays.asList("apple", "orange", "grape");
    var randomElement = list.get(rand.nextInt(list.size()));*/

}
