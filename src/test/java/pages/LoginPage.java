package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {


    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (xpath = "(//a[@class='dropdown-toggle nav-link'])[2]")
    public WebElement accountMenu;

    @FindBy (partialLinkText = "Sign in")
    public WebElement signInMenu;

    @FindBy (id = "username")
    public WebElement username;

    @FindBy (id = "password")
    public WebElement password;

    @FindBy (xpath = "//button[@type='button' and @aria-label='Menu']")
    public WebElement signInButton;
}
