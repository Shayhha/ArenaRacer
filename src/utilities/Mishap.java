package utilities;

import java.text.DecimalFormat;

public class Mishap {
    private boolean fixable;
    private double reductionFactor;
    private int turnsToFix;

    public Mishap(boolean fixable, int turnsToFix, double reductionFactor) {
        this.fixable = fixable;
        this.turnsToFix = turnsToFix;
        this.reductionFactor = reductionFactor;
    }

    public void nextTurn() {
        if (fixable) {
            setTurnsToFix(this.getTurnsToFix() - 1);
        }
    }

    // getters
    public boolean getFixable() {
        return this.fixable;
    }

    public double getReductionFactor() {
        return this.reductionFactor;
    }

    public int getTurnsToFix() {
        return this.turnsToFix;
    }

    // setters
    public boolean setFixable(boolean value) {
        this.fixable = value;
        return true;
    }

    public boolean setReductionFactor(double value) {
        if (value >= 0) {
            this.reductionFactor = value;
            return true;
        }
        return false;
    }

    public boolean setTurnsToFix(int value) {
        if (value >= 0) {
            this.turnsToFix = value;
            return true;
        }
        return false;
    }

    public String toString() {
        DecimalFormat formatter = new DecimalFormat("0.00");
        return "( " + this.getFixable() + ", " + this.getTurnsToFix() + ", " + formatter.format(this.getReductionFactor()) + " )";
    }

