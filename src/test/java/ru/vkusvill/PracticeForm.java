package ru.vkusvill;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $x("//input[@id='firstName']").setValue("Biba");
        $x("//input[@id='lastName']").setValue("Fedotov");
        $x("//input[@id='userEmail']").setValue("Biba@mail.ru");
        $x("//label[@for='gender-radio-3']").click();
        $x("//input[@id='userNumber']").setValue("88005553535");
        $x("//input[@id='dateOfBirthInput']").click();
        $x("//select[contains(@class, 'react-datepicker__year-select')]").selectOptionByValue("2000");
        $x("//select[contains (@class, 'react-datepicker__month-select')]").selectOptionByValue("3");
        $x("//div[contains(@class, 'react-datepicker__day--020') and text()='20']").click();
        $x("//input[@id='subjectsInput']").setValue("Maths").pressEnter();
        $x("//label[@for='hobbies-checkbox-1']").click();
        $x("//input[@id='uploadPicture']").uploadFromClasspath("image.jpg");
        $x("//textarea[@id='currentAddress']").setValue("Moscow, Летниковская ул, д. 2");
        $x("//div[@class=' css-1wa3eu0-placeholder']").scrollIntoView(true);//Скролл до выбора штата
        $x("//div[contains(@id, 'state')]").click();
        $x("//div[@id='react-select-3-option-0']").click();
        $x("//*[contains(@id, 'city')]").click();
        $x("//div[@id='react-select-4-option-0']").click();
        $x("//button[contains(@id, 'submit')]").click();


        $x("//div[contains(@class, 'modal-dialog modal-lg')]").should(appear);
        $x("//div[contains(@id, 'example-modal-sizes-title-lg')]").shouldHave(text("Thanks for submitting the form"));
        $x("//div[contains(@class, 'modal-body')]").shouldHave(text("Biba Fedotov"), text("Biba@mail.ru"), text("8800555353"));




        //setTimeout(function() {debugger},4000);


    }
}