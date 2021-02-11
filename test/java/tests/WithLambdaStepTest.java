package tests;

import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class WithLambdaStepTest {

    private static final String BASE_URL = "https://github.com";
    private static final String ISSUES = "Issues";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE_NUMBER = 68;

    @Test
    @Owner("tokarevns")
    @Tags({@Tag("web"), @Tag("lambda")})
    @Link(name = "Base URL", value = BASE_URL)
    @DisplayName("Поиск Issue по номеру в репзитории")
    public void testSearchIssueNumber () {
        parameter("Repository", REPOSITORY);
        parameter("Issue Number", ISSUE_NUMBER);

        step("Открытие главной страницы", () -> {
                    open(BASE_URL);
                });
        step("Поиск репозитория " + REPOSITORY, () -> {
                    $(By.name("q")).val(REPOSITORY).pressEnter();
                });
        step("Переход в репозиторий " + REPOSITORY, () -> {
                    $(By.linkText(REPOSITORY)).click();
                });
        step("Переход в раздел " + ISSUES, () -> {
                    $(withText(ISSUES)).click();
                });
        step("Проверка наличия " + ISSUES + " с номером " + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).shouldBe(visible);
        });
    }
}
