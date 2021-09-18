package za.ac.nwu.ac.logic.flow.impl;

public class Modulo {
    public Integer doMod(int dividend, int divisor) throws Exception {
        if (divisor == 0){
            throw new Exception("Some reason");
        }
        return dividend % divisor;
    }
}
