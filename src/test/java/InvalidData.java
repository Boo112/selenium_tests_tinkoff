class InvalidData {
    static final String INVALID_FIO_ENG = "klklrewrew";
    static final String INVALID_FIO_ONLY_NAME = "авыавы";
    static final String INVALID_DATE_BIRTH = "11.43.4432";
    static final String INVALID_EMAIL = "gfdds@dasd";
    static final String INVALID_TEL1 = "+7(111) 111-11-11";
    static final String INVALID_TEL2 = "+7(111) 111";

    static String maxLimitName() {
        StringBuilder letters = new StringBuilder();
        for (int i = 0; i < 150; i++) {
            letters = letters.append("a");
        }
        return letters.toString();
    }
}
