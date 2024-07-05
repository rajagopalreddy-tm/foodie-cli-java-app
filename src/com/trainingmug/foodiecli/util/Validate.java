package com.trainingmug.foodiecli.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Validate {

    private static final Pattern ID_PATTERN = Pattern.compile("^[A-Z][A-Za-z]*\\d{1,29}$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z]{3,10}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^[A-Za-z0-9]{5,10}$");
    private static final Pattern DESCRIPTION_PATTERN = Pattern.compile("^[A-Za-z]{3,10}$");
    private static final Pattern PRICE_PATTERN = Pattern.compile("^\\d{1,4}(\\.\\d{1,2})?$");
    private static final Pattern MENU_PATTERN = Pattern.compile("^(D\\d{3})(,D\\d{3})*$");

    public Map<String, String> validateId(String id) {
        Map<String, String> validationResult = new HashMap<>();
        if (isEmpty(id)) {
            validationResult.put("Id", "Id should not be empty!");
        } else if (!isIdPattern(id)) {
            validationResult.put("Id", "Id should start with an alphabet and contain 2-30 characters. ex: C001");
        } else {
            validationResult.put("Id", "1");
        }
        return validationResult;
    }

    public Map<String, String> validateName(String name) {
        Map<String, String> validationResult = new HashMap<>();
        if (isEmpty(name)) {
            validationResult.put("Name", "Name should not be empty!");
        } else if (!isNamePattern(name)) {
            validationResult.put("Name", "Name should contain 3-10 alphabetic characters.");
        } else {
            validationResult.put("Name", "1");
        }
        return validationResult;
    }

    public Map<String, String> validateEmail(String email) {
        Map<String, String> validationResult = new HashMap<>();
        if (isEmpty(email)) {
            validationResult.put("Email", "Email should not be empty!");
        } else if (!isEmailPattern(email)) {
            validationResult.put("Email", "Email should be a valid email address.");
        } else {
            validationResult.put("Email", "1");
        }
        return validationResult;
    }

    public Map<String, String> validatePassword(String password) {
        Map<String, String> validationResult = new HashMap<>();
        if (isEmpty(password)) {
            validationResult.put("Password", "Password should not be empty!");
        } else if (!isPasswordPattern(password)) {
            validationResult.put("Password", "Password should be alphanumeric and contain 5-10 characters.");
        } else {
            validationResult.put("Password", "1");
        }
        return validationResult;
    }

    public Map<String, String> validateDescription(String description) {
        Map<String, String> validationResult = new HashMap<>();
        if (isEmpty(description)) {
            validationResult.put("Description", "Description should not be empty!");
        } else if (!isDescriptionPattern(description)) {
            validationResult.put("Description", "Description should contain 3-10 alphabetic characters.");
        } else {
            validationResult.put("Description", "1");
        }
        return validationResult;
    }

    public Map<String, String> validatePrice(String price) {
        Map<String, String> validationResult = new HashMap<>();
        if (isEmpty(price)) {
            validationResult.put("Price", "Price should not be empty!");
        } else if (!isPricePattern(price)) {
            validationResult.put("Price", "Price should be a digit (double) and contain 1-4 digits.");
        } else {
            validationResult.put("Price", "1");
        }
        return validationResult;
    }

    public Map<String, String> validateMenu(String menu) {
        Map<String, String> result = new HashMap<>();
        if (isEmpty(menu)) {
            result.put("menu", "Menu should not be empty!");
        } else if (!isMenuPattern(menu)) {
            result.put("menu", "Invalid menu format! Menu should contain comma-separated dish IDs like D001,D003....");
        }
        return result;
    }

    private boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    private boolean isIdPattern(String value) {
        return ID_PATTERN.matcher(value).matches();
    }

    private boolean isNamePattern(String value) {
        return NAME_PATTERN.matcher(value).matches();
    }

    private boolean isEmailPattern(String value) {
        return EMAIL_PATTERN.matcher(value).matches();
    }

    private boolean isPasswordPattern(String value) {
        return PASSWORD_PATTERN.matcher(value).matches();
    }


    private boolean isDescriptionPattern(String value) {
        return DESCRIPTION_PATTERN.matcher(value).matches();
    }

    private boolean isPricePattern(String value) {
        return PRICE_PATTERN.matcher(value).matches();
    }

    private boolean isMenuPattern(String value) {
        return MENU_PATTERN.matcher(value).matches();
    }

}