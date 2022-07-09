package com.tricentis.demowebshop;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    @Step("Открываем главную страницу сайта")
    public void openMainPage() {
        open("http://demowebshop.tricentis.com");
    }

    @Step("Проверка видимости логотипа сайта на главной странице")
    public void verifySiteLogoVisible() {
        $(".header-logo").shouldBe(visible);
    }

    @Step("Проверка альт текста логотипа")
    public void verifyLogoAltText() {
        $(".header-logo a img").shouldHave(attribute("alt", "Tricentis Demo Web Shop"));
    }

    @Step("Открыть каталог {catalogName} из меню в шапке")
    public void clickOnBooksCatalogInMenu(String catalogName) {
        $(By.linkText(catalogName)).click();
    }

    @Step("Проверка заголовка страницы каталога {catalogName}")
    public void verifyCatalogPageTitle(String catalogName) {
        $("h1").shouldHave(exactText(catalogName));
    }
}
