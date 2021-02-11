package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitPage {

    private static final String BASE_URL = "https://github.com";
    @Step("Открытие главной страницы")
    public GitPage openBaseURL() {
        open(BASE_URL);
        return this;
    }

    @Step("Поиск репозитория по названию {repositoryName}")
    public GitPage searchRepository(String repositoryName) {
        $(By.name("q")).val(repositoryName).pressEnter();
        return this;
    }

    @Step("Переход в репозиторий {repositoryName}")
    public GitPage moveToRepository(String repositoryName) {
        $(By.linkText(repositoryName)).click();
        return this;
    }
    @Step("Переход в раздел {issue}")
    public GitPage moveToIssue (String issue) {
        $(withText(issue)).click();
        return this;
    }

    @Step("Проверка существования issue c номером {number}")
    public GitPage checkIssueWithNumber(int number) {
        $(withText("#" + number)).shouldBe(visible);
        return this;
    }
}