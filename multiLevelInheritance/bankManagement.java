package multiLevelInheritance;

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * (interestRate / 100);
        deposit(interest);
        System.out.println("Interest Applied: " + interest);
    }
}

class PremiumSavingsAccount extends SavingsAccount {
    private double premiumBonus;

    public PremiumSavingsAccount(String accountNumber, double balance, double interestRate, double premiumBonus) {
        super(accountNumber, balance, interestRate);
        this.premiumBonus = premiumBonus;
    }

    public double getPremiumBonus() {
        return premiumBonus;
    }

    public void setPremiumBonus(double premiumBonus) {
        this.premiumBonus = premiumBonus;
    }

    public void applyPremiumBonus() {
        deposit(premiumBonus);
        System.out.println("Premium Bonus Added: " + premiumBonus);
    }

    public void fixedDeposit(double amount, int years) {
        double maturityAmount = amount * Math.pow((1 + getInterestRate() / 100), years);
        System.out.println("Fixed Deposit of " + amount + " for " + years + " years will mature to: " + maturityAmount);
    }
}

class bankManagement {
    public static void main(String[] args) {
        PremiumSavingsAccount psa = new PremiumSavingsAccount("ACC12345", 10000, 5, 500);
        System.out.println("Account Number: " + psa.getAccountNumber());
        System.out.println("Initial Balance: " + psa.getBalance());
        psa.deposit(2000);
        psa.withdraw(1500);
        psa.applyInterest();
        psa.applyPremiumBonus();
        psa.fixedDeposit(5000, 3);
    }
}
