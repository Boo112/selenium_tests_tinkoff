package testsHelper;

public class InvalidData {
    public static final String INVALID_FIO_ENG = "klklrewrew";
    public static final String INVALID_FIO_ONLY_NAME = "авыавы";
    public static final String INVALID_DATE_BIRTH = "11.43.4432";
    public static final String INVALID_EMAIL = "gfdds@dasd";
    public static final String INVALID_TEL1 = "+7(111) 111-11-11";
    public static final String INVALID_TEL2 = "+7(111) 111";

    static String maxLimitName() {
        StringBuilder letters = new StringBuilder();
        for (int i = 0; i < 150; i++) {
            letters = letters.append("a");
        }
        return letters.toString();
    }
}
