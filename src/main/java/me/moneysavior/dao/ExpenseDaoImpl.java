package me.moneysavior.dao;

import me.moneysavior.entity.ExpenseEntity;
import me.moneysavior.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExpenseDaoImpl implements ExpenseDao {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<ExpenseEntity> getExpensesByUserId(int userId) {
        return expenseRepository.findByUserId(userId);
    }
}
