# loan-repayment
A loan repayment calculator with java

This is a loan repayment plan calculator by Cemil Aydogdu.
https://github.com/caydogdu/loan-repayment

These are the main ability of project
- Ability to calculate a repayment plan for an annuity loan

This project was developed with spring boot. 
Java 8 is required.
No database was used.

There are 2 interfaces to calculate loan repayment plan
Loan : to calculate loan
RepaymentPlan : to calculate repayment plan

If you need more loan and repayment plan implementations you can use these interfaces.

Here is sample use

LoanRequestDTO loanRequestDTO = new LoanRequestDTO();
loanRequestDTO.setLoanAmount(new BigDecimal(5000));
loanRequestDTO.setDuration(24);
loanRequestDTO.setNominalRate(5);
loanRequestDTO.setStartDate("01.01.2018");

Loan loan = new AnnuityLoan(loanRequestDTO);
RepaymentPlan repaymentPlan = new AnnuityRepaymentPlan(loan);
RepaymentPlanDTO planDTO = repaymentPlan.calculate();

There is a REST Service in this project.
1) To generate a loan repayment plan
POST localhost:8081/generate-plan with body
{
	"loanAmount": 5000,
	"nominalRate": 5,
	"duration": 24,
	"startDate": "01.01.2018"
}

------------------------------------------------------------------

Run options and deployment

This project is a microservice. So you can easily run it.

1- Running as a packaged application
If you use the Spring Boot Maven or Gradle plugins first create an executable jar then you can run your application using java -jar. For example:
$ java -jar target/loan-0.0.1-SNAPSHOT.jar
It is also possible to run a packaged application with remote debugging support enabled. This allows you to attach a debugger to your packaged application:

You can also run it with executing the main class (com.lendico.loan.Application)

2- Using the Maven plugin
The Spring Boot Maven plugin includes a run goal which can be used to quickly compile and run your application. Applications run in an exploded form just like in your IDE.

$ mvn spring-boot:run
