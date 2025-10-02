package soccerway;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static soccerway.Utils.substituteRowInTemplate;

public class FootballStatsDataProcessor {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Pathways.UCL_PAGE);
        //driver.findElement(By.xpath(Pathways.XPATH_CONSENT)).click();
        Utils.sleep(1000);

        System.out.println(
                "Team Name\t#\tName\tAge\tPosition\tMinutes\tAppearance\tLineups\tSub-In\tSub-Out\tSub-Bench\tGoals\tAssists\tYellow\tSecond Yellow\tRed");

        List<WebElement> listOfTeamURLs = driver.findElements(By.xpath(Pathways.XPATH_ALL_UCL_TEAMS_URLS));
        List<String> listOfTeamURL = new ArrayList<>();
        for (int j = 0; j < 36; j++) {
            listOfTeamURL.add(listOfTeamURLs.get(j).getAttribute("href"));
        }

//        List<String> listOfTeamURL = new ArrayList<>();
//        listOfTeamURL.add("https://int.soccerway.com/teams/france/paris-saint-germain-fc/886/");
//        listOfTeamURL.add("https://int.soccerway.com/teams/italy/fc-internazionale-milano/1244/");

        for (int j = 0; j < 36; j++) {
            //for (int j = 0; j < 4; j++) {
            driver.get(listOfTeamURL.get(j));
            Utils.sleep(2000);
            driver.findElement(By.xpath(Pathways.XPATH_SQUAD)).click();
            Utils.sleep(2000);
            //driver.findElement(By.xpath(Pathways.XPATH_STATISTICS)).click();
            Utils.sleep(5000);
            int playerCount = driver.findElements(By.xpath(Pathways.XPATH_STATS_TABLE_ROW_SIZE)).size();
            //System.out.println(playerCount);
            String teamName = driver.findElement(By.xpath(Pathways.XPATH_TEAM_NAME)).getText();

            for (int i = 1; i <= playerCount; i++) {
                String shirtNumber = "";
                String name = "";
                String age = "";
                String position = "";
                String minutes = "";
                String appearance = "";
                String lineups = "";
                String subIn = "";
                String subOut = "";
                String subOnBench = "";
                String goals = "";
                String assists = "";
                String yellow = "";
                String secondYellow = "";
                String red = "";

                try {
                    shirtNumber = driver.findElement(By.xpath(substituteRowInTemplate(Pathways.XPATH_TEMPLATE_SHIRT_NUMBER, i))).getText();
                    name = driver.findElement(By.xpath(substituteRowInTemplate(Pathways.XPATH_TEMPLATE_NAME, i))).getText();
                    age = driver.findElement(By.xpath(substituteRowInTemplate(Pathways.XPATH_TEMPLATE_AGE, i))).getText();
                    //position = driver.findElement(By.xpath(substituteRowInTemplate(Pathways.XPATH_TEMPLATE_POSITION, i))).getText();
                    minutes = driver.findElement(By.xpath(substituteRowInTemplate(Pathways.XPATH_TEMPLATE_MINUTES, i))).getText();
                    appearance = driver.findElement(By.xpath(substituteRowInTemplate(Pathways.XPATH_TEMPLATE_APPEARANCE, i))).getText();
                    //lineups = driver.findElement(By.xpath(substituteRowInTemplate(Pathways.XPATH_TEMPLATE_LINEUP, i))).getText();
                    //subIn = driver.findElement(By.xpath(substituteRowInTemplate(Pathways.XPATH_TEMPLATE_SUB_IN, i))).getText();
                    //subOut = driver.findElement(By.xpath(substituteRowInTemplate(Pathways.XPATH_TEMPLATE_SUB_OUT, i))).getText();
                    //subOnBench = driver.findElement(By.xpath(substituteRowInTemplate(Pathways.XPATH_TEMPLATE_SUB_ON_BENCH, i))).getText();
                    goals = driver.findElement(By.xpath(substituteRowInTemplate(Pathways.XPATH_TEMPLATE_GOALS, i))).getText();
                    assists = driver.findElement(By.xpath(substituteRowInTemplate(Pathways.XPATH_TEMPLATE_ASSISTS, i))).getText();
                    yellow = driver.findElement(By.xpath(substituteRowInTemplate(Pathways.XPATH_TEMPLATE_YELLOW, i))).getText();
                    //secondYellow = driver.findElement(By.xpath(substituteRowInTemplate(Pathways.XPATH_TEMPLATE_SECOND_YELLOW, i))).getText();
                    red = driver.findElement(By.xpath(substituteRowInTemplate(Pathways.XPATH_TEMPLATE_RED, i))).getText();
                } catch (Exception e) {
                }
                System.out.println(
                        teamName + "\t" + shirtNumber + "\t" + name + "\t" + age + "\t" + position + "\t" + minutes + "\t" + appearance + "\t" + lineups + "\t" + subIn + "\t" + subOut + "\t" + subOnBench + "\t" + goals + "\t" + assists + "\t" + yellow + "\t" + secondYellow + "\t" + red);
            }

        }


        driver.quit();
    }
}
