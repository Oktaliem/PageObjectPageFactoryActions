# PageObjectPageFactoryActions
Keyword for Selenium Page Object &amp; Page Factory

Features :
1. Initiate WebDriver by WebDriverManager (https://github.com/bonigarcia/webdrivermanager)
   ```
   WebDriverManager.chromedriver().setup(); 
   WebDriverManager.firefoxdriver().setup(); 
   WebDriverManager.operadriver().setup();
   WebDriverManager.phantomjs().setup();
   WebDriverManager.edgedriver().setup();
   WebDriverManager.iedriver().setup();
   ```
   
2. Selenium keyword for Page Object Model & Page Factory
   
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
   With Selenium keyword library
   
   Selenium action i.e.
   clickOn(userNameLogin);
   or
   clickOn(userName);
   
   ```

3. Self logging each keyword action
   ```
   2019-12-08 19:14:34,388 [main] INFO  Library Test  - Landing to Login Page: http://localhost/web/login/
   2019-12-08 19:14:34,798 [main] INFO  Library Test  - User inputs field with element: [[ChromeDriver: chrome on MAC     
   (dfff19225506368e5d5690944841ff23)] -> id: login] and value user@example.com
   2019-12-08 19:14:34,944 [main] INFO  Library Test  - User inputs field with element: [[ChromeDriver: chrome on MAC   
   (dfff19225506368e5d5690944841ff23)] -> id: password] and value bitnami
   2019-12-08 19:14:35,840 [main] INFO  Library Test  - User clicks On Element: [[ChromeDriver: chrome on MAC   \ . 
   (dfff19225506368e5d5690944841ff23)] -> class name: btn-primary]
   ```
