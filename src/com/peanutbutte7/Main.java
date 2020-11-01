package com.peanutbutte7;

import java.util.Arrays;
import java.util.List;

public class Main {
    static int[] opcodes = {1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,6,19,1,9,19,23,2,23,10,27,1,27,5,31,1,31,6,35,1,6,35,39,2,39,13,43,1,9,43,47,2,9,47,51,1,51,6,55,2,55,10,59,1,59,5,63,2,10,63,67,2,9,67,71,1,71,5,75,2,10,75,79,1,79,6,83,2,10,83,87,1,5,87,91,2,9,91,95,1,95,5,99,1,99,2,103,1,103,13,0,99,2,14,0,0};

    public static void main(String[] args) {
        opcodes[1] = 12;
        opcodes[2] = 2;
        run();
        System.out.println(opcodes[0]);
    }

    static void run(){
        for(int i = 0; i < opcodes.length; i += 4){
            int opcode = opcodes[i];

            if (opcode == 99){
                break;
            } else if (opcode == 1){
                opcodes[opcodes[i + 3]] = add(opcodes[i+1], opcodes[i+2]);
            } else if (opcode == 2) {
                opcodes[opcodes[i + 3]] = multiply(opcodes[i+1], opcodes[i+2]);
            } else {
                throw new IllegalArgumentException("Unknow opcode");
            }
        }
    }

    static int multiply(int posA, int posB){
        return opcodes[posA] * opcodes[posB];
    }

    static int add(int posA, int posB){
        return opcodes[posA] + opcodes[posB];
    }
}
