package utils;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.Random;

public class DataProviders {

    private String generateRandomEmail(String baseEmail) {
        Random random = new Random();
        int randomNumber = random.nextInt(1000); // Generate a random number between 0 and 999
        String[] emailParts = baseEmail.split("@");
        return emailParts[0] + randomNumber + "@" + emailParts[1];
    }

    @DataProvider(name = "userData")
    public Object[][] userData(Method user) {
        String userInput = user.getName();
        switch (userInput) {
            case "noFirstName":
                return new Object[][]{{"Petkoski", generateRandomEmail("petko.petkoski@testing.com"), "Nemapassword1#", "Nemapassword1#"}};

            case "noLastName":
                return new Object[][]{{"Stanko", generateRandomEmail("stankoski.stanko@testing.com"), "Zostopasswrod1#", "Zostopasswrod1#"}};

            case "noEmailAddress":
                return new Object[][]{{"Trajko", "Trajkoski", "Kakovpassword#1", "Kakovpassword#1"}};

            case "noPassword":
                return new Object[][]{{"Toshko", "Toseski", generateRandomEmail("toshko.t@testing.com"), "Prazenpassword1#"}};

            case "noConfirmPassword":
                return new Object[][]{{"Pamela", "Jeferson", generateRandomEmail("pamjey@testing.com"), "Takovpassword1#"}};

            case "fullUserWeekPassword":
                return new Object[][]{{"Zoran", "Zoranoski", generateRandomEmail("zoki@testing.com"), "takov", "takov"}};

            case "fullUserStrongPassword":
                return new Object[][]{{"Tina", "Tinoska", "tina.t373@testing.com", "Takovpassword1#", "Takovpassword1#"}};

            case "fullUserWeekPasswordNoSpecialCharacter":
                return new Object[][]{{"Natali", "Natalcheska", generateRandomEmail("nate99@testing.com"), "takovpassword1", "takovpassword1"}};

            case "fullUserWeekPasswordNoDigit":
                return new Object[][]{{"Hristi", "Hristoski", generateRandomEmail("hristoski.h.82@testing.com"), "takovpassword#", "takovpassword#"}};

            case "fullUserPasswordNotMatch":
                return new Object[][]{{"Ace", "Ackoski", generateRandomEmail("ace.ace22@testing.com"), "takovpassword#1", "takovpassword"}};

            case "noPasswordsAtAll":
                return new Object[][]{{"Angela", "Angeleska", generateRandomEmail("angie@testing.com")}};

            case "passwordWithSpace":
                return new Object[][]{{"Stanka", "Stankoska", generateRandomEmail("stansi28@testing.com"), " takovpassword1#", " takovpassword1#"}};

            case "passwordEndsWithSpace":
                return new Object[][]{{"Dame", "Dankoski", generateRandomEmail("dame1992@testing.com"), "takovpassword1# ", "takovpassword1# "}};

            case "passwordWithSpaceInMiddle":
                return new Object[][]{{"Filip", "Filiposki", generateRandomEmail("fico26@testing.com"), "takov password1#", "takov password1#"}};

            case "fullUser":
                return new Object[][]{{"Toni", "Tomcheski", generateRandomEmail("tomi.t29@testing.com"), "takovpassword1#", "takovpassword1#", "Partizanski Odredi BB", "Skopje", "1020", "+389-79-324-998"}};

            case "fullUserAccount":
                return new Object[][]{{"Toni", "Tomcheski", generateRandomEmail("tomi.t29@testing.com"), "takovpassword1#", "takovpassword1#"}};


            default:
                throw new IllegalStateException("Unexpected value: " + userInput);
        }
    }
}
