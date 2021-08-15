package com.algorithm.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * [프로그래머스] 전화번호 목록
 */
public class PhoneBookList {
    public static void main(String[] args) {
        //String[] phone_book = {"12", "123", "1235", "567", "88"};
        //String[] phone_book= {"123", "456", "789"};
        String[] phone_book = {"119", "97674223", "1195524421"};
        PhoneBookList phoneBookList = new PhoneBookList();
        System.out.println(phoneBookList.solution3(phone_book));
    }

    // 시간 초과인 케이스가 있음 => 최적화 필요
    public boolean solution1(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length; i++) {
            String prefix = phone_book[i];
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(prefix)) {
                    return false;
                }
            }
        }
        return true;
    }

    // 효율성 테스트에서 계속 실패
    public boolean solution2(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        int length = phone_book.length;
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(phone_book[i])) {
                map.put(phone_book[i], i);
            }
        }

        Arrays.sort(phone_book);
        for (int i = 0; i < length; i++) {
            String prefix = phone_book[i];
            int prefixLength = prefix.length();
            for (int j = i + 1; j < length; j++) {
                if (phone_book[j].length() <= prefixLength)
                    continue;

                String key = phone_book[j].substring(0, prefixLength);
                if (map.containsKey(key))
                    return false;
            }
        }
        return true;
    }

    // 정확성: 83.3, 효율성: 16.7, 합계: 100.0 / 100.0
    public boolean solution3(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        int length = phone_book.length;
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(phone_book[i])) {
                map.put(phone_book[i], i);
            }
        }

        Arrays.sort(phone_book);
        // [12, 123, 1235, 567, 88] : 정렬이 되었으므로 접두어(현재 전화번호)와 전화번호(다음 전화번호)만 비교하면 됨
        for (int i = 0; i < length - 1; i++) {
            String prefix = phone_book[i];
            String phone = phone_book[i + 1];

            // 접두어의 길이가 전화번호 길이보다 크면 substring 시 에러
            if (phone.length() <= prefix.length())
                continue;

            String key = phone.substring(0, prefix.length());
            if (map.containsKey(key))
                return false;
        }
        return true;
    }

}
