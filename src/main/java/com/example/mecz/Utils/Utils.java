package com.example.mecz.Utils;

import java.util.Random;

public class Utils {

        public static int draw(int minimum, int maximum) {
            Random rn = new Random();
            return rn.nextInt(maximum - minimum + 1) + minimum;
        }
}
