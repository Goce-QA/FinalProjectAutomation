package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.DataProviders;

import javax.xml.transform.Source;

public class CreateAccountTest extends BaseClass {

    String successfulCreateMessage = "Thank you for registering with Main Website Store.";
    String alreadyCreatedMessage = "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";
    String requiredMessage = "This is a required field.";
    String weekPasswordLessThenEightCharacters = "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored.";
    String weekPasswordNoSpecialChar = "Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.";
    String passwordNotMatchMessage = "Please enter the same value again.";
    String passwordWithSpaceMessage = "The password can't begin or end with a space. Verify the password and try again.";
    By firstNameRequired = By.xpath("//*[@id=\"firstname-error\"]");
    By lastNameRequired = By.xpath("//*[@id=\"lastname-error\"]");
    By emailRequired = By.xpath("//*[@id=\"email_address-error\"]");
    By passwordRequired = By.xpath("//*[@id=\"password-error\"]");
    By confirmPasswordRequired = By.xpath("//*[@id=\"password-confirmation-error\"]");
    By passwordWithSpace = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div");
    int invocation=0;

    @Test(priority = 1, dataProvider = "userData", dataProviderClass = DataProviders.class)
    public void noFirstName (String insertLastName, String insertemailAddress, String insertPassword, String insertConfirmPassword) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]")));
        homePage.createAccount();
        homePage.setLastName(insertLastName);
        homePage.setEmail(insertemailAddress);
        homePage.setPassword(insertPassword);
        homePage.setConfirmPassword(insertConfirmPassword);
        homePage.clickCreatAccout();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"firstname-error\"]")));
        Assert.assertEquals(driver.findElement(firstNameRequired).getText(),requiredMessage);
        System.out.println("Message for the empty Fisrt Name "+"'"+driver.findElement(firstNameRequired).getText()+"'"+" "+"should be equal to "+"'"+requiredMessage+"'");

    }

    @Test(priority = 2, dataProvider = "userData", dataProviderClass = DataProviders.class)
    public void noLastName (String insertFirstName, String insertemailAddress, String insertPassword, String insertConfirmPassword) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]")));
        homePage.createAccount();
        homePage.setFirstName(insertFirstName);
        homePage.setEmail(insertemailAddress);
        homePage.setPassword(insertPassword);
        homePage.setConfirmPassword(insertConfirmPassword);
        homePage.clickCreatAccout();

        Assert.assertEquals(driver.findElement(lastNameRequired).getText(),requiredMessage);
        System.out.println("Message for the empty Last Name "+"'"+driver.findElement(lastNameRequired).getText()+"'"+" "+"should be equal to "+"'"+requiredMessage+"'");

    }

    @Test(priority = 3, dataProvider = "userData", dataProviderClass = DataProviders.class)
    public void noEmailAddress (String insertFirstName, String insertLasttName, String insertPassword, String insertConfirmPassword) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]")));
        homePage.createAccount();
        homePage.setFirstName(insertFirstName);
        homePage.setLastName(insertLasttName);
        homePage.setPassword(insertPassword);
        homePage.setConfirmPassword(insertConfirmPassword);
        homePage.clickCreatAccout();

        Assert.assertEquals(driver.findElement(emailRequired).getText(),requiredMessage);
        System.out.println("Message for the empty email address "+"'"+driver.findElement(emailRequired).getText()+"'"+" "+"should be equal to "+"'"+requiredMessage+"'");

    }

    @Test(priority = 4, dataProvider = "userData", dataProviderClass = DataProviders.class)
    public void noPassword (String insertFirstName, String insertLasttName, String insertemailAddress, String insertConfirmPassword) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]")));
        homePage.createAccount();
        homePage.setFirstName(insertFirstName);
        homePage.setLastName(insertLasttName);
        homePage.setEmail(insertemailAddress);
        homePage.setConfirmPassword(insertConfirmPassword);
        homePage.clickCreatAccout();

        Assert.assertEquals(driver.findElement(passwordRequired).getText(),requiredMessage);
        System.out.println("Message for the empty Password field "+"'"+driver.findElement(passwordRequired).getText()+"'"+" "+"should be equal to "+"'"+requiredMessage+"'");

    }

    @Test(priority = 5, dataProvider = "userData", dataProviderClass = DataProviders.class)
    public void noConfirmPassword (String insertFirstName, String insertLasttName, String insertemailAddress, String insertPassword) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]")));
        homePage.createAccount();
        homePage.setFirstName(insertFirstName);
        homePage.setLastName(insertLasttName);
        homePage.setEmail(insertemailAddress);
        homePage.setPassword(insertPassword);
        homePage.clickCreatAccout();

        Assert.assertEquals(driver.findElement(confirmPasswordRequired).getText(),requiredMessage);
        System.out.println("Message for the empty Confirmation Password Field "+"'"+driver.findElement(confirmPasswordRequired).getText()+"'"+" "+"should be equal to "+"'"+requiredMessage+"'");

    }

    @Test(priority = 6, dataProvider = "userData", dataProviderClass = DataProviders.class)
    public void fullUserWeekPassword(String insertFirstName, String insertLasttName, String insertemailAddress, String insertPassword, String insertConfirmPassword) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]")));
        homePage.createAccount();
        homePage.setFirstName(insertFirstName);
        homePage.setLastName(insertLasttName);
        homePage.setEmail(insertemailAddress);
        homePage.setPassword(insertPassword);
        homePage.setConfirmPassword(insertConfirmPassword);
        homePage.clickCreatAccout();

        Assert.assertEquals(homePage.passwordLessThenEightCharacterMessage(),weekPasswordLessThenEightCharacters);
        System.out.println(homePage.passwordLessThenEightCharacterMessage());

    }

    @Test(priority = 7, dataProvider = "userData", dataProviderClass = DataProviders.class)
    public void fullUserWeekPasswordNoSpecialCharacter(String insertFirstName, String insertLasttName, String insertemailAddress, String insertPassword, String insertConfirmPassword) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]")));
        homePage.createAccount();
        homePage.setFirstName(insertFirstName);
        homePage.setLastName(insertLasttName);
        homePage.setEmail(insertemailAddress);
        homePage.setPassword(insertPassword);
        homePage.setConfirmPassword(insertConfirmPassword);
        homePage.clickCreatAccout();

        Assert.assertEquals(homePage.passwordNoSpecialCharacterMessage(),weekPasswordNoSpecialChar);
        System.out.println(homePage.passwordNoSpecialCharacterMessage());

    }

    @Test(priority = 8, dataProvider = "userData", dataProviderClass = DataProviders.class)
    public void fullUserWeekPasswordNoDigit (String insertFirstName, String insertLasttName, String insertemailAddress, String insertPassword, String insertConfirmPassword) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]")));
        homePage.createAccount();
        homePage.setFirstName(insertFirstName);
        homePage.setLastName(insertLasttName);
        homePage.setEmail(insertemailAddress);
        homePage.setPassword(insertPassword);
        homePage.setConfirmPassword(insertConfirmPassword);
        homePage.clickCreatAccout();

        Assert.assertEquals(homePage.passwordNoSpecialCharacterMessage(),weekPasswordNoSpecialChar);
        System.out.println(homePage.passwordNoSpecialCharacterMessage());
    }

    @Test(priority = 9, dataProvider = "userData", dataProviderClass = DataProviders.class)
    public void fullUserPasswordNotMatch (String insertFirstName, String insertLasttName, String insertemailAddress, String insertPassword, String insertConfirmPassword) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]")));
        homePage.createAccount();
        homePage.setFirstName(insertFirstName);
        homePage.setLastName(insertLasttName);
        homePage.setEmail(insertemailAddress);
        homePage.setPassword(insertPassword);
        homePage.setConfirmPassword(insertConfirmPassword);
        homePage.clickCreatAccout();

        Assert.assertEquals(homePage.passwordNotMatch(),passwordNotMatchMessage);
        System.out.println(homePage.passwordNotMatch());

    }

    @Test(priority = 10, dataProvider = "userData", dataProviderClass = DataProviders.class)
    public void noPasswordsAtAll (String insertFirstName, String insertLasttName, String insertemailAddress) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]")));
        homePage.createAccount();
        homePage.setFirstName(insertFirstName);
        homePage.setLastName(insertLasttName);
        homePage.setEmail(insertemailAddress);
        homePage.clickCreatAccout();

        Assert.assertEquals(driver.findElement(passwordRequired).getText(),requiredMessage);
        System.out.println("Message for the empty email address "+"'"+driver.findElement(passwordRequired).getText()+"'"+" "+"should be equal to "+"'"+requiredMessage+"'");

    }

    @Test(priority = 11, dataProvider = "userData", dataProviderClass = DataProviders.class)
    public void passwordWithSpace (String insertFirstName, String insertLasttName, String insertemailAddress, String insertPassword, String insertConfirmPassword) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]")));
        homePage.createAccount();
        homePage.setFirstName(insertFirstName);
        homePage.setLastName(insertLasttName);
        homePage.setEmail(insertemailAddress);
        homePage.setPassword(insertPassword);
        homePage.setConfirmPassword(insertConfirmPassword);
        homePage.clickCreatAccout();

        Assert.assertEquals(driver.findElement(passwordWithSpace).getText(),passwordWithSpaceMessage);
        System.out.println("'"+driver.findElement(passwordWithSpace).getText()+"'"+" "+"should be equal to "+"'"+passwordNotMatchMessage+"'");

    }

    @Test(priority = 12, dataProvider = "userData", dataProviderClass = DataProviders.class)
    public void passwordEndsWithSpace (String insertFirstName, String insertLasttName, String insertemailAddress, String insertPassword, String insertConfirmPassword) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]")));
        homePage.createAccount();
        homePage.setFirstName(insertFirstName);
        homePage.setLastName(insertLasttName);
        homePage.setEmail(insertemailAddress);
        homePage.setPassword(insertPassword);
        homePage.setConfirmPassword(insertConfirmPassword);
        homePage.clickCreatAccout();

        Assert.assertEquals(driver.findElement(passwordWithSpace).getText(),passwordWithSpaceMessage);
        System.out.println("'"+driver.findElement(passwordWithSpace).getText()+"'"+" "+"should be equal to "+"'"+passwordNotMatchMessage+"'");

    }

    @Test(priority = 13, dataProvider = "userData", dataProviderClass = DataProviders.class)
    public void passwordWithSpaceInMiddle (String insertFirstName, String insertLasttName, String insertemailAddress, String insertPassword, String insertConfirmPassword) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]")));
        homePage.createAccount();
        homePage.setFirstName(insertFirstName);
        homePage.setLastName(insertLasttName);
        homePage.setEmail(insertemailAddress);
        homePage.setPassword(insertPassword);
        homePage.setConfirmPassword(insertConfirmPassword);
        homePage.clickCreatAccout();

        Assert.assertEquals(homePage.messageSuccessful(),successfulCreateMessage);
        System.out.println("'"+homePage.messageSuccessful()+"'"+" "+"should be equal to "+"'"+successfulCreateMessage+"'");

    }

    @Test(priority = 14, dataProvider = "userData", dataProviderClass = DataProviders.class, invocationCount = 3)
    public void fullUserStrongPassword (String insertFirstName, String insertLasttName, String insertemailAddress, String insertPassword, String insertConfirmPassword) {
//      Testing with data for user that is already used for account creation
        invocation++;

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]")));
        homePage.createAccount();
        homePage.setFirstName(insertFirstName);
        homePage.setLastName(insertLasttName);
        homePage.setEmail(insertemailAddress);
        homePage.setPassword(insertPassword);
        homePage.setConfirmPassword(insertConfirmPassword);
        homePage.clickCreatAccout();



        Assert.assertEquals(homePage.messageAlready(),alreadyCreatedMessage);
        System.out.println("'"+homePage.messageAlready()+"'"+" "+"should be equal to "+"'"+alreadyCreatedMessage+"'");


    }

    @Test(priority = 15, dataProvider = "userData", dataProviderClass = DataProviders.class)
    public void fullUserAccount (String insertFirstName, String insertLasttName, String insertemailAddress, String insertPassword, String insertConfirmPassword) {

        invocation++;

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]")));
        homePage.createAccount();
        homePage.setFirstName(insertFirstName);
        homePage.setLastName(insertLasttName);
        homePage.setEmail(insertemailAddress);
        homePage.setPassword(insertPassword);
        homePage.setConfirmPassword(insertConfirmPassword);
        homePage.clickCreatAccout();


        Assert.assertEquals(homePage.messageSuccessful(),successfulCreateMessage);
        System.out.println("'"+homePage.messageSuccessful()+"'"+" "+"should be equal to "+"'"+successfulCreateMessage+"'");


    }



}

