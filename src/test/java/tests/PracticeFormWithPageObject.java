package tests;


import org.junit.jupiter.api.Test;
import pages.PageObject;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormWithPageObject extends TestBase {

    PageObject pageObject = new PageObject();

    @Test
    void succesfullRegistrationTest() {
        pageObject.openPage()
                .setFirstName("Biba")
                .setLastName("Fedotov")
                .setEmail("Biba@mail.ru")
                .setGender()
                .setUserNumber("88005553535")
                .setDateOfBirth("20", "April", "2000")
                .setSubjects("Maths")
                .setHobbies()
                .setAddress("Moscow, Летниковская ул, д. 2")
                .setFile("image.jpg")
                .scrollDaunEbaniy()
                .setState()
                .setCity()
                .submit();


        $x("//div[contains(@class, 'modal-dialog modal-lg')]").should(appear);
        $x("//div[contains(@id, 'example-modal-sizes-title-lg')]").shouldHave(text("Thanks for submitting the form"));
        $x("//div[contains(@class, 'modal-body')]").shouldHave(text("Biba Fedotov"), text("Biba@mail.ru"), text("8800555353"));


    }


    @Test
    void unSuccesfullRegistrationTest() {
        pageObject.openPage()
                .submit()
                .validationMatching("border-color", "rgb(220, 53, 69)");



    }
}