package ru.yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import pages.PageFactoryYandexMarket;

public class Tests extends BaseTest {

    @Test
    public void findFirstItemAndCheckIt() throws InterruptedException {
        chromeDriver.get("https://www.yandex.com/");
        PageFactoryYandexMarket pageFactoryYandexMarket = PageFactory.initElements(chromeDriver,
                PageFactoryYandexMarket.class);

        pageFactoryYandexMarket.clickYandexMarket();
        pageFactoryYandexMarket
                .switchToWindow("Интернет-магазин Яндекс.Маркет — покупки с быстрой доставкой");

        pageFactoryYandexMarket.clickCatalog();
        pageFactoryYandexMarket.clickComputerBtn();
        pageFactoryYandexMarket.clickNoteBookBtn();

        pageFactoryYandexMarket.fillPrice("10000", "90000");
        Thread.sleep(10000);
        pageFactoryYandexMarket.chooseCheckBox();

        pageFactoryYandexMarket.choose12();

        Assertions.assertTrue(pageFactoryYandexMarket.getCollectResult().size() == 12, "Колличество не равно 12");
        //System.out.println(pageFactoryYandexMarket.getListOfNoteBooks().getSize());


        String firstName  = String.valueOf(pageFactoryYandexMarket.getCollectResult().get(0).get("TITLE"));
        System.out.println(firstName);

        pageFactoryYandexMarket.findItemWithParameter(firstName);

        Assertions.
                assertTrue(firstName.equals(String.valueOf(pageFactoryYandexMarket.
                        getCollectResult().get(0)
                        .get("TITLE"))), "Значения не равны");
    }
}
