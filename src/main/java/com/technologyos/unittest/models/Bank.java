package com.technologyos.unittest.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Bank {
   private List<Account> accounts = new ArrayList<>();
   private String name;

   public void addAccount(Account account){
      accounts.add(account);
      account.setBank(this);
   }

   public void transfer(Account accountOrigen, Account accountDestination, BigDecimal amount){
      accountOrigen.debit(amount);
      accountDestination.credit(amount);
   }
}
