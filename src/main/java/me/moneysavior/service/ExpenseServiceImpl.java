package me.moneysavior.service;

import me.moneysavior.dao.ExpenseDao;
import me.moneysavior.entity.ExpenseEntity;
import me.moneysavior.model.Expenses;
import me.moneysavior.translator.ExpenseTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    @Autowired
    private ExpenseDao expenseDao;

    @Autowired
    private ExpenseTranslator expenseTranslator;

    @Override
    public Expenses getExpensesByUserId(int userId) {
        List<ExpenseEntity> expenseEntityList = expenseDao.getExpensesByUserId(userId);
        return expenseTranslator.translateToUsers(expenseEntityList);
    }
}
