class TextAnalyzeByFilter {

    public static void main(String[] args) {
        new TextAnalyzeByFilter().test();
    }

    void test() {

        String[] bad_words = {"bad", "very bad words"};

        SpamAnalyzer exampleSpam = new SpamAnalyzer(bad_words);
        NegativeTextAnalyzer exampleNegative = new NegativeTextAnalyzer();
        TooLongTextAnalyzer exampleTooLong = new TooLongTextAnalyzer(20);
        TextAnalyzer[] arrayToAnalyze = {exampleSpam, exampleNegative, exampleTooLong};

        // Check some Text with checkLabels
        System.out.println(checkLabels(arrayToAnalyze, "Good text for test."));
        System.out.println(checkLabels(arrayToAnalyze, "Bad text for test, because there is very bad words."));
        System.out.println(checkLabels(arrayToAnalyze, "Bad text for test, because there is very =("));
        System.out.println(checkLabels(arrayToAnalyze, "Bad text for test, because there is longer that twenty characters."));
    }


    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }

    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (int i = 0; i < analyzers.length; i++)
            if (analyzers[i].processText(text) != Label.OK)
                return analyzers[i].processText(text);
        return Label.OK;
    }

    interface TextAnalyzer {
        Label processText(String text);
    }

    abstract class KeywordAnalyzer implements TextAnalyzer {

        protected abstract String[] getKeywords();

        protected abstract Label getLabel();

        @Override
        public Label processText(String text) {
            String[] keywords = getKeywords();

            // переменная curKeyword получает текущее значение из массива
            for (String curKeyword : keywords) {
                if (text.contains(curKeyword)) {
                    return getLabel();
                }
            }
            return Label.OK;
        }
    }

    class SpamAnalyzer extends KeywordAnalyzer {
        private String[] keywords;

        public SpamAnalyzer(String[] newKeywords) {
            this.keywords = newKeywords;
        }

        @Override
        protected String[] getKeywords() {
            return keywords;
        }

        @Override
        protected Label getLabel() {
            return Label.SPAM;
        }
    }

    class NegativeTextAnalyzer extends KeywordAnalyzer {
        private final String[] KEYWORDS = {":(", "=(", ":|"};

        @Override
        public String[] getKeywords() {
            return KEYWORDS;
        }

        @Override
        protected Label getLabel() {
            return Label.NEGATIVE_TEXT;
        }
    }

    class TooLongTextAnalyzer implements TextAnalyzer {
        private int maxLength;

        public TooLongTextAnalyzer(int newMaxLength) {
            this.maxLength = newMaxLength;
        }

        public Label getLabel() {
            return Label.TOO_LONG;
        }

        @Override
        public Label processText(String text) {
            int curLen = text.length();

            if (curLen > maxLength)
                return getLabel();
            return Label.OK;
        }
    }
}
