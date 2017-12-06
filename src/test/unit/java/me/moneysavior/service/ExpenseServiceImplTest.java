package me.moneysavior.service;

import me.moneysavior.builder.ExpenseEntityBuilder;
import me.moneysavior.dao.ExpenseDao;
import me.moneysavior.entity.ExpenseEntity;
import me.moneysavior.model.Expenses;
import me.moneysavior.translator.ExpenseTranslator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static com.google.common.collect.ImmutableList.of;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExpenseServiceImplTest {
    private static final int USER_ID = 123;
    private final ExpenseEntityBuilder expenseEntityBuilder = new ExpenseEntityBuilder();

    @InjectMocks
    private ExpenseService expenseService = new ExpenseServiceImpl();

    @Mock
    private ExpenseDao expenseDao;

    @Mock
    private ExpenseTranslator expenseTranslator;

    @Test
    public void shouldDelegateToExpenseDaoToGetExpenses() throws Exception {
        List<ExpenseEntity> expenseEntities = of(expenseEntityBuilder.withDefault().build());
        when(expenseDao.getExpensesByUserId(USER_ID)).thenReturn(expenseEntities);
        when(expenseTranslator.translateToUsers(expenseEntities)).thenReturn(new Expenses());
        expenseService.getExpensesByUserId(USER_ID);
        verify(expenseDao).getExpensesByUserId(USER_ID);
        verify(expenseTranslator).translateToUsers(expenseEntities);
    }
}