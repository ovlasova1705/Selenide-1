package com.github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GithubSearch {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = true;
    }

    @DisplayName("Проверка, что на странице SoftAssertion есть примера кода Junit5")
    @Test
    void searchSelenide(){
        Selenide.open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("li.wiki-more-pages-link").shouldBe(visible);
        $("li.wiki-more-pages-link").$("button").click();
        $("div#wiki-pages-box").$$("a").findBy(text("SoftAssertions")).shouldBe(visible);
        $("div#wiki-pages-box").$$("a").findBy(text("SoftAssertions")).click();
        $$("h4").findBy(text("JUnit5")).sibling(0).$$("pre");

    }

}
