package Main;

import java.io.IOException;

import ComplexityAnalyzer.Analyzer;
import FileReader.ReadClassFromProject;

public class Main {

	
	public static void main(String[] args) throws IOException {
		
		ReadClassFromProject rcfp = new ReadClassFromProject();
		
		//rcfp.printStatements();
		
		Analyzer a = new Analyzer( rcfp.readStatementsFromAClass("F:\\EclipseWork\\Cyclometic_Complexity\\src\\input\\code.java") );
		
		a.startStatementAnalysis( );
		
	}
	
}
