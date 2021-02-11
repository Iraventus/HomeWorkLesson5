package tests;


import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    private static final String BASE_URL = "https://github.com";
    private static final String ISSUES = "Issues";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;

    @Test
    public void testSearchIssueNumber () {
        open(BASE_URL);
        $(By.name("q")).val(REPOSITORY).pressEnter();
        $(By.linkText(REPOSITORY)).click();
        $(withText(ISSUES)).click();
        $(withText("#" + ISSUE_NUMBER)).shouldBe(Condition.visible);
    }
}