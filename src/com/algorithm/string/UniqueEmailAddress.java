package com.algorithm.string;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
    public static void main(String[] args) {
        String[] emails = {"test.email+james@coding.com", "test.e.mail+toto@coding.com", "testemail+tom@codi.ing.com", "test@testcom", "a@coding.com", "b@coding.com"};
        UniqueEmailAddress uniqueEmailAddress = new UniqueEmailAddress();
        System.out.println(uniqueEmailAddress.solve(emails));
    }

    public int solve(String[] emails) {
        Set<String> validEmails = new HashSet<>();
        for (String email : emails) {
            String[] arr = email.split("@");
            if (arr.length == 2) {
                String filteredEmail = getFilterEmail(arr[0], arr[1]);
                if (!filteredEmail.isEmpty()) validEmails.add(filteredEmail);
            }
        }
        return validEmails.size();
    }

    private String getFilterEmail(String lName, String dName) {
        String domainName = makeDomainName(dName);
        if (domainName.isEmpty()) return "";

        return makeDomainName(lName) + "@" + makeDomainName(dName);
    }

    private String makeLocalName(String name) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == '.') {
                continue;
            }
            if (name.charAt(i) == '+') {
                break;
            }
            sb.append(name.charAt(i));
        }
        return sb.toString();
    }

    private String makeDomainName(String name) {
        return (name.contains(".")) ? name : "";
    }
}
