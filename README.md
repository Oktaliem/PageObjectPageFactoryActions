# PageObjectPageFactoryActions
Keyword Actions for Selenium Page Object &amp; Page Factory

Features :
1. Initiate WebDriver by WebDriverManager (https://github.com/bonigarcia/webdrivermanager)
2. Selenium action wrapper for Page Object Model & Page Factory
   
   ```
   Page Object i.e. 
   private By userNameLogin = By.id("login");
   
   Selenium action i.e.
   driver.findElement(userNameLogin).click();
   
   ```
   
   ```
   Page Factory i.e. 
   @FindBy(id = "login")
   private WebElement userName;
   
   Selenium action i.e.
   userName.click();
   
   ```
   
   ```
   With Selenium action wrapper
   
   Page Object i.e.
   clickOn(userNameLogin);
   
   Page Factory i.e.
   clickOn(userName);
   
   ```

3. Self logging each keyword action
