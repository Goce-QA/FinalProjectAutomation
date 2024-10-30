//Thread Sleep is used instead of Implicit or Explicit Wait because of the testing web page.

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BaseClass;

public class HomePage {
    protected static WebDriver driver;



    public String messageAlready () {
        String alreadyCreated = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText();
        return alreadyCreated;
    }

    public String messageSuccessful(){
        String successfulCreate = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
        return successfulCreate;
    }

    public String passwordLessThenEightCharacterMessage (){
        String passwordmessagetext=driver.findElement(By.xpath("//*[@id=\"password-error\"]")).getText();
        return passwordmessagetext;
    }

    public String passwordNoSpecialCharacterMessage (){
        String passwordNoSpecialCharacter = driver.findElement(By.xpath("//*[@id=\"password-error\"]")).getText();
        return passwordNoSpecialCharacter;
    }

    public String passwordNotMatch (){
        String passwordNoMatch = driver.findElement(By.xpath("//*[@id=\"password-confirmation-error\"]")).getText();
        return passwordNoMatch;
    }


    //Creating account Xpath
    By createAnAccount = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[3]");
    By firstName = By.xpath("//*[@id='firstname']");
    By lastName = By.xpath("//*[@id='lastname']");
    By email = By.xpath("//*[@id='email_address']");
    By password = By.xpath("//*[@id='password']");
    By confirmPassword = By.xpath("//*[@id='password-confirmation']");
    By createAccount = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span");



    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    // Create Account
    public void createAccount () {
        driver.findElement(createAnAccount).click();
    }

    public void setFirstName(String insertFirstName) {
        driver.findElement(firstName).sendKeys(insertFirstName);
    }

    public void setLastName (String insertLastName) {
        driver.findElement(lastName).sendKeys(insertLastName);
    }

    public void setEmail (String insrtEmailAddress) {
        driver.findElement(email).sendKeys(insrtEmailAddress);
    }

    public void setPassword (String insertPassword) {
        scrollDown(400);
        driver.findElement(password).sendKeys(insertPassword);
    }

    public void setConfirmPassword (String insertConfirmPassword) {
        driver.findElement(confirmPassword).sendKeys(insertConfirmPassword);
    }

    public void clickCreatAccout () {
        driver.findElement(createAccount).click();
    }


    // Menu navigation and selection
    public void menuNavigation() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        Thread.sleep(2000);
        WebElement menMenu = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/nav/ul/li[3]/a/span[1]"));
        actions.moveToElement(menMenu).perform();
        Thread.sleep(2000);
        WebElement topsMenu = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/nav/ul/li[3]/ul/li[1]/a/span[2]"));
        actions.moveToElement(topsMenu).perform();
        Thread.sleep(2000);
        WebElement jacketsMenue = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/nav/ul/li[3]/ul/li[1]/ul/li[1]/a/span"));
        jacketsMenue.click();
        Thread.sleep(1000);
    }

    public void setFilterForFirstItem () throws InterruptedException {
        WebElement styleMenu = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div/div[1]/div[1]"));
        styleMenu.click();
        Thread.sleep(2000);

        WebElement item1SelectMenu = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div/div[1]/div[2]/ol/li[9]"));
        String windbreaker = item1SelectMenu.getText();
        Assert.assertTrue(item1SelectMenu.isDisplayed());
        System.out.println("Windbreaker option in STYLE menu is visible and we can click on it."+"\n");
        item1SelectMenu.click();

        Thread.sleep(2000);

        scrollDown(300);
        Thread.sleep(2000);
    }

    public void item1Size () {
        WebElement jacket1Size = driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-170\"]"));
        String sizeSelected = jacket1Size.getText();
        jacket1Size.click();
        Assert.assertTrue(sizeSelected.contains("XL"));
        System.out.println("Selected size is XL"+"\n");
    }

    public void item1Color () {
        WebElement jacket1Color = driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-49\"]"));
        jacket1Color.click();

    }

    public void hoverOverJacket1 () throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement hoverOverJacket1 = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div/a/span/span/img"));
        actions.moveToElement(hoverOverJacket1).perform();
        Thread.sleep(2000);
    }
    public void clickOnJacket1 () throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[1]/div")).click();
        Thread.sleep(2000);
    }

    public void selectSizeOpenedJacket1 (){
        driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-168\"]")).click();
    }

    public void selectColorOpenedJacket1 (){
        driver.findElement(By.xpath("//*[@id=\"option-label-color-93-item-53\"]")).click();
    }

    public void addToCharOpenedItem (){
        driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
    }

    public void item1AddToCart () {
        WebElement jacket1AddToCart = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[4]/div/div[1]/form/button/span"));
        String addToCartButton = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[1]/div/div/div[4]/div/div[1]/form/button/span")).getText();
        Assert.assertTrue(jacket1AddToCart.isDisplayed());
        System.out.println("'"+addToCartButton+"'"+" button is visible and we can click on it"+"\n");
        jacket1AddToCart.click();
    }

    public void clearFilter() {
        WebElement clearAll = driver.findElement(By.xpath("//*[@id=\"layered-filter-block\"]/div[2]/div[2]/a/span"));
        String clearFilterOption = driver.findElement(By.xpath("//*[@id=\"layered-filter-block\"]/div[2]/div[2]/a/span")).getText();
        Assert.assertTrue(clearAll.isDisplayed());
        System.out.println("'"+clearFilterOption+"'"+" is visible and we can clear our filters"+"\n");
        clearAll.click();
    }


    public void setFilterForSecondItem () throws InterruptedException {
        WebElement styleMenu1 = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div/div[1]/div[1]"));
        Thread.sleep(1000);
        styleMenu1.click();
        Thread.sleep(2000);

        WebElement item2FromMenu = driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[3]"));
        String lightweight = item2FromMenu.getText();
        String lightweightAndAvailableItems = lightweight.replace("\n", " ").replaceAll("\\s+", " ");
        Assert.assertTrue(item2FromMenu.isDisplayed());
        System.out.println("'"+lightweightAndAvailableItems+"'"+ " option in STYLE menu is visible and we can click on it."+"\n");
        item2FromMenu.click();
        Thread.sleep(2000);

        Select s = new Select(driver.findElement(By.id("sorter")));
        s.selectByValue("name");
        Thread.sleep(2000);

        scrollDown(900);
        Thread.sleep(3000);
    }

    public void item2Size () {
        WebElement jacket2Size = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[6]/div/div/div[3]/div[1]/div/div[3]"));
        String item2Size = jacket2Size.getText();
        jacket2Size.click();
        Assert.assertTrue(item2Size.contains("M"));
        System.out.println("Selected size is M"+"\n");
    }

    public void item2Color () {
        WebElement jacket2Color = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/ol/li[6]/div/div/div[3]/div[2]/div/div[1]"));
        jacket2Color.click();
    }

    public void hoverOnJacket2 () throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement hoverOnJacket2 = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[6]/div"));
        actions.moveToElement(hoverOnJacket2).perform();
        Thread.sleep(2000);
    }

    public void openJacket2 () throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[6]/div")).click();
        Thread.sleep(2000);
    }

    public void setColorOpenedJacket2 () throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='option-label-color-93-item-50']")).click();
        Thread.sleep(2000);
    }

    public void setSizeOpenedJacket2 (){
        driver.findElement(By.xpath("//*[@id=\"option-label-size-143-item-169\"]")).click();
    }

    public void addToCharOpenItem2 () throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
        Thread.sleep(2000);
    }

    public void item2AddToCart () {
        WebElement jacket2AddToCart = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[6]/div/div/div[4]/div/div[1]/form/button/span"));
        String addToCartButton2 = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[6]/div/div/div[4]/div/div[1]/form/button/span")).getText();
        Assert.assertTrue(jacket2AddToCart.isDisplayed());
        System.out.println("'"+addToCartButton2+"'"+" button is visible and we can click on it"+"\n");
        jacket2AddToCart.click();
    }

    public void goUpAndInTheCartToCheckout () throws InterruptedException {
        scrollDown(-900);
        Thread.sleep(2000);

        WebElement goToCart = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div"));
        String goToCartButton = goToCart.getText();
        String cartAndItems = goToCartButton.replace("\n", " ").replaceAll("\\s+", " ");
        Assert.assertTrue(goToCart.isDisplayed());
        System.out.println("'"+cartAndItems+"'"+" is visible so we can click, and is showing the number of added items"+"\n");
        goToCart.click();
        Thread.sleep(2000);

        WebElement proceedToCheckout = driver.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]"));
        Assert.assertTrue(proceedToCheckout.isDisplayed());
        System.out.println("Proceed to Checkout option is shown and we can now go and pay for our items"+"\n");
        proceedToCheckout.click();
        Thread.sleep(1000);

        scrollDown(900);
        Thread.sleep(1000);

        Select s = new Select(driver.findElement(By.name("country_id")));
        s.selectByValue("MK");
        Thread.sleep(2000);
        scrollDown(-900);
        Thread.sleep(2000);

    }

    public void userStreetAddress (String insertStreetAddress){
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/fieldset/div/div[1]/div/input")).sendKeys(insertStreetAddress);
    }

    public void userCity (String insertCity){
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[4]/div/input")).sendKeys(insertCity);
        scrollDown(800);
    }

    public void userZipCode (String insertZipCode){
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[7]/div/input")).sendKeys(insertZipCode);
    }

    public void userPhoneNumber (String insertPhoneNumber){
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form/div/div[9]/div/input")).sendKeys(insertPhoneNumber);
    }

    public void nextButton (){
        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button/span")).click();
    }

    public void placeOrderButton () throws InterruptedException {
       WebElement placeOrder = driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button/span"));
       String placeOrderMessage = placeOrder.getText();
       Assert.assertTrue(placeOrder.isDisplayed());
       Thread.sleep(3000);
       placeOrder.click();
       System.out.println("You have clicked on "+placeOrderMessage+" button."+"\n");

    }

    public void scrollDown(int pixel) {
        ((JavascriptExecutor) driver).executeScript("scroll(0," + pixel + ")");
    }
}

