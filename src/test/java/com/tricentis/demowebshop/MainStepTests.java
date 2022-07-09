package com.tricentis.demowebshop;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.ValueSource;


public class MainStepTests {
    private final TestBase steps = new TestBase();

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "http://demowebshop.tricentis.com";
        Configuration.browserSize = ("1920x1080");
    }

    @Test
    @Feature("Главная страница")
    @Story("Логотип страницы")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка логотипа на главной странице")
    @Description("Тест заходит на главную страницу сайта, проверяет видимость логотипа и его альт текст")
    public void mainPageLogoTest() {
        steps.openMainPage();
        steps.verifySiteLogoVisible();
        steps.verifyLogoAltText();
    }


    @ParameterizedTest(name = "Проверка перехода в каталог через меню")
    @ValueSource(strings = {"BOOKS", "COMPUTERS", "ELECTRONICS", "APPAREL & SHOES", "DIGITAL DOWNLOADS", "JEWELRY", "GIFT CARDS"})
    @Severity(SeverityLevel.NORMAL)
    @Description("Тест заходит на главную страницу сайта, через меню переходит в каталог и проверяет заголовок")
    public void openCatalogTest(String catalogName) {
        steps.openMainPage();
        steps.clickOnBooksCatalogInMenu(catalogName);
        steps.verifyCatalogPageTitle(catalogName);
    }
}
