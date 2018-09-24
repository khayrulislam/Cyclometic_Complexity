package FileReader;

public class Statement {

	private String statement;
	private int statementLineNumber;
	private String statementType;
	
	
	public Statement(String statement, int statementLineNumber) {
		this.statement = statement;
		this.statementLineNumber = statementLineNumber;
	}


	public String getStatement() {
		return statement;
	}


	public int getStatementLineNumber() {
		return statementLineNumber;
	}


	public String getStatementType() {
		return statementType;
	}


	public void setStatement(String statement) {
		this.statement = statement;
	}


	public void setStatementLineNumber(int statementLineNumber) {
		this.statementLineNumber = statementLineNumber;
	}


	public void setStatementType(String statementType) {
		this.statementType = statementType;
	}
	
	
	
}
