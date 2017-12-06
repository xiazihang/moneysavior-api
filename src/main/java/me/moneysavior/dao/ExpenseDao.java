package me.moneysavior.dao;

import me.moneysavior.entity.ExpenseEntity;

import java.util.List;

public interface ExpenseDao {
    List<ExpenseEntity> getExpensesByUserId(int userId);
}
