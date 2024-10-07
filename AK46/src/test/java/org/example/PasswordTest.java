package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PasswordTest {
    @Test
    public void testValidPassword() {
        Assert.assertTrue(CheckPassword.isPassword("Password1!"), "Valid password should pass.");
    }

    @Test
    public void testPasswordTooShort() {
        Assert.assertFalse(CheckPassword.isPassword("Pass1!"), "Password is too short.");
    }

    @Test
    public void testNoNumber() {
        Assert.assertFalse(CheckPassword.isPassword("Password!"), "Password should have at least one number.");
    }

    @Test
    public void testNoLowercase() {
        Assert.assertFalse(CheckPassword.isPassword("PASSWORD1!"), "Password should have at least one lowercase letter.");
    }

    @Test
    public void testNoUppercase() {
        Assert.assertFalse(CheckPassword.isPassword("password1!"), "Password should have at least one uppercase letter.");
    }

    @Test
    public void testNoSpecialCharacter() {
        Assert.assertFalse(CheckPassword.isPassword("Password1"), "Mật khẩu phải có ít nhất một ký tự đặc biệt.");
    }


    @Test
    public void testEmptyPassword() {
        Assert.assertFalse(CheckPassword.isPassword(""), "Empty password should be invalid.");
    }

    @Test
    public void testOnlyNumbers() {
        Assert.assertFalse(CheckPassword.isPassword("123456789"), "Password with only numbers should be invalid.");
    }

    @Test
    public void testOnlyLowercase() {
        Assert.assertFalse(CheckPassword.isPassword("lowercase"), "Password with only lowercase letters should be invalid.");
    }

    @Test
    public void testOnlyUppercase() {
        Assert.assertFalse(CheckPassword.isPassword("UPPERCASE"), "Password with only uppercase letters should be invalid.");
    }

    @Test
    public void testOnlySpecialCharacters() {
        Assert.assertFalse(CheckPassword.isPassword("!@#$%^&*()"), "Password with only special characters should be invalid.");
    }
}
