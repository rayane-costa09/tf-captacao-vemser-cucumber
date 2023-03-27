package vemser.captacao.tests.utils;

import net.datafaker.Faker;

import java.util.Locale;
public class DataFactory {

    /* Instância do faker*/
    private static final Faker faker = new Faker(new Locale("pt-BR"));

    /* Retorna nome e sobrenome */
    public static String getFullName() {
        return faker.name().fullName().replace(".", "");
    }

    /* Retorna apenas o primeiro nome */
    public static String getSimpleName() {
        return faker.name().firstName();
    }

    /* Retorna um RG válido */
    public static String getRG() {
        return faker.numerify("#############");
    }

    /* Retorna um RG apenas com letras */
    public static String getRGWithLetters() {
        return faker.letterify("?????????????");
    }

    /* Retorna um RG com letras e números */
    public static String getRGWithLettersAndNumbers() {
        return faker.bothify("##?##??##?#?#");
    }

    /* Retorna um email */
    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getEmailOnlyNumbers() {
        return faker.numerify("##########");
    }

    /* Retorna um CPF válido */
    public static String getCPF() {
        return faker.cpf().valid(false);
    }

    /* Retorna um CPF com letras */
    public static String getCPFWithLetters() {
        return faker.letterify("???????????");
    }

    /* Retorna um CPF com letras e números */
    public static String getCPFWithLettersAndNumbers() {
        return faker.bothify("#?##??#?#?#");
    }

    /* Retorna um telefone válido */
    public static String getPhone() {
        return faker.phoneNumber().phoneNumberNational().replaceAll("[()-]", "").replace(" ", "");
    }

    /* Retorna um telegone com letras*/
    public static String getPhoneWithLetters() {
        return faker.letterify("???????????");
    }

    /* Retorn um telefone com letras e números */
    public static String getPhoneWithLettersAndNumbers() {
        return faker.bothify("#?##??#?#?#");
    }

    /* Retorna uma cidade */
    public static String getCity() {
        return faker.address().city().replaceAll("[-.,']", "");
    }

    /* Rotorna a abreviação do nome do estado */
    public static String getState() {
        return faker.address().stateAbbr();
    }

    /* Retorna uma data com idade entre 16 e 65 anos no formato "mês/dia/ano */
    public static String getBirthday() {
        if(Utils.getUserOsLanguage().equalsIgnoreCase("pt-br") || Utils.getUserOsLanguage().equalsIgnoreCase("pt")) {
            return faker.date().birthday(16, 65, "dd/MM/yyyy");
        }
        return faker.date().birthday(16, 65, "MM/dd/yyyy");
    }

    public static String getBirthdayLessThan16() {
        if(Utils.getUserOsLanguage().equalsIgnoreCase("pt-br") || Utils.getUserOsLanguage().equalsIgnoreCase("pt")) {
            return faker.date().birthday(0, 15, "dd/MM/yyyy");
        }
        return faker.date().birthday(0, 15, "MM/dd/yyyy");
    }

    /* Retorna o nome de uma instituição de ensino */
    public static String getCollege() {
        return faker.educator().campus().replaceAll("[-.,']", "");
    }

    /* Rotorna o nome de um curso */
    public static String getCourse() {
        return faker.educator().course().replaceAll("[-.,']", "");
    }

    /*
    * Retorna um texto contendo uma certa quantidade
    * de frases conforme o parâmetro passado
    * */
    public static String getText(int sentences) {
        return faker.lorem().paragraph(sentences);
    }

    public static String getLink() {
        return "https://" + faker.internet().url().replace(" ", "-");
    }

    public static String getFilePath(String fileType) {

        fileType = fileType.toLowerCase();

        return switch (fileType) {
            case "pdf" -> Utils.getUserPath() + "/attachment/curriculum.pdf";
            case "image" -> Utils.getUserPath() + "/attachment/pc_specs.png";
            default -> Utils.getUserPath() + "/attachment/other.txt";
        };
    }
}
