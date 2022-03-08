package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PageFactoryYandexMarket {

    private WebDriver chromeDriver;

    @FindBy(how = How.XPATH, using = "//a[@data-id='market']")
    protected WebElement yandexMarketBtn;

    @FindBy(how = How.XPATH, using = "//button[@id='catalogPopupButton']")
    protected WebElement catalogBtn;

    @FindBy(how = How.XPATH, using = "//a/span[contains(text(), 'Компьютеры')]")
    protected WebElement computersBtn;

    @FindBy(how = How.XPATH, using = "//ul[@data-autotest-id='subItems']//a[contains(text(), 'Ноутбуки')]")
    protected WebElement notebooksBtn;

    @FindBy(how = How.XPATH, using = "//input[@type='text' and @name='Цена от']")
    protected WebElement priceMin;

    @FindBy(how = How.XPATH, using = "//input[@type='text' and @name='Цена до']")
    protected WebElement priceMax;

    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'HP')]/ancestor::label")
    protected WebElement checkBoxHP;

    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Lenovo')]/ancestor::label")
    protected WebElement checkBoxLenovo;

    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Показывать по 48')]/../..")
    protected WebElement dropBoxChooseAmount;

    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Показывать по 12')]")
    protected WebElement dropBoxChoose12;

    @FindBy(how = How.XPATH, using = "//input[@type='text' and @id='header-search']")
    protected WebElement textFieldFindText;

    @FindBy(how = How.XPATH, using = "//span[contains(text(), 'Найти')]/ancestor::button")
    protected WebElement btnFieldFind;

    public WebElement getTextFieldFindText() {
        return textFieldFindText;
    }

    public WebElement getBtnFieldFind() {
        return btnFieldFind;
    }

    public WebElement getListOfNoteBooks() {
        return listOfNoteBooks;
    }

    @FindBy(how = How.XPATH, using = "//article")
    protected WebElement listOfNoteBooks;


    public List<WebElement> getSearchItems() {
        return searchItems;
    }

    private List<WebElement> searchItems = new ArrayList<>();
    private List<Map<String, Object>> collectResult = new ArrayList<>();

    public List<Map<String, Object>> getCollectResult() {
        this.searchItems = chromeDriver.findElements(By.xpath("//article"));
        for (WebElement result : searchItems) {
            collectResult.add(Map.of(
                    "WEB_ELEMENT", result,
                    "TITLE", result.findElement(By.xpath(".//h3[@data-zone-name='title']/a")).getText()
            ));

        }
        return collectResult;
    }

    public WebElement getDropBoxChooseAmount() {
        return dropBoxChooseAmount;
    }

    public WebElement getDropBoxChoose12() {
        return dropBoxChoose12;
    }

    public PageFactoryYandexMarket(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
    }

    public WebElement getYandexMarketBtn() {
        return yandexMarketBtn;
    }

    public WebElement getCatalogBtn() {
        return catalogBtn;
    }

    public WebElement getComputersBtn() {
        return computersBtn;
    }

    public WebElement getNotebooksBtn() {
        return notebooksBtn;
    }

    public void clickYandexMarket() {
        yandexMarketBtn.click();
    }

    public void clickCatalog() {
        catalogBtn.click();
    }

    public void clickComputerBtn() {
        computersBtn.click();
    }

    public void clickNoteBookBtn() {
        notebooksBtn.click();
    }

    public WebElement getCheckBoxHP() {
        return checkBoxHP;
    }

    public WebElement getCheckBoxLenovo() {
        return checkBoxLenovo;
    }

    public void showCurrentPageTitle() {
        System.out.println(chromeDriver.getTitle());

    }

    public void switchToWindow(String titleName) {
        for(String windowHandle : chromeDriver.getWindowHandles()) {
            if(chromeDriver.switchTo().window(windowHandle)
                    .getTitle().contains(titleName)) {
                break;
            }
        }
    }

    public void fillPrice(String min, String max) throws InterruptedException {
        priceMin.clear();
        priceMin.sendKeys(min);

        priceMax.clear();
        priceMax.sendKeys(max);
        Thread.sleep(5000);
    }

    public void chooseCheckBox() throws InterruptedException {
        checkBoxHP.click();
        checkBoxLenovo.click();
        Thread.sleep(5000);
    }

    public void choose12() throws InterruptedException {
        dropBoxChooseAmount.click();
        dropBoxChoose12.click();
        Thread.sleep(5000);
    }


    public void findItemWithParameter(String item) throws InterruptedException {
        textFieldFindText.sendKeys(item);
        btnFieldFind.click();
        Thread.sleep(5000);

    }














}
