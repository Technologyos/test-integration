package com.technologyos.unittest.models;

import com.technologyos.unittest.exceptions.InsufficientMoneyException;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class Account {
   @EqualsAndHashCode.Include
   @NotNull
   private User user;

   @EqualsAndHashCode.Include
   @NotNull
   private BigDecimal balance;

   private Bank bank;

   public Account(User user, BigDecimal balance) {
      this.user = user;
      this.balance = balance;
   }

   public void debit(BigDecimal amount){
      BigDecimal newBalance = this.balance.subtract(amount);
      if (newBalance.compareTo(BigDecimal.ZERO) < 0){
         throw new InsufficientMoneyException("Insufficient Money");
      }
      this.balance = newBalance;
   }

   public void credit(BigDecimal amount){
      this.balance = this.balance.add(amount);
   }
}
