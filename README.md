<h1 align="center"><img src="https://user-images.githubusercontent.com/26521948/72658109-63a1d400-39e7-11ea-9667-c652586b4508.png" alt="Apache JMeter logo" /></h1>
<h4 align="center">SOFTWARE TESTING ENTHUSIAST</h4>
<br>

# PageObjectPageFactoryActions
Keyword Library (keyword-driven method) for Selenium Page Object &amp; Page Factory
```
“If you have WebDriver APIs in your test methods, You're Doing It Wrong.” Simon Stewart
```
```
Martin Fowler :
1. A page object wraps an HTML page, or fragment, with an application-specific API, allowing you to manipulate page elements without digging around in the HTML."
2. A page object should also provide an interface that's easy to program to and hides the underlying widgetry in the window  page."
3. The page object should encapsulate the mechanics required to find and manipulate the data in the page itself. A good rule of thumb is to imagine changing the concrete page -in which case the page object interface shouldn't change."
```

### Features :
1. Initiate WebDriver by WebDriverManager

   ```
   WebDriverManager.chromedriver().setup(); 
   driver = new ChromeDriver();
   ```
   or initiate WebDriver by Zalenium (Selenium Grid in Docker)
   ```
   DesiredCapabilities capability = DesiredCapabilities.chrome();
   capability.setBrowserName("chrome");
   capability.setCapability("name", method.getName());
   driver = new RemoteWebDriver(new URL(System.getProperty("grid_url")), capability);
   ```
   or initiate Webdriver via binary
   ```
   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver-mac");
   System.out.println(System.getProperty("user.dir") + "/drivers/chromedriver-mac");
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
   via WebDriver binary :
   $ mvn clean test -Dbrowser="chromePath" -Dsurfire.suiteXmlFiles=TestNG.xml

   via WebDriverManager :
   $ mvn clean test -Dsurfire.suiteXmlFiles=TestNG.xml

   via Zalenium :
   $ docker run --rm -ti --name zalenium -p 4444:4444 -v /var/run/docker.sock:/var/run/docker.sock -v /tmp/videos:/home/seluser/videos --privileged dosel/zalenium start
   $ mvn clean test -Dbrowser="zalenium" -Dgrid_url="http://{your_ip_address}:4444/wd/hub" -Dsurfire.suiteXmlFiles=TestNG.xml
   
   run one method (testcase) or many methods (testcases)
   $ mvn clean test -Dtest=UnitTest#TC03
   $ mvn clean test -Dtest=UnitTest#TC03+TC04+TC05
   
   run one class (testsuit) or many classes (testsuites)
   $ mvn clean test -Dtest=UnitTest
   $ mvn clean test -Dtest=UnitTest,{another_class}
   $ mvn clean test -Dtest=com.oktaliem.testsuit.**"
   ```
   
   ### References 
   https://github.com/bonigarcia/webdrivermanager
   
   https://github.com/zalando/zalenium
   
   ### Application Under Test
   https://hub.docker.com/r/bitnami/odoo/
   
   ### Zalenium Proof of Concept (Youtube)
   <a href="https://youtu.be/OSnDyoI4Zc4" target="_blank"><img src="https://user-images.githubusercontent.com/26521948/72658109-63a1d400-39e7-11ea-9667-c652586b4508.png" 
   alt="CLICK HERE" width="140" height="80" border="10" /></a>
