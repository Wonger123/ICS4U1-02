package unit3.inheritance.bankAccount;

/* Instructions:
Make a BankAccount class and everything else needed to get the output provided from a BankTest program like the one below.
You can format your output differently if desired (making it better, not worse).

It will have a static arraylist that keeps track of the bank accounts (ie. bank account numbers)
It has almost all of the functionality that is needed (methods and variables)
private instance variables: balance, account#, and name
Some methods will have to be static methods.    

Each bank account number  = bank transit number + random 5 digit account number.

The savings account has a monthly service fee of $0 and and monthly interest rate of 4%.
The chequing account has a monthly service fee of $2.67 and and monthly interest rate of 1%.
At the end of the month, the bank runs a program (method) to add the fees and interest to each account.

If you close an account and there is money still in it, the bank gladly takes the money.
*/

/* How to handle money:
1. Money is entered as dollars and cents (eg. $10.25).  This means that it is entered as double.
2. Money is stored as int. This means that it is stored in cents. All money entered is multiplied by 100 before processing.
3. So all money printed out must be divided by 100 before printing.
*/

/*  The following are ILLEGAL. My classes are set up to prevent this:
	
BankAccount.transitNumber = "12345";	//changing the branch number
acct1.balance = 10000;	//changing balance directly
BankAccount acct7 = new BankAccount("Kim Cook");	//making a BankAccount object. You must make a SavingsAccount or ChequingAccount
SavingsAccount acct8 = new SavingsAccount();	//making an account with no customer name
acct1.withdraw(100000.41);	//withdrawing more money than you have
acct1.transfer(...	//transfering more money than you have in your account
			//transfering money to a nonexistent account	

Writing a hacked deposit function that adds $900 to any deposit!:
You cannot make a subclass of BankAccount or SavingsAccount and write this messed up function
to override the correct deposit function in BankAccount.

    void deposit(double cash) {
            super.deposit(cash+9000.00);               
     }

*/

//Here's my BankTest program.
public class BankTest {
	
	public static void main(String[] args) {
		
		SavingsAccount acct1 = new SavingsAccount("John Smith");
		BankAccount acct2 = new SavingsAccount("Sandra Jones", 5200.00);
		ChequingAccount acct3 = new ChequingAccount("Amanda Peet", 511.32);

		BankAccount.listActNums();
		BankAccount.listActs();

		acct1.deposit(400.00);
		acct2.withdraw(344.33);

		System.out.println("\n*** Printing balance for account #3:");
		acct3.printBalance();

		acct2.transfer(acct1, 600.00);
		acct1.transfer(acct1, 150.00); // this will give an error message. You can't transfer money to yourself.

		int JSmith_number = BankAccount.getAccountNum("John Smith");
		acct2.transfer(JSmith_number, 50.00); // see if I can do a transfer based on bank account number rather than
												// account object

		BankAccount.listActs();

		BankAccount.endOfMonth();

		acct3 = acct3.close();
		BankAccount.listActNums();
		BankAccount.listActs();

	}
}