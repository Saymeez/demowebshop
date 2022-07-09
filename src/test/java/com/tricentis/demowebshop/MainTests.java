package com.tricentis.demowebshop;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainTests {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "http://demowebshop.tricentis.com";
        Configuration.browserSize = ("1920x1080");
    }

    @Test
    void openMainPageTest() {
        step("Открываем главную страницу сайта", () -> {
            open("http://demowebshop.tricentis.com");
        });
        step("Проверка видимости логотипа сайта на главной странице", () -> {
            $(".header-logo").shouldBe(visible);
        });

        step("Проверка альт текста логотипа", () -> {
            $(".header-logo a img").shouldHave(attribute("alt", "Tricentis Demo Web Shop"));
        });
    }

    @Test
    void clickFirstCatalog() {
        open("http://demowebshop.tricentis.com");
        SelenideElement firstCatalogLink = $$(".top-menu").first().$("a");
        firstCatalogLink.click();
        $("h1").shouldHave(exactText("Books"));
    }
}

