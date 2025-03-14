package tests;


import org.junit.jupiter.api.Test;
import pages.PageObject;


public class PracticeFormWithPageObject extends TestBase {

    PageObject pageObject = new PageObject();

    @Test
    void succesfullRegistrationTest() {
        pageObject.openPage()
                .setFirstName("Biba")
                .setLastName("Fedotov")
                .setEmail("Biba@mail.ru")
                .setGender()
                .setUserNumber("8800555353")
                .setDateOfBirth("20", "April", "2000")
                .setSubjects("Maths")
                .setHobbies()
                .setAddress("Moscow, Летниковская ул, д. 2")
                .setFile("image.jpg")
                .scrollDaunEbaniy()
                .setState()
                .setCity()
                .submit()

                .checkResultSuccessfull("Student Name", "Biba Fedotov")
                .checkResultSuccessfull("Student Email", "Biba@mail.ru")
                .checkResultSuccessfull("Gender", "Other")
                .checkResultSuccessfull("Mobile", "8800555353")
                .checkResultSuccessfull("Date of Birth", "20 April,2000")
                .checkResultSuccessfull("Subjects", "Maths")
                .checkResultSuccessfull("Hobbies", "Sports")
                .checkResultSuccessfull("Picture", "image.jpg")
                .checkResultSuccessfull("Address", "Moscow, Летниковская ул, д. 2")
                .checkResultSuccessfull("State and City", "NCR Delhi");

    }


    @Test
    void negativeRegistrationTest() {
        pageObject.openPage()
                .submit()
                .checkNegativeResult("border-color", "rgb(220, 53, 69)");
    }

    @Test
    void minimalData() {
        pageObject.openPage()
                .setFirstName("Biba")
                .setLastName("Fedotov")
                .setGender()
                .setUserNumber("88005553535")
                .submit()
                .checkResultMinData();

    }
}