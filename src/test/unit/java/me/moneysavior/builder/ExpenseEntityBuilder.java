package me.moneysavior.builder;

import me.moneysavior.entity.ExpenseEntity;
import me.moneysavior.entity.UserEntity;

import java.util.Date;

public class ExpenseEntityBuilder {
    public static final int AMOUNT = 1000;
    public static final String DESCRIPTION = "description";
    public static final String EXPENSE_TYPE = "expenseType";
    private UserEntity userEntity;
    private Date occurDate;
    private Integer amount;
    private String expenseType;
    private String description;
    private UserEntityBuilder userEntityBuilder = new UserEntityBuilder();

    public ExpenseEntity build() {
        ExpenseEntity expenseEntity = new ExpenseEntity();
        expenseEntity.setUser(userEntity);
        expenseEntity.setOccurDate(occurDate);
        expenseEntity.setAmount(amount);
        expenseEntity.setExpenseType(expenseType);
        expenseEntity.setDescription(description);

        return expenseEntity;
    }

    public ExpenseEntityBuilder withDefault() {
        this.userEntity = userEntityBuilder.withDefault().build();
        this.occurDate = new Date();
        this.amount = AMOUNT;
        this.expenseType = EXPENSE_TYPE;
        this.description = DESCRIPTION;
        return this;
    }

}
