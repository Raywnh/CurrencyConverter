public class CurrencyCalculation {
    private static final float USD_CAD_RATE = 1.27541F;
    private static final float USD_EUR_RATE = 0.945127F;
    private static final float EUR_CAD_RATE = 1.34946F;
    private static final float SAME_CURRENCY_RATE = 1.0F;
    private static final int USD = 0;   // These final variables are meant to represent the indexes of the currencies for better workability
    private static final int CAD = 1;
    private static final int EUR = 2;
    private static float currentAmount = 0.0F;
    private static int firstOption = 0;
    private static int secondOption = 0;
    private static float convertedAmount = 0.0F;

    public static void currencyCalculation()    {
        getCurrencySelection();
        getAmount();
    }
    public static void getAmount() {
        String temp = MyPanel.textField.getText().replaceFirst("^0+(?!$)", "");
        currentAmount = Float.valueOf(temp);
    }
    public static void getCurrencySelection()   {
        firstOption = MyPanel.fromCurrencyBox.getSelectedIndex();
        secondOption = MyPanel.toCurrencyBox.getSelectedIndex();
    }
    public static String getConvertedAmount() {

        if (firstOption == USD) {
            switch(secondOption)    {
                case USD:
                    convertedAmount = currentAmount * SAME_CURRENCY_RATE;
                    break;
                case CAD:
                    convertedAmount = currentAmount * USD_CAD_RATE;
                    break;
                case EUR:
                    convertedAmount = currentAmount * USD_EUR_RATE;
                    break;
            }
        }
        else if (firstOption == CAD)    {
            switch(secondOption)    {
                case USD:
                    convertedAmount = currentAmount / USD_CAD_RATE;
                    break;
                case CAD:
                    convertedAmount = currentAmount * SAME_CURRENCY_RATE;
                    break;
                case EUR:
                    convertedAmount = currentAmount / EUR_CAD_RATE;
                    break;
            }
        }
        else  {
            switch (secondOption)   {
                case USD:
                    convertedAmount = currentAmount / USD_EUR_RATE;
                    break;
                case CAD:
                    convertedAmount = currentAmount * EUR_CAD_RATE;
                    break;
                case EUR:
                    convertedAmount = currentAmount * SAME_CURRENCY_RATE;
                    break;
            }
        }

        return String.valueOf(convertedAmount);
    }
}
