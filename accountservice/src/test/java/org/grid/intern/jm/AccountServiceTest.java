package org.grid.intern.jm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class AccountServiceTest {

    private AccountService service;

    @BeforeEach
    public void setup() {
        Account[] accounts = new Account[]{
                new Account(33542908, 18745, new User(47873831, "Anthony", "Doe")),
                new Account(23413090, 13273, new User(89423831, "Jekyll", "Blake")),
                new Account(23663090, 689579, new User(89534789, "Rowan", "Creed")),
                new Account(55413896, 79570, new User(13234703, "Maria", "Jones")),
                new Account(99813090, 9069578, new User(98870932, "Rowena", "Bloom")),
        };
        service = new AccountServiceImpl(accounts);
    }

    @Test
    public void testReturnsAccountIfFound() {
        Account found = service.findAccountByOwnerId(89534789);
        Assertions.assertNotNull(found, "Account not Found");
    }

    @Test
    public void testReturnsNullIfAccountNotFound() {
        Account found = service.findAccountByOwnerId(9981090);
        Assertions.assertNull(found, "Account found");
    }

    @Test
    public void testReturnsZeroIfNoAccountsFoundExceedingBalance() {
        Assertions.assertEquals(0, service.countAccountsWithBalanceGreaterThan(80000000));
    }

    @Test
    public void testReturnsNumberOfAccountsFoundExceedingBalance() {
        Assertions.assertEquals(4, service.countAccountsWithBalanceGreaterThan(16000));
    }

    @Test
    public void testReturnsAccountsFoundExceedingBalance() {
        Assertions.assertEquals(3, service.countAccountsWithBalanceGreaterThan(20000));
    }

    @Test
    public void testThrowsIllegalArgumentExceptionDuplicateAccountIds() {
        Account[] duplicateAccountIDSet = new Account[]{
                new Account(23862890, 469574, new User(56878452, "Thomas", "Blake")),
                new Account(41374278, 18745, new User(48538389, "Anthony", "Doe")),
                new Account(23862890, 4623273, new User(76243831, "Jekyll", "Blake")),
        };
        Exception exception = assertThrowsExactly(IllegalArgumentException.class, () -> new AccountServiceImpl(duplicateAccountIDSet));
        System.out.println(exception.getMessage());
        assertEquals("  Duplicate Account ID: 23862890 at indices [0] and [2]".trim(), exception.getMessage().trim());
    }

    @Test
    public void testThrowsIllegalArgumentExceptionDuplicateUserIds() {
        Account[] duplicateUserIDSet = new Account[]{
                new Account(37653408, 1328745, new User(89568831, "Anthony", "Doe")),
                new Account(39429308, 18745, new User(48923832, "Bailey", "Holmer")),
                new Account(23496090, 4623273, new User(48923832, "Mina", "Jokil")),
        };
        Exception exception = assertThrowsExactly(IllegalArgumentException.class, () -> new AccountServiceImpl(duplicateUserIDSet));
        assertEquals("Duplicate User ID: 48923832 at indices [1] and [2]".trim(), exception.getMessage().trim());
    }

    @Test
    public void testThrowsIllegalArgumentExceptionDuplicateAccountandUserIds() {
        Account[] duplicateIDSet = new Account[]{
                new Account(33542908, 1328745, new User(23659034, "Anthony", "Doe")),
                new Account(23862890, 469574, new User(87886324, "Thomas", "Blake")),
                new Account(33542908, 18745, new User(87886324, "Anthony", "Doe")),
        };
        Exception exception = assertThrowsExactly(IllegalArgumentException.class, () -> new AccountServiceImpl(duplicateIDSet));
        String expected = "Duplicate Account ID: 33542908 at indices [0] and [2]\nDuplicate User ID: 87886324 at indices [1] and [2]";
        assertEquals(expected.trim(), exception.getMessage().trim());
    }
}
