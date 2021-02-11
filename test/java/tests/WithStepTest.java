package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.GitPage;

public class WithStepTest {
    GitPage gitPage = new GitPage();
    private final String ISSUES = "Issues";
    private final String REPOSITORY = "eroshenkoam/allure-example";
    private final int ISSUE_NUMBER = 68;

    @Test
    @Owner("tokarevns")
    @Tags({@Tag("web"), @Tag("step")})
    @DisplayName("Поиск Issue по номеру в репзитории")
    public void testSearchIssueNumber() {
        gitPage.openBaseURL()
                .searchRepository(REPOSITORY)
                .moveToRepository(REPOSITORY)
                .moveToIssue(ISSUES)
                .checkIssueWithNumber(ISSUE_NUMBER);
    }
}
