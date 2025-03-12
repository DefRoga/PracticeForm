package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.*;

public class PageObject {

    private SelenideElement firstNameInput = $x("//input[@id='firstName']"),
            lastNameInput = $x("//input[@id='lastName']"),
            emailInput = $x("//input[@id='userEmail']"),
            genderRadio = $x("//label[@for='gender-radio-3']"),
            userNumber = $x("//input[@id='userNumber']"),
            calendar = $x("//input[@id='dateOfBirthInput']"),
            subjectsInput = $x("//input[@id='subjectsInput']"),
            hobbiesCheckbox = $x("//label[@for='hobbies-checkbox-1']"),
            fileInput = $x("//input[@id='uploadPicture']"),
            addressInput = $x("//textarea[@id='currentAddress']"),
            scrollDown = $x("//div[@class=' css-1wa3eu0-placeholder']"),
            stateClick = $x("//div[contains(@id, 'state')]"),
            stateInput =  $x("//div[@id='react-select-3-option-0']"),
            cityClick = $x("//*[contains(@id, 'city')]"),
            cityInput =  $x("//div[@id='react-select-4-option-0']"),
            submitButton = $x("//button[contains(@id, 'submit')]");

            //Тут дальше будут проверки


    CalendarComponent calendarComponent = new CalendarComponent();


    public PageObject openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public PageObject setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public PageObject setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public PageObject setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public PageObject setGender() {
        genderRadio.click();

        return this;
    }

    public PageObject setUserNumber(String value) {
        userNumber.setValue(value);

        return this;
    }

    public PageObject setDateOfBirth(String day, String month, String year) {
        calendar.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public PageObject setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public PageObject setHobbies() {
        hobbiesCheckbox.click();

        return this;
    }

    public PageObject setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public PageObject setFile(String value) {
        fileInput.uploadFromClasspath(value);

        return this;
    }

    public PageObject scrollDaunEbaniy() {
        scrollDown.scrollIntoView(true);

        return this;
    }

    public PageObject setState() {
        stateClick.click();
        stateInput.click();

        return this;
    }

    public PageObject setCity() {
        cityClick.click();
        cityInput.click();

        return this;
    }

    public PageObject submit() {
        submitButton.click();

        return this;
    }

    public PageObject validationMatching(String key, String value) {
        firstNameInput.shouldBe(cssValue(key, value));
        lastNameInput.shouldBe(cssValue(key, value));
        userNumber.shouldBe(cssValue(key, value));
        $x("//label[@for='gender-radio-1']").shouldBe(cssValue(key, value));
        $x("//label[@for='gender-radio-2']").shouldBe(cssValue(key, value));
        $x("//label[@for='gender-radio-3']").shouldBe(cssValue(key, value));

        return this;
    }


}

