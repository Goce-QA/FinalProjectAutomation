package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseClass;

public class PurchaseTest extends BaseClass {
    String directAddingToChar = "You need to choose options for your item.";
    String successfullAddToChar = "You added Montana Wind Jacket to your shopping cart.";
    String successfullyAddToChar2 = "You added Taurus Elements Shell to your shopping cart.";
    String messageRequiredFields = "This is a required field.";


    //Item number 1

    @Test
    public void directAddToChar() throws InterruptedException {
        homePage.menuNavigation();
        homePage.setFilterForFirstItem();
        homePage.hoverOverJacket1();
        homePage.item1AddToCart();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div")));
        String messageDirectAddToChar = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
        Assert.assertEquals(messageDirectAddToChar, directAddingToChar);
        System.out.println("Message displayed wen directly adding item to char "+"'"+messageDirectAddToChar+"'"+" "+"should be the same as the expected message "+"'"+directAddingToChar+"'");
    }

    @Test
    public void addToCharSizeSelection() throws InterruptedException {
        homePage.menuNavigation();
        homePage.setFilterForFirstItem();
        homePage.item1Size();
        homePage.item1AddToCart();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div")));
        String messageDirectAddToChar = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
        Assert.assertEquals(messageDirectAddToChar, directAddingToChar);
        System.out.println("Message displayed wen directly adding item to char "+"'"+messageDirectAddToChar+"'"+" "+"should be the same as the expected message "+"'"+directAddingToChar+"'");
    }

    @Test
    public void addToCharColorSelection() throws InterruptedException {
        homePage.menuNavigation();
        homePage.setFilterForFirstItem();
        homePage.item1Color();
        homePage.item1AddToCart();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div")));
        String messageDirectAddToChar = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
        Assert.assertEquals(messageDirectAddToChar, directAddingToChar);
        System.out.println("Message displayed wen directly adding item to char "+"'"+messageDirectAddToChar+"'"+" "+"should be the same as the expected message "+"'"+directAddingToChar+"'");
    }

    @Test
    public void addToCharWithAllSelection() throws InterruptedException {
        homePage.menuNavigation();
        homePage.setFilterForFirstItem();
        homePage.item1Size();
        homePage.item1Color();
        homePage.item1AddToCart();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/main/div[2]/div[2]/div/div/div")));
        String messageSuccesfullAdd = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[2]/div/div/div")).getText();
        Assert.assertEquals(messageSuccesfullAdd, successfullAddToChar);
        System.out.println("Message displayed wen directly adding item to char "+"'"+messageSuccesfullAdd+"'"+" "+"should be the same as the expected message "+"'"+successfullAddToChar+"'");
    }

    @Test
    public void addToCharOpeningTheItemNoSelection() throws InterruptedException {
        homePage.menuNavigation();
        homePage.setFilterForFirstItem();
        homePage.clickOnJacket1();
        homePage.addToCharOpenedItem();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[1]/div[2]")));
        String message1DirectAddToChar = driver.findElement(By.xpath("//*[@id=\"super_attribute[143]-error\"]")).getText();
        String message2DirectAddToChar = driver.findElement(By.xpath("//*[@id=\"super_attribute[93]-error\"]")).getText();
        boolean isMessage1Equal = message1DirectAddToChar.equals(messageRequiredFields);
        boolean isMessage2Equal = message2DirectAddToChar.equals(messageRequiredFields);
        if (isMessage1Equal && isMessage2Equal) {
            System.out.println("Messages displayed when opening item and adding to char without selecting Size or Color " + "'" + message1DirectAddToChar + "'" + " and " + "'" + message2DirectAddToChar + "'" + " " + "should be the same as the expected message " + "'" + directAddingToChar + "'");
        } else {
            System.out.println("Something is not right");
        }
    }

    @Test
    public void addToCharOpeningTheItemColorSelection() throws InterruptedException {
        homePage.menuNavigation();
        homePage.setFilterForFirstItem();
        homePage.clickOnJacket1();
        homePage.selectColorOpenedJacket1();
        homePage.addToCharOpenedItem();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[1]/div[2]")));

        String messageColorNotSelected = driver.findElement(By.xpath("//*[@id=\"super_attribute[143]-error\"]")).getText();
        Assert.assertEquals(messageColorNotSelected,messageRequiredFields);
        System.out.println("You must select a Size");
    }

    @Test
    public void addToCharOpeningTheItemSizeSelection() throws InterruptedException {
        homePage.menuNavigation();
        homePage.setFilterForFirstItem();
        homePage.clickOnJacket1();
        homePage.selectSizeOpenedJacket1();
        homePage.addToCharOpenedItem();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[2]/div[2]")));
        String messageSizeNotSelected = driver.findElement(By.xpath("//*[@id=\"super_attribute[93]-error\"]")).getText();
        Assert.assertEquals(messageSizeNotSelected,messageRequiredFields);
        System.out.println("You must select a Color");
    }

    @Test
    public void addToCharOpeningTheItemAllSelection() throws InterruptedException {
        homePage.menuNavigation();
        homePage.setFilterForFirstItem();
        homePage.clickOnJacket1();
        homePage.selectSizeOpenedJacket1();
        homePage.selectColorOpenedJacket1();
        homePage.addToCharOpenedItem();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div")));
        String messageAddedToCharOpenedJacket = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div")).getText();
        Assert.assertEquals(messageAddedToCharOpenedJacket,successfullAddToChar);
        System.out.println("Message for the opened Jacket when added in Char "+"'"+messageAddedToCharOpenedJacket+" should be the same with "+"'"+successfullAddToChar+"'");
    }

    //Item number two

    @Test
    public void directAddToCharItem2() throws InterruptedException {
        homePage.menuNavigation();
        homePage.setFilterForSecondItem();
        homePage.hoverOnJacket2();
        homePage.item2AddToCart();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div")));
        String messageDirectAddToChar = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
        Assert.assertEquals(messageDirectAddToChar, directAddingToChar);
        System.out.println("Message displayed wen directly adding item to char "+"'"+messageDirectAddToChar+"'"+" "+"should be the same as the expected message "+"'"+directAddingToChar+"'");
    }

    @Test
    public void addToCharSizeSelectionItem2() throws InterruptedException {
        homePage.menuNavigation();
        homePage.setFilterForSecondItem();
        homePage.hoverOnJacket2();
        homePage.item2Size();
        homePage.item2AddToCart();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div")));
        String messageDirectAddToChar = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
        Assert.assertEquals(messageDirectAddToChar, directAddingToChar);
        System.out.println("Message displayed wen directly adding item to char "+"'"+messageDirectAddToChar+"'"+" "+"should be the same as the expected message "+"'"+directAddingToChar+"'");
    }

    @Test
    public void addToCharColorSelectionItem2() throws InterruptedException {
        homePage.menuNavigation();
        homePage.setFilterForSecondItem();
        homePage.item2Color();
        homePage.item2AddToCart();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div")));
        String messageDirectAddToChar = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
        Assert.assertEquals(messageDirectAddToChar, directAddingToChar);
        System.out.println("Message displayed wen directly adding item to char "+"'"+messageDirectAddToChar+"'"+" "+"should be the same as the expected message "+"'"+directAddingToChar+"'");
    }

    @Test
    public void addToCharWithAllSelectionItem2() throws InterruptedException {
        homePage.menuNavigation();
        homePage.setFilterForSecondItem();
        homePage.item2Size();
        homePage.item2Color();
        homePage.item2AddToCart();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/main/div[2]/div[2]/div/div/div")));
        String messageSuccesfullAdd2 = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText();
        Assert.assertEquals(messageSuccesfullAdd2, successfullyAddToChar2);
        System.out.println("Message displayed wen directly adding item to char "+"'"+messageSuccesfullAdd2+"'"+" "+"should be the same as the expected message "+"'"+successfullyAddToChar2+"'");
    }

    @Test
    public void addToCharOpeningTheItemNoSelectionItem2() throws InterruptedException {
        homePage.menuNavigation();
        homePage.setFilterForSecondItem();
        homePage.openJacket2();
        homePage.addToCharOpenItem2();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[1]/div[2]")));
        String message1DirectAddToChar = driver.findElement(By.xpath("//*[@id=\"super_attribute[143]-error\"]")).getText();
        String message2DirectAddToChar = driver.findElement(By.xpath("//*[@id=\"super_attribute[93]-error\"]")).getText();
        boolean isMessage1Equal = message1DirectAddToChar.equals(messageRequiredFields);
        boolean isMessage2Equal = message2DirectAddToChar.equals(messageRequiredFields);
        if (isMessage1Equal && isMessage2Equal) {
            System.out.println("Messages displayed when opening item and adding to char without selecting Size or Color " + "'" + message1DirectAddToChar + "'" + " and " + "'" + message2DirectAddToChar + "'" + " " + "should be the same as the expected message " + "'" + directAddingToChar + "'");
        } else {
            System.out.println("Something is not right");
        }
    }

    @Test
    public void addToCharOpeningTheItemColorSelectionItem2() throws InterruptedException {
        homePage.menuNavigation();
        homePage.setFilterForSecondItem();
        homePage.openJacket2();
        homePage.setColorOpenedJacket2();
        homePage.addToCharOpenedItem();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"super_attribute[143]-error\"]")));

        String messageColorNotSelected = driver.findElement(By.xpath("//*[@id=\"super_attribute[143]-error\"]")).getText();
        Assert.assertEquals(messageColorNotSelected,messageRequiredFields);
        System.out.println("You must select a Size");
    }

    @Test
    public void addToCharOpeningTheItemSizeSelectionItem2() throws InterruptedException {
        homePage.menuNavigation();
        homePage.setFilterForSecondItem();
        homePage.openJacket2();
        homePage.setSizeOpenedJacket2();
        homePage.addToCharOpenedItem();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[2]/div[2]")));

        String messageSizeNotSelected = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[2]/div[2]")).getText();
        Assert.assertEquals(messageSizeNotSelected,messageRequiredFields);
        System.out.println("You must select a Color");
    }

    @Test
    public void addToCharOpeningTheItemAllSelectionItem2() throws InterruptedException {

        homePage.menuNavigation();
        homePage.setFilterForSecondItem();
        homePage.openJacket2();
        homePage.setSizeOpenedJacket2();
        homePage.setColorOpenedJacket2();
        homePage.addToCharOpenedItem();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div")));

        String messageAddedToCharOpenedJacket = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div")).getText();
        Assert.assertEquals(messageAddedToCharOpenedJacket,successfullyAddToChar2);
        System.out.println("Message for the opened Jacket when added in Char "+"'"+messageAddedToCharOpenedJacket+" should be the same with "+"'"+successfullyAddToChar2+"'");
    }

}


