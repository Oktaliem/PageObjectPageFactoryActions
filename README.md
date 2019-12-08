# PageObjectPageFactoryActions
Keyword Actions for Selenium Page Object &amp; Page Factory

Features :
1. Initiate WebDriver by WebDriverManager (https://github.com/bonigarcia/webdrivermanager)
2. Selenium keyword action for Page Object Model & Page Factory
   
   ```
   Page Object i.e. 
   
   private By userNameLogin = By.id("login");
   ```
   
   ```
   Page Factory i.e. 
   
   @FindBy(id = "login")
   private WebElement userName;
   ```

3. Self logging each keyword action
