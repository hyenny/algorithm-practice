package com.algorithm.string;


public class LicenseKeyFormatting {
    public static void main(String[] args) {
        LicenseKeyFormatting licenseKeyFormatting = new LicenseKeyFormatting();
        String s = "8F3Z-2e-9-w45awQWer-1";
        //String s = "8-5g-3-j";
        int k = 4;
        System.out.println(licenseKeyFormatting.solve(s, k));
    }

    public String solve(String s, int k) {
        String newStr = s.replace("-", "").toUpperCase();
        return format(newStr, k);
    }

    private String format(String str, int key) {
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        for (int i = key; i < length; i = i + key) {
            sb.insert(length - i, "-");
        }
        return sb.toString();
    }
}
