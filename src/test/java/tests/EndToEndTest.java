package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseClass;

public class EndToEndTest extends BaseClass {
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
    String directAddingToChar = "You need to choose options for your item.";
    String successfulAddToChar = "You added Montana Wind Jacket to your shopping cart.";
    String successfullyAddToChar2 = "You added Taurus Elements Shell to your shopping cart.";
    String messageRequiredFields = "This is a required field.";


    //Successful creation of account and adding two products to cart
    @Test(dataProvider = "userData", dataProviderClass = utils.DataProviders.class)
    public void fullUser (String insertFirstName, String insertLastName, String insertemailAddress, String insertPassword, String insertConfirmPassword, String insertStreetAddress, String insertCity, String insertZipCode, String insertPhoneNumber) throws InterruptedException {
        //Account Creation
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]")));
        homePage.createAccount();
        homePage.setFirstName(insertFirstName);
        homePage.setLastName(insertLastName);
        homePage.setEmail(insertemailAddress);
        homePage.setPassword(insertPassword);
        homePage.setConfirmPassword(insertConfirmPassword);
        homePage.clickCreatAccout();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")));
        assertt.assertEquals(homePage.messageSuccessful(),successfulCreateMessage);
        System.out.println("\n"+"'"+homePage.messageSuccessful()+"'"+" "+"should be equal to "+"'"+successfulCreateMessage+"'"+"\n");
        String fullName = insertFirstName+" "+insertLastName;
        String informationMessage = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div/div[1]/p")).getText();
        assertt.assertTrue(informationMessage.contains(fullName));
        System.out.println("'"+informationMessage+"'"+" contains inside the user Full Name "+"'"+fullName+"'"+" and the email address "+"'"+insertemailAddress+"'"+"\n");

        //Adding first item in cart
        homePage.menuNavigation();
        assertt.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div/div[1]/div[1]")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div/div[1]/div[1]")).getText()+" is visible and we can click on it"+"\n");
        homePage.setFilterForFirstItem();
        homePage.item1Size();
        homePage.item1Color();
        homePage.item1AddToCart();



        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/main/div[2]/div[2]/div/div/div")));
        String messageSuccesfulAdd = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[2]/div/div/div")).getText();
        assertt.assertEquals(messageSuccesfulAdd, successfulAddToChar);
        System.out.println("Message displayed when adding item to cart without opening "+"'"+ messageSuccesfulAdd +"'"+" "+"should be the same as the expected message "+"'"+successfulAddToChar+"'"+"\n");

        //Clear filter
        homePage.clearFilter();

        //Adding second item in cart
        assertt.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div/div[1]/div[1]")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div/div[1]/div[1]")).getText()+" is visible and we can click on it"+"\n");
        homePage.setFilterForSecondItem();
        homePage.item2Size();
        homePage.item2Color();
        homePage.item2AddToCart();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")));
        String messageSuccesfulAdd2 = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText();
        assertt.assertEquals(messageSuccesfulAdd2, successfullyAddToChar2);
        System.out.println("Message displayed when adding item to cart without opening "+"'"+ messageSuccesfulAdd2 +"'"+" "+"should be the same as the expected message "+"'"+successfullyAddToChar2+"'"+"\n");

        //Checkout
        homePage.goUpAndInTheCartToCheckout();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"shipping\"]/div[1]")));
        String checkoutMessage = driver.findElement(By.xpath("//*[@id=\"shipping\"]/div[1]")).getText();
        assertt.assertEquals(checkoutMessage,"Shipping Address");
        homePage.userStreetAddress(insertStreetAddress);
        homePage.userCity(insertCity);
        homePage.userZipCode(insertZipCode);
        homePage.userPhoneNumber(insertPhoneNumber);
        homePage.nextButton();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[2]/div/div[2]")));
        String userShippingInformation = driver.findElement(By.xpath("//*[@class='billing-address-details']")).getText();
        String shippingInformationData[] = {insertFirstName, insertLastName,insertStreetAddress, insertCity, insertZipCode,insertPhoneNumber};

        for (String shipping:shippingInformationData ) {
            Assert.assertTrue(userShippingInformation.contains(shipping));
        }

        System.out.println(userShippingInformation+ "\n"+" In case the shipping address is not correct please click on Edit button."+"\n");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button/span")));

        homePage.placeOrderButton();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/main/div[1]/h1/span")));
        String finalMessage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/h1/span")).getText();
        System.out.println(finalMessage+" You have successfully placed an order"+"\n");

    }

}
