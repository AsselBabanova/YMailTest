import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.sleep;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Тестовое задание с почтой")
public class MailTest {


    //Login part
    private SelenideElement logInButton = $("#root > div > div > header > div.SmallHeader_10gL9KctcHHvOwoPL2Nnmy > div.ActionButtons_1KQUh4y2uqGFcS5C_M9sDV > a.Button2.Button2_type_link.Button2_view_default.Button2_size_m");
    private SelenideElement emailInput = $("#passp-field-login");
    private SelenideElement identifierNextButton = $("#passp\\:sign-in");
    private SelenideElement passwordInput = $("#passp-field-passwd");
    private SelenideElement passwordNextButton = $("#passp\\:sign-in");

    private String username = "authorizationtestivanov";
    private String userPassword = "Kake2020!";
    private String siteURL = "https://mail.yandex.ru/";


    //send message
    private SelenideElement clickWriteButton = $(By.xpath("//body/div[@id='js-apps-container']/div[2]/div[7]/div[1]/div[2]/div[1]/nav[1]/div[2]/div[1]/div[1]/div[1]/a[1]"));
    private SelenideElement inputReceiverMail = $("#compose-field-1");
    private SelenideElement inputMessage = $("#cke_1_contents > div");
    private SelenideElement sendButton = $(By.xpath("//body/div[@id='js-apps-container']/div[2]/div[10]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]"));

    private String receiverMailAddress = "authorizationtestivanov@yandex.ru";
    private String message = "Hello, World!";


    // check sent message
    private SelenideElement clickSentButton = $(By.xpath("//body/div[@id='js-apps-container']/div[2]/div[7]/div[1]/div[2]/div[1]/nav[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/a[1]"));
    private SelenideElement checkMessage = $(By.xpath("//body/div[@id='js-apps-container']/div[2]/div[7]/div[1]/div[2]/div[1]/div[2]/div[1]/main[1]/div[7]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[1]/span[2]"));
    private SelenideElement returnToInbox = $(By.xpath("//body/div[@id='js-apps-container']/div[2]/div[7]/div[1]/div[2]/div[1]/nav[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]"));


    //Add signature
    private SelenideElement clickSettingsButton = $(By.xpath("//body/div[@id='js-apps-container']/div[2]/div[7]/div[1]/div[1]/div[1]/div[1]/div[3]/button[1]/span[1]"));
    private SelenideElement allSettingsButton = $(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[7]/div[1]/div[1]/div[1]/div[1]/div[3]/button[1]"));
    private SelenideElement personalInfo = $(By.xpath("//body/div[@id='js-apps-container']/div[2]/div[7]/div[1]/div[2]/div[1]/div[2]/div[1]/main[1]/div[7]/div[1]/div[1]/div[1]/a[1]"));
    private SelenideElement signatureInput = $(By.xpath("//body/div[@id='js-apps-container']/div[2]/div[7]/div[1]/div[2]/div[1]/div[2]/div[1]/main[1]/div[7]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
    private SelenideElement bindToMailCheckBox = $(By.xpath("//body/div[@id='js-apps-container']/div[2]/div[7]/div[1]/div[2]/div[1]/div[2]/div[1]/main[1]/div[7]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[1]/div[2]/label[1]/span[1]"));
    private SelenideElement addSignatureButton = $(By.xpath("//body/div[@id='js-apps-container']/div[2]/div[7]/div[1]/div[2]/div[1]/div[2]/div[1]/main[1]/div[7]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[3]/div[1]/div[3]/button[1]/span[1]/span[1]"));
    private SelenideElement backToInbox = $(By.xpath("//body/div[@id='js-apps-container']/div[2]/div[7]/div[1]/div[2]/div[1]/nav[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]"));
    private SelenideElement writeSecondLetter = $(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[10]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]"));
    private SelenideElement writeText = $(By.xpath("//body[1]/div[3]/div[2]/div[10]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]"));

    private String receiverName = "authorizationtestivanov@yandex.ru";
    private String secondMessage = "My name is Assel";
    private String userSignature = "С уважением, " + '\n' + "Иван Иванов";


    //Check signature
    private SelenideElement goBackToSent = $(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[7]/div[1]/div[2]/div[1]/nav[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/a[1]"));
    private SelenideElement checkLetter = $(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[7]/div[1]/div[2]/div[1]/div[2]/div[1]/main[1]/div[7]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[1]/span[1]/span[2]"));
    private SelenideElement checkSentLetter = $(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[7]/div[1]/div[2]/div[1]/div[2]/div[1]/main[1]/div[7]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[1]/span[1]/span[2]"));
    private SelenideElement checkSignature = $(By.xpath("/html[1]/body[1]/div[3]/div[2]/div[7]/div[1]/div[2]/div[1]/div[2]/div[1]/main[1]/div[7]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/article[1]"));

    private String userSignatureText = "С уважением,";

    @Test
    @Order(1)
    @DisplayName("Авторизация пользователя")
    public void userAuthorization(){

        //Авторизация на почту

        open(siteURL);

        logInButton.shouldBe(visible, Duration.ofSeconds(1)).click();
        sleep(2000);
        emailInput.shouldBe(visible, Duration.ofSeconds(1)).setValue(username);
        sleep(2000);
        identifierNextButton.shouldBe(visible, Duration.ofSeconds(1)).click();
        sleep(2000);
        passwordInput.shouldBe(visible, Duration.ofSeconds(1)).setValue(userPassword);
        sleep(2000);
        passwordNextButton.shouldBe(visible, Duration.ofSeconds(1)).click();
        sleep(4000);

    }

    @Test
    @Order(2)
    @DisplayName("Отправка письма")
    public void sendMessage(){

        //Отправка письма

        clickWriteButton.shouldBe(visible, Duration.ofSeconds(1)).click();
        sleep(2000);
        inputReceiverMail.shouldBe(visible, Duration.ofSeconds(1)).setValue(receiverMailAddress);
        sleep(2000);
        inputMessage.shouldBe(visible, Duration.ofSeconds(1)).setValue(message);
        sleep(2000);
        sendButton.shouldBe(visible, Duration.ofSeconds(1)).click();
        sleep(2000);

    }

    @Test
    @Order(3)
    @DisplayName("Проверить отправленное сообщение")
    public void checkSentMessage(){

        //Проверка отправленного письма в "Отправленных"

        clickSentButton.shouldBe(visible, Duration.ofSeconds(1)).click();
        sleep(2000);
        checkMessage.shouldHave(text("Hello, world!"), Duration.ofSeconds(1));
        sleep(4000);
        returnToInbox.shouldBe(visible, Duration.ofSeconds(1)).click();
        sleep(2000);

    }

    @Test
    @Order(4)
    @DisplayName("Добавить подпись")
    public void addSignature(){

        //Добавление подписи

        clickSettingsButton.shouldBe(visible, Duration.ofSeconds(4)).click();
        sleep(2000);
        allSettingsButton.shouldBe(visible, Duration.ofSeconds(4)).sendKeys(Keys.ENTER);
        sleep(2000);
        personalInfo.shouldBe(visible, Duration.ofSeconds(4)).click();
        sleep(2000);
        signatureInput.shouldBe(visible, Duration.ofSeconds(4)).setValue(userSignature);
        sleep(2000);
        bindToMailCheckBox.shouldBe(visible, Duration.ofSeconds(4)).click();
        sleep(2000);
        addSignatureButton.shouldBe(visible, Duration.ofSeconds(4)).click();
        sleep(2000);
        backToInbox.shouldBe(visible, Duration.ofSeconds(4)).sendKeys(Keys.ENTER);
        sleep(2000);
        clickWriteButton.shouldBe(visible, Duration.ofSeconds(4)).click();
        sleep(2000);
        writeSecondLetter.shouldBe(visible, Duration.ofSeconds(4)).setValue(receiverName);
        sleep(2000);
        writeText.shouldBe(visible, Duration.ofSeconds(4)).sendKeys(secondMessage);
        sleep(2000);
        sendButton.shouldBe(visible, Duration.ofSeconds(4)).click();
        sleep(30000);

    }

    @Test
    @Order(5)
    @DisplayName("Проверка отправленного письма с подписью")
    public void checkSignatureTest(){

        //Проверка отправленного письма с подписью

        goBackToSent.shouldBe(visible, Duration.ofSeconds(4)).click();
        sleep(2000);
        checkLetter.shouldBe(visible, Duration.ofSeconds(4)).click();
        sleep(2000);
        checkSentLetter.shouldBe(visible, Duration.ofSeconds(4)).click();
        sleep(2000);
        checkSignature.shouldHave(text(userSignatureText));
        sleep(2000);

    }

}

