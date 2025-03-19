package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AddingContactPage {
    private final SelenideElement firstNameField = $x("input[name='firstname']"),
    middleNameField = $x("input[name='middlename']"),
    lastNameField = $x("input[name='lastname']"),
    nicknameField = $x("input[name='nickname']"),
    titleField = $x("input[name='title']"),
    companyField = $x("input[name='company']"),
    addressField = $x("textarea[name='address']"),
    telephoneField = $x("//a[text()='groups']"),
    homeAddressField = $x("input[name='home']"),
    mobileNumberField = $x("input[name='mobile']"),
    workAddressField = $x("input[name='work']"),
    faxNumberField = $x("input[name='fax']"),
    emailField = $x("input[name='email']"),
    homepageField = $x("input[name='homepage']"),
    birthYearField = $x("input[name='byear']") ;

    public SelenideElement getBdayElement(int day){
        return $("select[name='bday']").$("option[value='"+day+"']");
    }
    public SelenideElement getBmonthElement(String month){
        return $("select[name='bmonth']").$("option[value='"+month+"']");
    }
     public AddingContactPage setFirstNameField(String firstName){
        firstNameField.setValue(firstName);
        return this;
     }
    public AddingContactPage setMiddleNameField(String middleName){
        middleNameField.setValue(middleName);
        return this;
    }
    public AddingContactPage setLastNameField(String lastName){
        lastNameField.setValue(lastName);
        return this;
    }
    public AddingContactPage setNicknameField(String nickname){
        nicknameField.setValue(nickname);
        return this;
    }
    public AddingContactPage setTitleField(String title){
        titleField.setValue(title);
        return this;
    }
    public AddingContactPage setCompanyField(String company){
        companyField.setValue(company);
        return this;
    }
    public AddingContactPage setAddressField(String address){
        addressField.setValue(address);
        return this;
    }
    public AddingContactPage setTelephoneField(String telephone){
        telephoneField.setValue(telephone);
        return this;
    }

    public AddingContactPage setHomeAddressField(String homeAddress){
        homeAddressField.setValue(homeAddress);
        return this;
    }
    public AddingContactPage setMobileNumberField(String mobileNumber){
        mobileNumberField.setValue(mobileNumber);
        return this;
    }
    public AddingContactPage setWorkAddressField(String workAddress){
        workAddressField.setValue(workAddress);
        return this;
    }
    public AddingContactPage setFaxNumberField(String faxNumber){
        faxNumberField.setValue(faxNumber);
        return this;
    }
    public AddingContactPage setEmailField(String email){
        emailField.setValue(email);
        return this;
    }
    public AddingContactPage setHomepageField(String homepage){
        homepageField.setValue(homepage);
        return this;
    }
    public AddingContactPage setBirthYearField(String birthYear){
        birthYearField.setValue(birthYear);
        return this;
    }
    public AddingContactPage setBDayField(int day){
        getBdayElement(day);
        return this;
    }
    public AddingContactPage setBMonthField(String month){
        getBmonthElement(month);
        return this;
    }
}
