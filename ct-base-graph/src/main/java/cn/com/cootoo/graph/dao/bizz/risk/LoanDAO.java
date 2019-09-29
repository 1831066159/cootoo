package cn.com.cootoo.graph.dao.bizz.risk;


import cn.com.cootoo.graph.model.bizz.risk.Loan;

public interface LoanDAO {


//    @SQL(SELECT + " WHERE loan_id =:1")
    Loan getByLoanId(String loanid);

}
