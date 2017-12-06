package me.moneysavior.dao;

import me.moneysavior.entity.ExpenseEntity;
import me.moneysavior.repository.ExpenseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.google.common.collect.ImmutableList.of;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExpenseDaoImplTest {
    public static final int USER_ID = 123;
    @InjectMocks
    private ExpenseDao expenseDao = new ExpenseDaoImpl();

    @Mock
    private ExpenseRepository expenseRepository;

    @Test
    public void shouldDelegateToRepositoryToGetExpenses() throws Exception {
        when(expenseRepository.findByUserId(USER_ID)).thenReturn(of(new ExpenseEntity()));
        expenseDao.getExpensesByUserId(USER_ID);
        verify(expenseRepository).findByUserId(USER_ID);
    }
}