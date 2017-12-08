package me.moneysavior.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY;

@ApiModel
@JsonInclude(NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Expense {
    @NotNull
    private ExpenseData data;

    public ExpenseData getData() {
        return data;
    }

    public void setData(ExpenseData data) {
        this.data = data;
    }

    public static final class ExpenseData {
        @NotNull
        private ExpenseAttributes attributes;

        public ExpenseAttributes getAttributes() {
            return attributes;
        }

        public void setAttributes(ExpenseAttributes attributes) {
            this.attributes = attributes;
        }

        public static final class ExpenseAttributes {
            @ApiModelProperty(value = "associated user id")
            private Integer userId;
            @ApiModelProperty(value = "expense occur date")
            private Date occurDate;
            @ApiModelProperty(value = "expense type")
            private String expenseType;
            @ApiModelProperty(value = "expense amount")
            private Integer amount;
            @ApiModelProperty(value = "expense description")
            private String description;

            public Integer getUserId() {
                return userId;
            }

            public void setUserId(Integer userId) {
                this.userId = userId;
            }

            public Date getOccurDate() {
                return occurDate;
            }

            public void setOccurDate(Date occurDate) {
                this.occurDate = occurDate;
            }

            public String getExpenseType() {
                return expenseType;
            }

            public void setExpenseType(String expenseType) {
                this.expenseType = expenseType;
            }

            public Integer getAmount() {
                return amount;
            }

            public void setAmount(Integer amount) {
                this.amount = amount;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }
    }
}
