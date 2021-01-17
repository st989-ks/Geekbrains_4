package com.pipe.geekbrains_4_1;

public class Counters {

    private StringBuilder viewInText = new StringBuilder();
    private StringBuffer counter = new StringBuffer("");
    private final StringBuffer[] numberViewWindow = new StringBuffer[5];
    private boolean equal = false;


    public void setCounter(String counter) {
        if (equal) {
            cleanNumberViewWindow();
            equal = false;
        }
        this.counter.append(counter);
    }

    public void clearCounter() {
        if (counter.length() == 0) return;
        counter.setLength(counter.length() - 1);
    }

    public void deleteAllCounter() {
        counter.delete(0, counter.length());
        cleanNumberViewWindow();
    }

    public void setSymbolCounter(String symbol) {
        if (equal) {
            cleanNumberViewWindow();
            equal = false;
        }
        String str = counter.toString();
        counter.delete(0, counter.length());
        numberViewWindow[1] = new StringBuffer(symbol);
        numberViewWindow[0] = new StringBuffer(str);
    }

    public void setEqualTo(String arithmetic) {
        if (numberViewWindow[0] == null) return;
        String str = counter.toString();
        counter.delete(0, counter.length());
        if ((arithmetic.equals("\u221a")) ||
                (arithmetic.equals("x\u00B2"))) {
            numberViewWindow[0] = new StringBuffer(str);
            numberViewWindow[1] = new StringBuffer(arithmetic);
            numberViewWindow[2] = new StringBuffer("=");
            calculationsMulti();
        } else {
            if (str.equals("")) return;
            numberViewWindow[3] = new StringBuffer(arithmetic);
            numberViewWindow[2] = new StringBuffer(str);
            calculations();
        }
        equal = true;
    }

    public String getCounter() {
        return counter.toString();
    }

    public String getNumberViewWindow() {
        viewInText.delete(0, viewInText.length());
        for (StringBuffer stringBuffer : numberViewWindow) {
            if (stringBuffer == null) {
                viewInText.append("");
            } else {
                viewInText.append(stringBuffer);
            }
            viewInText.append("\n");
        }
        return viewInText.toString();
    }

    private void cleanNumberViewWindow() {
        for (StringBuffer stringBuffer : numberViewWindow) {
            if (!(stringBuffer == null)) {
                stringBuffer.delete(0, stringBuffer.length());
            }
        }
    }

    private void calculations() {
        double x = Double.parseDouble(numberViewWindow[0].toString());
        double y = Double.parseDouble(numberViewWindow[2].toString());
        switch (numberViewWindow[1].toString()) {
            case "+":
                counter.append((x + y));
                break;
            case "-":
                counter.append((x - y));
                break;
            case "\u00D7":
                counter.append((x * y));
                break;
            case "\u00F7":
                counter.append((x / y));
                break;
            case "\u221a":
                counter.append((Math.sqrt(x)));
                break;
            case "x\u00B2":
                counter.append((x * x));
                break;
        }
        numberViewWindow[4] = new StringBuffer(counter);
    }

    private void calculationsMulti() {
        double x = Double.parseDouble(numberViewWindow[0].toString());
        switch (numberViewWindow[1].toString()) {
            case "\u221a":
                counter.append((Math.sqrt(x)));
                break;
            case "x\u00B2":
                counter.append((x * x));
                break;
        }
        numberViewWindow[3] = new StringBuffer(counter);
    }
}