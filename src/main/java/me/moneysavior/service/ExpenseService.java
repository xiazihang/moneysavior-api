package me.moneysavior.service;

import me.moneysavior.model.Expenses;

public interface ExpenseService {
    Expenses getExpensesByUserId(int userId);
}
