package polymorphism;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private String city;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, String city, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.city = city;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getCity() {
        return city;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Compile time polumorphism
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    public void deposit(double amount, String source) {
        balance += amount;
        System.out.println("Deposited: " + amount + " from " + source + ", New Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void accountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("City: " + city);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolderName, String city, double balance,
            double interestRate) {
        super(accountNumber, accountHolderName, city, balance);
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

    // Runtime Polymorphism
    @Override
    public void accountInfo() {
        super.accountInfo();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class PremiumSavingsAccount extends SavingsAccount {
    private double premiumBonus;

    public PremiumSavingsAccount(String accountNumber, String accountHolderName, String city, double balance,
            double interestRate, double premiumBonus) {
        super(accountNumber, accountHolderName, city, balance, interestRate);
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

    // Runtime Polymorphism
    @Override
    public void accountInfo() {
        super.accountInfo();
        System.out.println("Premium Bonus: " + premiumBonus);
    }
}
class BankManagement {
    public static void main(String[] args) {
        BankAccount basicAccount = new BankAccount("ACC1001", "Virat", "Delhi", 5000);
        SavingsAccount savings = new SavingsAccount("ACC2001", "Mahi", "Ranchi", 10000, 5);
        PremiumSavingsAccount psa = new PremiumSavingsAccount("ACC3001", "Rahul", "Bengaluru", 20000, 6, 1000);

        System.out.println("\n--- Basic Account Info ---");
        basicAccount.accountInfo();

        System.out.println("\n--- Savings Account Info ---");
        savings.accountInfo();
        savings.applyInterest();

        System.out.println("\n--- Premium Savings Account Info ---");
        psa.accountInfo();
        psa.deposit(5000, "Online Transfer");
        psa.withdraw(3000);
        psa.applyPremiumBonus();
        psa.fixedDeposit(10000, 3);
    }
}
