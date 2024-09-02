package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
    public static WebDriver driver;
    public Logger logger;
    public Properties p; 
    
    @BeforeClass(groups={"Sanity","Regression","Datadriven","Master"})
    @Parameters({"os","browser"})
    public void setup(String os, String br) throws IOException, URISyntaxException {
        
        // Loading config.properties file
        FileReader file = new FileReader("./src//test//resources//config.properties");
        p = new Properties();
        p.load(file);
        
        // Initialize logger
        logger = LogManager.getLogger(this.getClass());
        
        // Remote execution environment setup
        if(p.getProperty("execution_env").equalsIgnoreCase("remote")){
            
            DesiredCapabilities cap = new DesiredCapabilities();
            
            // Set platform based on the OS parameter
            if (os.equalsIgnoreCase("windows")) {
                cap.setPlatform(Platform.WIN10);
            } else if (os.equalsIgnoreCase("mac")) {
                cap.setPlatform(Platform.MAC);    
            }
            else if (os.equalsIgnoreCase("linux")) {
                cap.setPlatform(Platform.LINUX);
                
            }
            else {
                System.out.println("No matching OS Found.......");
                return;
            }
            
            // Set browser based on the browser parameter
            switch(br.toLowerCase()) {
                case "chrome": cap.setBrowserName("chrome"); break;
                case "edge": cap.setBrowserName("MicrosoftEdge"); break;
                default: 
                    System.out.println("No Matching Browser...."); 
                    return;
            }
            
            // Use URI.toURL() to avoid deprecated URL constructor
            URI uri = new URI("http://localhost:4444/wd/hub");
            URL url = uri.toURL();
            
            driver = new RemoteWebDriver(url, cap); 
            
        }
        
        // Local execution environment setup
        if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
            switch(br.toLowerCase()) {
                case "chrome": driver = new ChromeDriver(); break;
                case "edge": driver = new EdgeDriver(); break;
                case "firefox": driver = new FirefoxDriver(); break;
                default: 
                    System.out.println("Invalid Browser name..."); 
                    return;
            }
        }
        
        // Common WebDriver settings
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("appUrl"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public String randomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String randomnum() {
        return RandomStringUtils.randomNumeric(5);
    }

    public String randomAlphanum() {
        return RandomStringUtils.randomAlphanumeric(5);
    }

    public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);
        
        sourceFile.renameTo(targetFile);
        return targetFilePath;
    }
}
