package com.pipe.geekbrains_4_1;

import java.util.ArrayList;

public class Counters {

    private StringBuilder viewInText = new StringBuilder();
    private StringBuffer counter = new StringBuffer("");
    private final StringBuffer[] numberViewWindow = new StringBuffer[5];
    private boolean equal = false;
    private int LIMITED = 18;

    public void setCounter(String counter) {
        if (!(this.counter.length() <= LIMITED)) return;
        String DOT = ".";
        if (counter.equals(DOT) & this.counter.indexOf(DOT) >= 0) return;
        checkBooleanEqual();
        this.counter.append(counter);
    }

    public void setNumberViewWindowForSave(ArrayList<String> numberViewWindowSave) {
        for (int i = 0; i < numberViewWindow.length; i++) {
            if (numberViewWindow[i] == null) numberViewWindow[i] = new StringBuffer("");
            numberViewWindow[i] = new StringBuffer(numberViewWindowSave.get(i));
        }
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
        checkBooleanEqual();
        String str = counter.toString();
        counter.delete(0, counter.length());
        numberViewWindow[1] = new StringBuffer(symbol);
        numberViewWindow[0] = new StringBuffer(str);
    }

    public void setEqualTo() {
        if ((numberViewWindow[0] == null) ||
                numberViewWindow[0].toString().equals("")) return;
        String str = counter.toString();
        counter.delete(0, counter.length());
        String EQUAL = "=";
        if (((numberViewWindow[1].toString()).equals("\u221a")) ||
                ((numberViewWindow[1].toString()).equals("x\u00B2"))) {
            numberViewWindow[2] = new StringBuffer(EQUAL);
            calculationsMulti();
        } else {
            if (str.equals("")) return;
            numberViewWindow[3] = new StringBuffer(EQUAL);
            numberViewWindow[2] = new StringBuffer(str);
            calculations();
        }
        equal = true;
    }

    public String getCounter() {
        return counter.toString();
    }

    public ArrayList<String> getNumberViewWindowForSave() {
        ArrayList<String> str = new ArrayList(5);
        for (int i = 0; i < numberViewWindow.length; i++) {
            if (numberViewWindow[i] == null) numberViewWindow[i] = new StringBuffer("");
            str.add(numberViewWindow[i].toString());
        }

        return str;
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
                if (x == 0) return;
                counter.append((x / y));
                break;
            case "\u221a":
                counter.append((Math.sqrt(x)));
                break;
            case "x\u00B2":
                counter.append((x * x));
                break;
        }
        numberViewWindow[4] = new StringBuffer(counterDelete(counter).toString());
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
        numberViewWindow[3] = new StringBuffer(counterDelete(counter).toString());
    }

    private void checkBooleanEqual() {
        if (equal) {
            cleanNumberViewWindow();
            equal = false;
        }
    }

    private StringBuffer counterDelete(StringBuffer counter) {
        if (counter.length() >= LIMITED) {
            counter.delete(LIMITED, counter.length());
            return counter;
        }
        return counter;
    }
}