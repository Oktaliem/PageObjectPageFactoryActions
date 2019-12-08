# PageObjectPageFactoryActions
Keyword Library for Selenium Page Object &amp; Page Factory

### Features :
1. Initiate WebDriver by WebDriverManager (https://github.com/bonigarcia/webdrivermanager)
   ```
   WebDriverManager.chromedriver().setup(); 
   ```
   or initiate WebDriver by Zalenium (Docker)
   ```
   DesiredCapabilities capability = DesiredCapabilities.chrome();
   capability.setBrowserName("chrome");
   capability.setPlatform(Platform.MAC);
   capability.setCapability("name", method.getName());
   driver = new RemoteWebDriver(new URL(System.getProperty("grid_url")), capability);
   ```
   or initiate Webdriver via binary
   ```
   driver = new ChromeDriver();
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
   With Selenium keyword library both Page Object and Page Factory
   
   Selenium action i.e.
   clickOn(userNameLogin);
   or
   clickOn(userName);
   
   ```

3. Self logging each keyword action
   ```
   Starting ChromeDriver 78.0.3904.70 (edb9c9f3de0247fd912a77b7f6cae7447f6d3ad5-refs/branch-heads/3904@{#800}) on port 10314
   Only local connections are allowed.
   Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
   Dec 08, 2019 10:07:55 PM org.openqa.selenium.remote.ProtocolHandshake createSession
   INFO: Detected dialect: W3C
   2019-12-08 22:07:55,701 [main] INFO  Library Test  - Landing to Login Page: http://localhost/web/login/
   2019-12-08 22:07:55,924 [main] INFO  Library Test  - User inputs field with element: By.id: login and value   user@example.com
   2019-12-08 22:07:56,008 [main] INFO  Library Test  - User inputs field with element: By.id: password and value bitnami
   2019-12-08 22:07:56,009 [main] WARN  Library Test  - Element is not clickable, try to click with Javascript
   2019-12-08 22:07:56,805 [main] INFO  Library Test  - click on [[ChromeDriver: chrome on MAC (20875a88bc047c7f7bcf57ec125b7008)] -> class name: btn-primary] via javascript succeed
   2019-12-08 22:07:56,941 [main] INFO  Library Test  - User clicks On Element: [[ChromeDriver: chrome on MAC (20875a88bc047c7f7bcf57ec125b7008)] -> class name: full]
   2019-12-08 22:07:57,054 [main] INFO  Library Test  - User clicks On Element: [[ChromeDriver: chrome on MAC (20875a88bc047c7f7bcf57ec125b7008)] -> class name: dropdown-item]
   2019-12-08 22:07:57,054 [main] INFO  Library Test  - Select Drop down List Element by visible text : Settings

   ```
   
   ### Run The Test
   ```
   mvn clean test
   
   mvn clean test -Dbrowser="zalenium" -Dgrid_url="http://localhost:4444/wd/hub"
   
   mvn clean test . -Dbrowser="bonagarcia"
   ```
